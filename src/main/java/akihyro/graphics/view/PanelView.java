package akihyro.graphics.view;

import akihyro.geom.RectEdge;
import akihyro.graphics.context.GraphicsContext;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import lombok.NonNull;

/**
 * パネルに格納して描画するビュー。
 */
public class PanelView extends EdgedView {

    /**
     * 背景ビュー。
     */
    private final FilledView backgroundView = new FilledView()
            .pattern(new Color(0.0f, 0.0f, 0.0f, 0.5f));

    /**
     * コンストラクタ。
     */
    public PanelView() {
        edge(RectEdge.of(5.0));
    }

    /** {@inheritDoc} */
    @Override
    public PanelView layout(@NonNull GraphicsContext context) {
        super.layout(context);
        Shape shape = new RoundRectangle2D.Double(
                0.0, 0.0, size().width(), size().height(),
                edge().left() + edge().right() / 2.0, edge().bottom() + edge().top() / 2.0
        );
        backgroundView.shape(shape).layout(context);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PanelView paint(@NonNull GraphicsContext context) {
        backgroundView.paint(context);
        super.paint(context);
        return this;
    }

}
