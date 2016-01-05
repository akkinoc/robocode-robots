package akihyro.view;

import java.awt.Graphics2D;

/**
 * ビュー属性。
 *
 * @param <T> 属性値のタイプ。
 */
@FunctionalInterface
public interface ViewAttribute<T> {

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
    static <T> ViewAttribute<T> of(T value) {
        return graphics -> value;
    }

    /**
     * 未定義な属性値を示すビュー属性を生成する。
     * 未定義な属性値を取得しようとすると {@link UndefinedException} をスローする。
     *
     * @param <T> 属性値のタイプ。
     * @return ビュー属性。
     */
    static <T> ViewAttribute<T> undefined() {
        throw new UndefinedException();
    }

    /**
     * 未定義なビュー属性値へアクセスしたときに発生する例外。
     */
    public static class UndefinedException extends RuntimeException {

        /**
         * コンストラクタ。
         */
        public UndefinedException() {
            super("ViewAttribute is undefined.");
        }

    }

}
