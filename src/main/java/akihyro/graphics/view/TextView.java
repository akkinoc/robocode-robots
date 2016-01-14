package akihyro.graphics.view;

import akihyro.geom.Point;
import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
import akihyro.graphics.scope.FontScope;
import akihyro.graphics.scope.PaintScope;
import akihyro.graphics.scope.TranslateScope;
import java.awt.Color;
import java.awt.Font;
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
    public TextView layout(@NonNull GraphicsContext context) {
        Rectangle2D bounds = font().getStringBounds(text(), context.graphics().getFontRenderContext());
        size = Size.of(bounds.getWidth(), bounds.getHeight());
        offset = Point.of(bounds.getX(), bounds.getY() + bounds.getHeight());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TextView paint(@NonNull GraphicsContext context) {
        @Cleanup PaintScope paintScope = new PaintScope(context, pattern()).begin();
        @Cleanup FontScope fontScope = new FontScope(context, font()).begin();
        @Cleanup TranslateScope translateScope = new TranslateScope(context, offset).begin();
        context.graphics().drawString(text(), 0, 0);
        return this;

    }

}
