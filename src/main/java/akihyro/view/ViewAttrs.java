package akihyro.view;

import static java.util.Arrays.asList;
import java.util.List;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * ビュー属性ユーティリティ。
 */
@UtilityClass
public class ViewAttrs {

    /**
     * 固定値を返すビュー属性を生成する。
     *
     * @param <T> 属性値のタイプ。
     * @param value 属性値。
     * @return ビュー属性。
     */
    public static <T> ViewAttr<T> of(T value) {
        return graphics -> value;
    }

    /**
     * 固定値を返すビュー属性を生成する。
     *
     * @param <T> 属性値のリスト要素タイプ。
     * @param values 属性値。
     * @return ビュー属性。
     */
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> ViewAttr<List<T>> listOf(@NonNull T... values) {
        return of(asList(values));
    }

    /**
     * 未定義例外をスローするビュー属性を生成する。
     *
     * @param <T> 属性値のタイプ。
     * @return ビュー属性。
     */
    public static <T> ViewAttr<T> undef() {
        return graphics -> {
            throw new ViewAttrUndefException("ViewAttr is undefined");
        };
    }

}
