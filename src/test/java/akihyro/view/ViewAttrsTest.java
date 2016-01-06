package akihyro.view;

import java.util.List;
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
     * {@link ViewAttrs#ofList(Object...)} をテストする。
     */
    @Test
    public void ofList_固定値のリストを返すビュー属性が生成できる() {
        ViewAttr<List<Integer>> attr = ViewAttrs.ofList(12, 34, 56);
        assertThat(attr.get(null)).containsExactly(12, 34, 56);
    }

    /**
     * {@link ViewAttrs#ofList(Object...)} をテストする。
     */
    @Test
    public void ofList_空のリストを返すビュー属性が生成できる() {
        ViewAttr<List<Integer>> attr = ViewAttrs.ofList();
        assertThat(attr.get(null)).isEmpty();
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
