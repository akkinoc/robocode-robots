package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * ビュー。
 */
public abstract class View {

    /**
     * サイズ。
     */
    @NonNull
    @Getter
    @Setter
    private ViewAttr<Size> size = ViewAttr.undef();

    /**
     * 描画する。
     *
     * @param graphics 描画先。
     */
    public abstract void render(Graphics2D graphics);

}
