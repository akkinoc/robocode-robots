package akihyro.graphics.scope;

import akihyro.geom.Point;
import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;

/**
 * 平行移動変換を適用するグラフィカルスコープ。
 */
public class TranslateScope extends GraphicalScope {

    /**
     * 移動量。
     */
    @Getter
    private final Point offset;

    /**
     * コンストラクタ。
     *
     * @param graphics グラフィックス。
     * @param offset 移動量。
     */
    public TranslateScope(@NonNull Graphics2D graphics, Point offset) {
        super(graphics);
        this.offset = offset;
    }

    /** {@inheritDoc} */
    @Override
    public TranslateScope begin() {
        graphics().translate(offset().x(), offset().y());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TranslateScope end() {
        graphics().translate(- offset().x(), - offset().y());
        return this;
    }

}
