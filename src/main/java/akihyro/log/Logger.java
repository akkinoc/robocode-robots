package akihyro.log;

import java.text.MessageFormat;
import java.util.Date;

import lombok.NonNull;

import akihyro.AbstractRobot;

/**
 * ロガー。
 */
public class Logger {

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
    public Logger(@NonNull AbstractRobot robot) {
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
     */
    public void startMethod() {
        record("start: %s", getCaller());
    }

    /**
     * メソッドの終了ログを記録する。
     */
    public void endMethod() {
        record("end  : %s", getCaller());
    }

    /**
     * 呼出し元を取得する。
     *
     * @return 呼出し元。
     */
    private String getCaller() {
        return new Exception().getStackTrace()[2].toString();
    }

}
