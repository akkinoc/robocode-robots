package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
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
    public SpaceView layout(Graphics2D graphics) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SpaceView paint(Graphics2D graphics) {
        return this;
    }

}
