package akihyro.graphics.view;

import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
import static java.util.Collections.emptyList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 同じ場所に重ねて描画するビュー。
 */
public class StackView extends View {

    /**
     * ビューリスト。
     */
    @NonNull
    @Getter
    @Setter
    private List<View> views = emptyList();

    /**
     * サイズ。
     */
    @Getter
    private Size size = Size.EMPTY;

    /** {@inheritDoc} */
    @Override
    public StackView layout(@NonNull GraphicsContext context) {
        size = Size.EMPTY;
        for (View view : views()) {
            view.layout(context);
            size = size.union(view.size());
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public StackView paint(@NonNull GraphicsContext context) {
        views.forEach(view -> view.paint(context));
        return this;
    }

}
