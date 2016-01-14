package akihyro.graphics.scope;

import akihyro.graphics.context.GraphicsContext;
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
     * @param context グラフィックスコンテキスト。
     * @param paint ペイント。
     */
    public PaintScope(@NonNull GraphicsContext context, @NonNull Paint paint) {
        super(context);
        this.paint = paint;
    }

    /** {@inheritDoc} */
    @Override
    public PaintScope begin() {
        lastPaint = context().graphics().getPaint();
        context().graphics().setPaint(paint());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PaintScope end() {
        context().graphics().setPaint(lastPaint);
        return this;
    }

}
