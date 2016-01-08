package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 同じ場所に重ねて描画するビュー。
 *
 * @param <V> ビューのタイプ。
 */
public class StackView<V extends View> extends View {

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
    public StackView() {
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
                .reduce(Size.EMPTY, Size::union);
    }

    /** {@inheritDoc} */
    @Override
    public void render(@NonNull Graphics2D graphics) {
        for (View view : views().get(graphics)) {
            view.render(graphics);
        }
    }

}
