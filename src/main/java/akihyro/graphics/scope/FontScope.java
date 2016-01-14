package akihyro.graphics.scope;

import java.awt.Font;
import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;

/**
 * フォントを適用するグラフィカルスコープ。
 */
public class FontScope extends GraphicalScope {

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
     * @param graphics グラフィックス。
     * @param font フォント。
     */
    public FontScope(@NonNull Graphics2D graphics, @NonNull Font font) {
        super(graphics);
        this.font = font;
    }

    /** {@inheritDoc} */
    @Override
    public FontScope begin() {
        lastFont = graphics().getFont();
        graphics().setFont(font());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public FontScope end() {
        graphics().setFont(lastFont);
        return this;
    }

}
