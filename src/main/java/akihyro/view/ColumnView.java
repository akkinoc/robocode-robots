package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 垂直方向に並べて描画するビュー。
 *
 * @param <V> ビューのタイプ。
 */
public class ColumnView<V extends View> extends View {

    /**
     * ビューリスト。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<List<V>> views = ViewAttrs.undef();

    /**
     * コンストラクタ。
     */
    public ColumnView() {
        size(this::calcSize);
    }

    /**
     * サイズを求める。
     *
     * @param graphics 描画先。
     * @return サイズ。
     */
    private Size calcSize(@NonNull Graphics2D graphics) {
        return views().get(graphics).stream()
                .map(view -> view.size().get(graphics))
                .reduce(Size.EMPTY, Size::plusVertical);
    }

    /** {@inheritDoc} */
    @Override
    public void render(@NonNull Graphics2D graphics) {
        graphics.translate(0.0, size().get(graphics).height());
        for (View view : views().get(graphics)) {
            graphics.translate(0.0, - view.size().get(graphics).height());
            view.render(graphics);
        }
    }

}
