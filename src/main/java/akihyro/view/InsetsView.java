package akihyro.view;

import akihyro.geom.Insets;
import akihyro.geom.Size;
import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 4辺を囲んで描画するビュー。
 *
 * @param <V> ビューのタイプ。
 */
public class InsetsView<V extends View> extends View {

    /**
     * ビュー。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<Insets> insets = ViewAttrs.undef();

    /**
     * ビュー。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<V> view = ViewAttrs.undef();

    /**
     * コンストラクタ。
     */
    public InsetsView() {
        size(this::calcSize);
    }

    /**
     * サイズを求める。
     *
     * @param graphics 描画先。
     * @return サイズ。
     */
    private Size calcSize(@NonNull Graphics2D graphics) {
        Insets insets = insets().get(graphics);
        return view().get(graphics).size().get(graphics)
                .plusWidth(insets.left())
                .plusHeight(insets.bottom())
                .plusWidth(insets.right())
                .plusHeight(insets.top());
    }

    /** {@inheritDoc} */
    @Override
    public void render(@NonNull Graphics2D graphics) {
        Insets insets = insets().get(graphics);
        graphics.translate(insets.left(), insets.bottom());
        view().get(graphics).render(graphics);
    }

}
