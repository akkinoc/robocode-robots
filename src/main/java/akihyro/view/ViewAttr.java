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

    /**
     * 固定値を返すビュー属性を生成する。
     *
     * @param <T> 属性値のタイプ。
     * @param value 属性値。
     * @return ビュー属性。
     */
    static <T> ViewAttr<T> of(T value) {
        return graphics -> value;
    }

    /**
     * 未定義を表すビュー属性を生成する。
     *
     * @param <T> 属性値のタイプ。
     * @return ビュー属性。
     */
    static <T> ViewAttr<T> undef() {
        return graphics -> {
            throw new UndefException();
        };
    }

    /**
     * 未定義例外。
     */
    static class UndefException extends RuntimeException {

        /**
         * コンストラクタ。
         */
        public UndefException() {
            super("ViewAttribute is undefined.");
        }

    }

}
