package akihyro.graphics.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;

/**
 * ビュー。
 */
public abstract class View {

    /**
     * サイズを取得する。
     *
     * @return サイズ。
     */
    public abstract Size size();

    /**
     * レイアウトする。
     *
     * @param graphics 描画先。
     * @return 自身のインスタンス。
     */
    public abstract View layout(Graphics2D graphics);

    /**
     * 描画する。
     *
     * @param graphics 描画先。
     * @return 自身のインスタンス。
     */
    public abstract View paint(Graphics2D graphics);

}
