package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 別のビューに処理を委譲するビュー。
 *
 * @param <V> ビューのタイプ。
 */
public class DelegateView<V extends View> extends View {

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
    public DelegateView() {
        size(this::calcSize);
    }

    /**
     * サイズを求める。
     *
     * @param graphics 描画先。
     * @return サイズ。
     */
    private Size calcSize(Graphics2D graphics) {
        return view().get(graphics).size().get(graphics);
    }

    /** {@inheritDoc} */
    @Override
    public void render(Graphics2D graphics) {
        view().get(graphics).render(graphics);
    }

}
