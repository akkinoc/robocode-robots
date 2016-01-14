package akihyro.graphics.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
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
    public DelegateView layout(Graphics2D graphics) {
        view().layout(graphics);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public DelegateView paint(Graphics2D graphics) {
        view().paint(graphics);
        return this;
    }

}
