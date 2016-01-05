package akihyro.geom;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static robocode.util.Utils.NEAR_DELTA;

/**
 * {@link Size} のテスト。
 */
public class SizeTest {

    /**
     * {@link Size#Size(double, double)} をテストする。
     */
    @Test
    public void new_インスタンスを生成できる() {
        Size size = new Size(1.2, 3.4);
        assertThat(size.getWidth()).isEqualTo(1.2);
        assertThat(size.getHeight()).isEqualTo(3.4);
    }

    /**
     * {@link Size#isEmpty()} をテストする。
     */
    @Test
    public void isEmpty_幅がない場合はtrueを返す() {
        Size size = new Size(0.0, 3.4);
        assertThat(size.isEmpty()).isTrue();
    }

    /**
     * {@link Size#isEmpty()} をテストする。
     */
    @Test
    public void isEmpty_高さがない場合はtrueを返す() {
        Size size = new Size(1.2, 0.0);
        assertThat(size.isEmpty()).isTrue();
    }

    /**
     * {@link Size#isEmpty()} をテストする。
     */
    @Test
    public void isEmpty_幅と高さがある場合はfalseを返す() {
        Size size = new Size(1.2, 3.4);
        assertThat(size.isEmpty()).isFalse();
    }

    /**
     * {@link Size#union(Size)} をテストする。
     */
    @Test
    public void union_和集合を採れる() {
        Size size1 = new Size(1.2, 7.8);
        Size size2 = new Size(5.6, 3.4);
        assertThat(size1.union(size2)).isEqualTo(new Size(5.6, 7.8));
    }

    /**
     * {@link Size#intersect(Size)} をテストする。
     */
    @Test
    public void intersect_積集合を採れる() {
        Size size1 = new Size(1.2, 7.8);
        Size size2 = new Size(5.6, 3.4);
        assertThat(size1.intersect(size2)).isEqualTo(new Size(1.2, 3.4));
    }

    /**
     * {@link Size#plus(Size)} をテストする。
     */
    @Test
    public void plus_加算できる() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(5.6, 7.8);
        assertThat(size1.plus(size2)).isEqualTo(new Size(6.8, 11.2));
    }

    /**
     * {@link Size#plusWidth(double)} をテストする。
     */
    @Test
    public void plusWidth_幅を加算できる() {
        Size size1 = new Size(1.2, 3.4);
        assertThat(size1.plusWidth(5.6)).isEqualTo(new Size(6.8, 3.4));
    }

    /**
     * {@link Size#plusHeight(double)} をテストする。
     */
    @Test
    public void plusHeight_高さを加算できる() {
        Size size1 = new Size(1.2, 3.4);
        assertThat(size1.plusHeight(7.8)).isEqualTo(new Size(1.2, 11.2));
    }

    /**
     * {@link Size#plusHorizontal(Size)} をテストする。
     */
    @Test
    public void plusHorizontal_垂直方向に加算できる() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(5.6, 7.8);
        assertThat(size1.plusHorizontal(size2)).isEqualTo(new Size(6.8, 7.8));
    }

    /**
     * {@link Size#plusVertical(Size)} をテストする。
     */
    @Test
    public void plusVertical_垂直方向に加算できる() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(5.6, 7.8);
        assertThat(size1.plusVertical(size2)).isEqualTo(new Size(5.6, 11.2));
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(
                size1.getWidth() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                size1.getHeight() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(size1.nears(size2)).isTrue();
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_幅が閾値外の場合はfalseを返す() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(
                size1.getWidth() + NEAR_DELTA,
                size1.getHeight() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(size1.nears(size2)).isFalse();
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_高さが閾値外の場合はfalseを返す() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(
                size1.getWidth() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                size1.getHeight() + NEAR_DELTA
        );
        assertThat(size1.nears(size2)).isFalse();
    }

}
