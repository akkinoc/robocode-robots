package akihyro.graphics.view;

import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;

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
     * @param context グラフィックスコンテキスト。
     * @return 自身のインスタンス。
     */
    public abstract View layout(GraphicsContext context);

    /**
     * 描画する。
     *
     * @param context グラフィックスコンテキスト。
     * @return 自身のインスタンス。
     */
    public abstract View paint(GraphicsContext context);

}
