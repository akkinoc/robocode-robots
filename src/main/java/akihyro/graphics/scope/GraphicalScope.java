package akihyro.graphics.scope;

import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;

/**
 * グラフィカルスコープ。
 */
public abstract class GraphicalScope implements AutoCloseable {

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
    public GraphicalScope(@NonNull Graphics2D graphics) {
        this.graphics = graphics;
    }

    /**
     * スコープを開始する。
     *
     * @return 自身のインスタンス。
     */
    public abstract GraphicalScope begin();

    /**
     * スコープを終了する。
     *
     * @return 自身のインスタンス。
     */
    public abstract GraphicalScope end();

    /** {@inheritDoc} */
    @Override
    public void close() {
        end();
    }

}
