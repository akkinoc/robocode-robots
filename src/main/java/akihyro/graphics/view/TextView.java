package akihyro.graphics.view;

import akihyro.geom.Point;
import akihyro.geom.Size;
import akihyro.graphics.scope.FontScope;
import akihyro.graphics.scope.PaintScope;
import akihyro.graphics.scope.TranslateScope;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import lombok.Cleanup;
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
    private String text = "";

    /**
     * パターン。
     */
    @NonNull
    @Getter
    @Setter
    private Paint pattern = Color.BLACK;

    /**
     * フォント。
     */
    @NonNull
    @Getter
    @Setter
    private Font font = Font.decode(null);

    /**
     * サイズ。
     */
    @Getter
    private Size size = Size.EMPTY;

    /**
     * オフセット。
     */
    private Point offset = Point.ORIGIN;

    /** {@inheritDoc} */
    @Override
    public TextView layout(@NonNull Graphics2D graphics) {
        Rectangle2D bounds = font().getStringBounds(text(), graphics.getFontRenderContext());
        size = Size.of(bounds.getWidth(), bounds.getHeight());
        offset = Point.of(bounds.getX(), bounds.getY() + bounds.getHeight());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TextView paint(@NonNull Graphics2D graphics) {
        @Cleanup PaintScope paintScope = new PaintScope(graphics, pattern()).begin();
        @Cleanup FontScope fontScope = new FontScope(graphics, font()).begin();
        @Cleanup TranslateScope translateScope = new TranslateScope(graphics, offset).begin();
        graphics.drawString(text(), 0, 0);
        return this;

    }

}
