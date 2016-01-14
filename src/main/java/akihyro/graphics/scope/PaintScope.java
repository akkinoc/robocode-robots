package akihyro.graphics.scope;

import java.awt.Graphics2D;
import java.awt.Paint;
import lombok.Getter;
import lombok.NonNull;

/**
 * ペイントを適用するグラフィカルスコープ。
 */
public class PaintScope extends GraphicsScope {

    /**
     * ペイント。
     */
    @Getter
    private final Paint paint;

    /**
     * 適用前のペイント。
     */
    private Paint lastPaint;

    /**
     * コンストラクタ。
     *
     * @param graphics グラフィックス。
     * @param paint ペイント。
     */
    public PaintScope(@NonNull Graphics2D graphics, @NonNull Paint paint) {
        super(graphics);
        this.paint = paint;
    }

    /** {@inheritDoc} */
    @Override
    public PaintScope begin() {
        lastPaint = graphics().getPaint();
        graphics().setPaint(paint());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PaintScope end() {
        graphics().setPaint(lastPaint);
        return this;
    }

}
