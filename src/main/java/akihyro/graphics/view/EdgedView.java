package akihyro.graphics.view;

import akihyro.geom.RectEdge;
import akihyro.geom.Size;
import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * エッジ付きで描画するビュー。
 */
public class EdgedView extends View {

    /**
     * ビュー。
     */
    @NonNull
    @Getter
    @Setter
    private View view = EmptyView.INSTANCE;

    /**
     * エッジ。
     */
    @NonNull
    @Getter
    @Setter
    private RectEdge edge = RectEdge.EMPTY;

    /**
     * サイズ。
     */
    @Getter
    private Size size = Size.EMPTY;

    /** {@inheritDoc} */
    @Override
    public EdgedView layout(@NonNull Graphics2D graphics) {
        View view = view().layout(graphics);
        size = view.size().edged(edge());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public EdgedView paint(@NonNull Graphics2D graphics) {
        RectEdge edge = edge();
        graphics.translate(edge.left(), edge.bottom());
        view().paint(graphics);
        graphics.translate(- edge.left(), - edge.bottom());
        return this;
    }

}
