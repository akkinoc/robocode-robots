package akihyro.view;

import java.awt.Graphics2D;

/**
 * ビュー属性。
 *
 * @param <T> 属性値のタイプ。
 */
@FunctionalInterface
public interface ViewAttr<T> {

    /**
     * 属性値を取得する。
     *
     * @param graphics 描画先。
     * @return 属性値。
     */
    T get(Graphics2D graphics);

}
