package akihyro.graphics.scope;

import akihyro.graphics.context.GraphicsContext;
import lombok.Getter;
import lombok.NonNull;

/**
 * グラフィックススコープ。
 */
public abstract class GraphicsScope implements AutoCloseable {

    /**
     * グラフィックスコンテキスト。
     */
    @Getter
    private final GraphicsContext context;

    /**
     * コンストラクタ。
     *
     * @param context グラフィックスコンテキスト。
     */
    public GraphicsScope(@NonNull GraphicsContext context) {
        this.context = context;
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
