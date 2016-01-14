package akihyro.graphics.scope;

import akihyro.graphics.context.GraphicsContext;
import java.awt.Font;
import lombok.Getter;
import lombok.NonNull;

/**
 * フォントを適用するグラフィカルスコープ。
 */
public class FontScope extends GraphicsScope {

    /**
     * フォント。
     */
    @Getter
    private final Font font;

    /**
     * 適用前のフォント。
     */
    private Font lastFont;

    /**
     * コンストラクタ。
     *
     * @param context グラフィックスコンテキスト。
     * @param font フォント。
     */
    public FontScope(@NonNull GraphicsContext context, @NonNull Font font) {
        super(context);
        this.font = font;
    }

    /** {@inheritDoc} */
    @Override
    public FontScope begin() {
        lastFont = context().graphics().getFont();
        context().graphics().setFont(font());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public FontScope end() {
        context().graphics().setFont(lastFont);
        return this;
    }

}
