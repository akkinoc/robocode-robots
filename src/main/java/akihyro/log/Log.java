package akihyro.log;

import java.text.MessageFormat;
import java.util.Date;

import lombok.NonNull;

import akihyro.AbstractRobot;
import akihyro.collection.IndexedElement;
import static akihyro.collection.IndexedIterable.withIndex;

/**
 * ログ。
 */
public class Log {

    /**
     * レコードフォーマット。
     */
    private static final MessageFormat RECORD_FORMAT = new MessageFormat(
            "[{0,number,00000}] [{1,time,HH:mm:ss.SSS}] {2}");

    /**
     * ロボット。
     */
    private final AbstractRobot robot;

    /**
     * コンストラクタ。
     *
     * @param robot ロボット。
     */
    public Log(@NonNull AbstractRobot robot) {
        this.robot = robot;
    }

    /**
     * ログを記録する。
     *
     * @param message メッセージ。
     * @param params パラメータ。
     */
    public void record(@NonNull String message, @NonNull Object... params) {
        String record = RECORD_FORMAT.format(new Object[] {
            robot.getTime(),
            new Date(),
            String.format(message, params),
        });
        robot.out.println(record);
    }

    /**
     * メソッドの開始ログを記録する。
     *
     * @param params パラメータ。
     */
    public void startMethod(@NonNull Object... params) {
        record("start: %s", getCaller());
        for (IndexedElement<Object> p : withIndex(params)) {
            record("-- %2d: %s", p.getIndex(), p.getValue());
        }
    }

    /**
     * メソッドの終了ログを記録する。
     */
    public void endMethod() {
        record("end  : %s", getCaller());
    }

    /**
     * 呼出し元を示すスタックトレース要素を取得する。
     *
     * @return 呼出し元を示すスタックトレース要素。
     */
    private StackTraceElement getCaller() {
        return new Exception().getStackTrace()[2];
    }

}
