package akihyro.graphics.view;

import akihyro.geom.RectEdge;
import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import lombok.NonNull;

/**
 * パネルに格納して描画するビュー。
 */
public class PanelView extends View {

    /**
     * ビュー。
     */
    private final EdgedView view = new EdgedView()
            .edge(RectEdge.of(5.0));

    /**
     * 背景ビュー。
     */
    private final FilledView backgroundView = new FilledView()
            .pattern(new Color(0.0f, 0.0f, 0.0f, 0.5f));

    /**
     * ビューをセットする。
     *
     * @param view ビュー。
     * @return 自身のインスタンス。
     */
    public PanelView view(View view) {
        this.view.view(view);
        return this;
    }

    /**
     * ビューを取得する。
     *
     * @return ビュー。
     */
    public View view() {
        return view.view();
    }

    /** {@inheritDoc} */
    @Override
    public Size size() {
        return view.size();
    }

    /** {@inheritDoc} */
    @Override
    public PanelView layout(@NonNull GraphicsContext context) {
        view.layout(context);
        Shape shape = new RoundRectangle2D.Double(
                0.0, 0.0, view.size().width(), view.size().height(),
                view.edge().left() + view.edge().right() / 2.0, view.edge().bottom() + view.edge().top() / 2.0
        );
        backgroundView.shape(shape).layout(context);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PanelView paint(@NonNull GraphicsContext context) {
        backgroundView.paint(context);
        view.paint(context);
        return this;
    }

}
