package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 塗りつぶすビュー。
 */
public class FilledView extends View {

    /**
     * ペイント。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<Paint> paint = Graphics2D::getPaint;

    /**
     * 形状。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<Shape> shape = graphics -> {
        Size size = size().get(graphics);
        return new Rectangle2D.Double(0.0, 0.0, size.width(), size.height());
    };

    /** {@inheritDoc} */
    @Override
    public void render(@NonNull Graphics2D graphics) {

        Paint originalPaint = graphics.getPaint();

        graphics.setPaint(paint().get(graphics));
        graphics.fill(shape().get(graphics));

        graphics.setPaint(originalPaint);

    }

}
