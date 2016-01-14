package akihyro.graphics.view;

import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 何も描画しないビュー。
 */
public class SpaceView extends View {

    /**
     * サイズ。
     */
    @NonNull
    @Getter
    @Setter
    private Size size = Size.EMPTY;

    /** {@inheritDoc} */
    @Override
    public SpaceView layout(GraphicsContext context) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SpaceView paint(GraphicsContext context) {
        return this;
    }

}
