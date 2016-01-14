package akihyro.graphics.view;

import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 別のビューに処理を委譲するビュー。
 */
public class DelegateView extends View {

    /**
     * ビュー。
     */
    @NonNull
    @Getter
    @Setter
    private View view = EmptyView.INSTANCE;

    /** {@inheritDoc} */
    @Override
    public Size size() {
        return view().size();
    }

    /** {@inheritDoc} */
    @Override
    public DelegateView layout(GraphicsContext context) {
        view().layout(context);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public DelegateView paint(GraphicsContext context) {
        view().paint(context);
        return this;
    }

}
