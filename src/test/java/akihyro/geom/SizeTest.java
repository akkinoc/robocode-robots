package akihyro.geom;

import static java.lang.Math.nextUp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import org.junit.Test;

/**
 * {@link Size} のテスト。
 */
public class SizeTest {

    /**
     * {@link Size#of(double, double)} をテストする。
     */
    @Test
    public void of_サイズを取得できる() {
        Size actual = Size.of(1.2, 3.4);
        assertThat(actual.width()).isCloseTo(1.2, within(0.1));
        assertThat(actual.height()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Size#of(double, double)} をテストする。
     */
    @Test
    public void of_空のサイズを取得できる() {
        Size actual = Size.of(0.0, 0.0);
        assertThat(actual).isSameAs(Size.EMPTY);
    }

    /**
     * {@link Size#isEmpty()} をテストする。
     */
    @Test
    public void isEmpty_幅がない場合はtrueを返す() {
        Size size = Size.of(0.0, 3.4);
        assertThat(size.isEmpty()).isTrue();
    }

    /**
     * {@link Size#isEmpty()} をテストする。
     */
    @Test
    public void isEmpty_高さがない場合はtrueを返す() {
        Size size = Size.of(1.2, 0.0);
        assertThat(size.isEmpty()).isTrue();
    }

    /**
     * {@link Size#isEmpty()} をテストする。
     */
    @Test
    public void isEmpty_幅と高さがある場合はfalseを返す() {
        Size size = Size.of(1.2, 3.4);
        assertThat(size.isEmpty()).isFalse();
    }

    /**
     * {@link Size#offset(double, double)} をテストする。
     */
    @Test
    public void offset_オフセットを採れる() {
        Size size = Size.of(1.2, 3.4);
        Size actual = size.offset(5.6, 7.8);
        assertThat(actual.width()).isCloseTo(6.8, within(0.1));
        assertThat(actual.height()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Size#offset(Size)} をテストする。
     */
    @Test
    public void offset_サイズ指定でオフセットを採れる() {
        Size size = Size.of(1.2, 3.4);
        Size offset = Size.of(5.6, 7.8);
        Size actual = size.offset(offset);
        assertThat(actual.width()).isCloseTo(6.8, within(0.1));
        assertThat(actual.height()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Size#offsetWidth(double)} をテストする。
     */
    @Test
    public void offsetWidth_幅のオフセットを採れる() {
        Size size = Size.of(1.2, 3.4);
        Size actual = size.offsetWidth(5.6);
        assertThat(actual.width()).isCloseTo(6.8, within(0.1));
        assertThat(actual.height()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Size#offsetHeight(double)} をテストする。
     */
    @Test
    public void offsetHeight_高さのオフセットを採れる() {
        Size size = Size.of(1.2, 3.4);
        Size actual = size.offsetHeight(7.8);
        assertThat(actual.width()).isCloseTo(1.2, within(0.1));
        assertThat(actual.height()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Size#union(Size)} をテストする。
     */
    @Test
    public void union_和集合を採れる() {
        Size size = Size.of(1.2, 7.8);
        Size other = Size.of(5.6, 3.4);
        Size actual = size.union(other);
        assertThat(actual.width()).isCloseTo(5.6, within(0.1));
        assertThat(actual.height()).isCloseTo(7.8, within(0.1));
    }

    /**
     * {@link Size#intersect(Size)} をテストする。
     */
    @Test
    public void intersect_積集合を採れる() {
        Size size = Size.of(1.2, 7.8);
        Size other = Size.of(5.6, 3.4);
        Size actual = size.intersect(other);
        assertThat(actual.width()).isCloseTo(1.2, within(0.1));
        assertThat(actual.height()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Size#joinHorizontal(Size)} をテストする。
     */
    @Test
    public void joinHorizontal_水平方向に連結できる() {
        Size size = Size.of(1.2, 3.4);
        Size other = Size.of(5.6, 7.8);
        Size actual = size.joinHorizontal(other);
        assertThat(actual.width()).isCloseTo(6.8, within(0.1));
        assertThat(actual.height()).isCloseTo(7.8, within(0.1));
    }

    /**
     * {@link Size#joinVertical(Size)} をテストする。
     */
    @Test
    public void joinVertical_垂直方向に連結できる() {
        Size size = Size.of(1.2, 3.4);
        Size other = Size.of(5.6, 7.8);
        Size actual = size.joinVertical(other);
        assertThat(actual.width()).isCloseTo(5.6, within(0.1));
        assertThat(actual.height()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Size#edged(RectEdge)} をテストする。
     */
    @Test
    public void edged_エッジ付きのサイズを採れる() {
        Size size = Size.of(1.2, 3.4);
        RectEdge edge = RectEdge.of(1.2, 3.4, 5.6, 7.8);
        Size actual = size.edged(edge);
        assertThat(actual.width()).isCloseTo(8.0, within(0.1));
        assertThat(actual.height()).isCloseTo(14.6, within(0.1));
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Size size = Size.of(1.2, 3.4);
        Size other = Size.of(nextUp(1.2), nextUp(3.4));
        assertThat(size.nears(other)).isTrue();
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_幅が閾値外の場合はfalseを返す() {
        Size size = Size.of(1.2, 3.4);
        Size other = Size.of(1.3, 3.4);
        assertThat(size.nears(other)).isFalse();
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_高さが閾値外の場合はfalseを返す() {
        Size size = Size.of(1.2, 3.4);
        Size other = Size.of(1.2, 3.5);
        assertThat(size.nears(other)).isFalse();
    }

    /**
     * {@link Size#toString()} をテストする。
     */
    @Test
    public void toString_文字列に変換できる() {
        Size actual = Size.of(1.2, 3.4);
        assertThat(actual).hasToString("(1.2 x 3.4)");
    }

}
