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
