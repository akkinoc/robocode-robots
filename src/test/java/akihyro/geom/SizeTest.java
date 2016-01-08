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
        Size size = Size.of(1.2, 3.4);
        assertThat(size.width()).isCloseTo(1.2, within(0.1));
        assertThat(size.height()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Size#of(double, double)} をテストする。
     */
    @Test
    public void of_空のサイズを取得できる() {
        Size size = Size.of(0.0, 0.0);
        assertThat(size).isSameAs(Size.EMPTY);
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
     * {@link Size#union(Size)} をテストする。
     */
    @Test
    public void union_和集合を採れる() {
        Size size1 = Size.of(1.2, 7.8);
        Size size2 = Size.of(5.6, 3.4);
        Size size = size1.union(size2);
        assertThat(size.width()).isCloseTo(5.6, within(0.1));
        assertThat(size.height()).isCloseTo(7.8, within(0.1));
    }

    /**
     * {@link Size#intersect(Size)} をテストする。
     */
    @Test
    public void intersect_積集合を採れる() {
        Size size1 = Size.of(1.2, 7.8);
        Size size2 = Size.of(5.6, 3.4);
        Size size = size1.intersect(size2);
        assertThat(size.width()).isCloseTo(1.2, within(0.1));
        assertThat(size.height()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Size#plus(Size)} をテストする。
     */
    @Test
    public void plus_加算できる() {
        Size size1 = Size.of(1.2, 3.4);
        Size size2 = Size.of(5.6, 7.8);
        Size size = size1.plus(size2);
        assertThat(size.width()).isCloseTo(6.8, within(0.1));
        assertThat(size.height()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Size#plusWidth(double)} をテストする。
     */
    @Test
    public void plusWidth_幅を加算できる() {
        Size size = Size.of(1.2, 3.4).plusWidth(5.6);
        assertThat(size.width()).isCloseTo(6.8, within(0.1));
        assertThat(size.height()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Size#plusHeight(double)} をテストする。
     */
    @Test
    public void plusHeight_高さを加算できる() {
        Size size = Size.of(1.2, 3.4).plusHeight(7.8);
        assertThat(size.width()).isCloseTo(1.2, within(0.1));
        assertThat(size.height()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Size#plusHorizontal(Size)} をテストする。
     */
    @Test
    public void plusHorizontal_水平方向に加算できる() {
        Size size1 = Size.of(1.2, 3.4);
        Size size2 = Size.of(5.6, 7.8);
        Size size = size1.plusHorizontal(size2);
        assertThat(size.width()).isCloseTo(6.8, within(0.1));
        assertThat(size.height()).isCloseTo(7.8, within(0.1));
    }

    /**
     * {@link Size#plusVertical(Size)} をテストする。
     */
    @Test
    public void plusVertical_垂直方向に加算できる() {
        Size size1 = Size.of(1.2, 3.4);
        Size size2 = Size.of(5.6, 7.8);
        Size size = size1.plusVertical(size2);
        assertThat(size.width()).isCloseTo(5.6, within(0.1));
        assertThat(size.height()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Size size1 = Size.of(1.2, 3.4);
        Size size2 = Size.of(nextUp(1.2), nextUp(3.4));
        assertThat(size1.nears(size2)).isTrue();
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_幅が閾値外の場合はfalseを返す() {
        Size size1 = Size.of(1.2, 3.4);
        Size size2 = Size.of(1.3, 3.4);
        assertThat(size1.nears(size2)).isFalse();
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_高さが閾値外の場合はfalseを返す() {
        Size size1 = Size.of(1.2, 3.4);
        Size size2 = Size.of(1.2, 3.5);
        assertThat(size1.nears(size2)).isFalse();
    }

    /**
     * {@link Size#toString()} をテストする。
     */
    @Test
    public void toString_文字列に変換できる() {
        Size size = Size.of(1.2, 3.4);
        assertThat(size).hasToString("(1.2 x 3.4)");
    }

}
