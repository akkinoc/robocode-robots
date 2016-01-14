package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 空のビュー。
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmptyView extends View {

    /**
     * インスタンス。
     */
    public static final EmptyView INSTANCE = new EmptyView();

    /** {@inheritDoc} */
    @Override
    public Size size() {
        return Size.EMPTY;
    }

    /** {@inheritDoc} */
    @Override
    public EmptyView layout(Graphics2D graphics) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public EmptyView paint(Graphics2D graphics) {
        return this;
    }

}
