package akihyro.graphics.scope;

import akihyro.geom.Point;
import akihyro.graphics.context.GraphicsContext;
import lombok.Getter;
import lombok.NonNull;

/**
 * 平行移動変換を適用するグラフィカルスコープ。
 */
public class TranslateScope extends GraphicsScope {

    /**
     * 移動量。
     */
    @Getter
    private final Point offset;

    /**
     * コンストラクタ。
     *
     * @param context グラフィックスコンテキスト。
     * @param offset 移動量。
     */
    public TranslateScope(@NonNull GraphicsContext context, Point offset) {
        super(context);
        this.offset = offset;
    }

    /** {@inheritDoc} */
    @Override
    public TranslateScope begin() {
        context().graphics().translate(offset().x(), offset().y());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TranslateScope end() {
        context().graphics().translate(- offset().x(), - offset().y());
        return this;
    }

}
