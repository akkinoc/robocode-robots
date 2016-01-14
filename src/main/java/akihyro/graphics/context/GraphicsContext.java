package akihyro.graphics.context;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import robocode.Robot;

/**
 * グラフィックスコンテキスト。
 */
@Data
@RequiredArgsConstructor
public class GraphicsContext {

    /**
     * グラフィックス。
     */
    @NonNull
    private final Graphics2D graphics;

    /**
     * サイズ。
     */
    @NonNull
    private final Size size;

    /**
     * コンストラクタ。
     *
     * @param robot ロボット。
     */
    public GraphicsContext(@NonNull Robot robot) {
        this(robot.getGraphics(), Size.of(robot.getBattleFieldWidth(), robot.getBattleFieldHeight()));
    }

}
