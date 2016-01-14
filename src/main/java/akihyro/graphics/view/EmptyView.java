package akihyro.graphics.view;

import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
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
    public EmptyView layout(GraphicsContext context) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public EmptyView paint(GraphicsContext context) {
        return this;
    }

}
