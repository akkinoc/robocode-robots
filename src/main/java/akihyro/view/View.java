package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;

/**
 * ビュー。
 */
public abstract class View {

    /**
     * サイズを取得する。
     *
     * @param graphics 描画先。
     * @return サイズ。
     */
    public abstract Size getSize(Graphics2D graphics);

    /**
     * 描画する。
     *
     * @param graphics 描画先。
     */
    public abstract void paint(Graphics2D graphics);

}
