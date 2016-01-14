package akihyro.graphics.context;

import java.awt.Graphics2D;
import lombok.Data;
import lombok.NonNull;

/**
 * グラフィックスコンテキスト。
 */
@Data
public class GraphicsContext {

    /**
     * グラフィックス。
     */
    private final Graphics2D graphics;

    /**
     * コンストラクタ。
     *
     * @param graphics グラフィックス。
     */
    public GraphicsContext(@NonNull Graphics2D graphics) {
        this.graphics = graphics;
    }

}
