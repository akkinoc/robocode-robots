package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 水平方向に並べて描画するビュー。
 *
 * @param <V> ビューのタイプ。
 */
public class RowView<V extends View> extends View {

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
    public RowView() {
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
                .reduce(Size.EMPTY, Size::plusHorizontal);
    }

    /** {@inheritDoc} */
    @Override
    public void render(@NonNull Graphics2D graphics) {
        for (View view : views().get(graphics)) {
            view.render(graphics);
            graphics.translate(view.size().get(graphics).width(), 0.0);
        }
        graphics.translate(- size().get(graphics).width(), 0.0);
    }

}
