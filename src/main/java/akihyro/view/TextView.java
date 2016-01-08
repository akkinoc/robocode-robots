package akihyro.view;

import akihyro.geom.Point;
import akihyro.geom.Rect;
import akihyro.geom.Size;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * テキストを描画するビュー。
 */
public class TextView extends View {

    /**
     * テキスト。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<String> text = ViewAttrs.undef();

    /**
     * ペイント。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<Paint> paint = Graphics2D::getPaint;

    /**
     * フォント。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<Font> font = Graphics2D::getFont;

    /**
     * コンストラクタ。
     */
    public TextView() {
        size(graphics -> calcBounds(graphics).size());
    }

    /**
     * ベースライン基準の境界を求める。
     *
     * @param graphics 描画先。
     * @return ベースライン基準の境界。
     */
    private Rect calcBounds(@NonNull Graphics2D graphics) {
        Rectangle2D bounds = graphics
                .getFontMetrics(font().get(graphics))
                .getStringBounds(text().get(graphics), graphics);
        return Rect.fromTopLeft(
                Point.of(bounds.getX(), - bounds.getY()),
                Size.of(bounds.getWidth(), bounds.getHeight())
        );
    }

    /** {@inheritDoc} */
    @Override
    public void render(@NonNull Graphics2D graphics) {

        Paint originalPaint = graphics.getPaint();
        Font originalFont = graphics.getFont();

        Rect bounds = calcBounds(graphics);
        graphics.setPaint(paint().get(graphics));
        graphics.setFont(font().get(graphics));
        graphics.drawString(text().get(graphics), (float) - bounds.left(), (float) - bounds.bottom());

        graphics.setPaint(originalPaint);
        graphics.setFont(originalFont);

    }

}
