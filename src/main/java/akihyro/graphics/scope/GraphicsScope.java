package akihyro.graphics.scope;

import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;

/**
 * グラフィックススコープ。
 */
public abstract class GraphicsScope implements AutoCloseable {

    /**
     * グラフィックス。
     */
    @Getter
    private final Graphics2D graphics;

    /**
     * コンストラクタ。
     *
     * @param graphics グラフィックス。
     */
    public GraphicsScope(@NonNull Graphics2D graphics) {
        this.graphics = graphics;
    }

    /**
     * スコープを開始する。
     *
     * @return 自身のインスタンス。
     */
    public abstract GraphicsScope begin();

    /**
     * スコープを終了する。
     *
     * @return 自身のインスタンス。
     */
    public abstract GraphicsScope end();

    /** {@inheritDoc} */
    @Override
    public void close() {
        end();
    }

}
