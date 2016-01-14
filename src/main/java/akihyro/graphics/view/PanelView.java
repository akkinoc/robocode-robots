package akihyro.graphics.view;

import akihyro.geom.RectEdge;
import akihyro.geom.Size;
import java.awt.Color;
import java.awt.Graphics2D;
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
    public PanelView layout(@NonNull Graphics2D graphics) {
        super.layout(graphics);
        Size size = size();
        RectEdge edge = edge();
        Shape shape = new RoundRectangle2D.Double(
                0.0, 0.0, size.width(), size.height(),
                edge.left() + edge.right() / 2.0, edge.bottom() + edge.top() / 2.0
        );
        backgroundView.shape(shape).layout(graphics);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PanelView paint(@NonNull Graphics2D graphics) {
        backgroundView.paint(graphics);
        super.paint(graphics);
        return this;
    }

}
