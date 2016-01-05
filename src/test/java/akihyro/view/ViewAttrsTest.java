package akihyro.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;

/**
 * {@link ViewAttrs} のテスト。
 */
public class ViewAttrsTest {

    /**
     * {@link ViewAttrs#of(Object)} をテストする。
     */
    @Test
    public void of_固定値を返すビュー属性が生成できる() {
        ViewAttr<Integer> attr = ViewAttrs.of(12);
        assertThat(attr.get(null)).isEqualTo(12);
    }

    /**
     * {@link ViewAttrs#undef()} をテストする。
     */
    @Test
    public void undef_未定義例外をスローするビュー属性が生成できる() {
        ViewAttr<Integer> attr = ViewAttrs.undef();
        assertThatThrownBy(() -> attr.get(null))
                .isInstanceOf(ViewAttrUndefException.class)
                .hasMessage("ViewAttr is undefined")
                .hasNoCause();
    }

}
