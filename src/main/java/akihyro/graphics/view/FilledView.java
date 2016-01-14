package akihyro.graphics.view;

import akihyro.geom.Size;
import akihyro.graphics.scope.PaintScope;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 塗りつぶすビュー。
 */
public class FilledView extends View {

    /**
     * パターン。
     */
    @NonNull
    @Getter
    @Setter
    private Paint pattern = Color.BLACK;

    /**
     * 形状。
     */
    @NonNull
    @Getter
    @Setter
    private Shape shape = new Rectangle2D.Double();

    /**
     * サイズ。
     */
    @Getter
    private Size size = Size.EMPTY;

    /** {@inheritDoc} */
    @Override
    public FilledView layout(@NonNull Graphics2D graphics) {
        Rectangle2D bounds = shape().getBounds2D();
        size = Size.of(bounds.getX() + bounds.getWidth(), bounds.getY() + bounds.getHeight());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public FilledView paint(@NonNull Graphics2D graphics) {
        @Cleanup PaintScope paintScope = new PaintScope(graphics, pattern()).begin();
        graphics.fill(shape());
        return this;
    }

}
