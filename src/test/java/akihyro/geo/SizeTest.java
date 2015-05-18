package akihyro.geo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
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
    public void new_寸法を指定してインスタンスを生成できる() {
        double width = 1.2;
        double height = 3.4;
        Size size = new Size(width, height);
        assertThat(size.getWidth(), is(width));
        assertThat(size.getHeight(), is(height));
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_2つの寸法が誤差範囲内であればtrueを返す() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(
                size1.getWidth() + (NEAR_DELTA - NEAR_DELTA / 10),
                size1.getHeight() + (NEAR_DELTA - NEAR_DELTA / 10)
        );
        assertThat(size1.nears(size2), is(true));
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_幅が誤差範囲外であればfalseを返す() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(
                size1.getWidth() + NEAR_DELTA,
                size1.getHeight() + (NEAR_DELTA - NEAR_DELTA / 10)
        );
        assertThat(size1.nears(size2), is(false));
    }

    /**
     * {@link Size#nears(Size)} をテストする。
     */
    @Test
    public void nears_高さが誤差範囲外であればfalseを返す() {
        Size size1 = new Size(1.2, 3.4);
        Size size2 = new Size(
                size1.getWidth() + (NEAR_DELTA - NEAR_DELTA / 10),
                size1.getHeight() + NEAR_DELTA
        );
        assertThat(size1.nears(size2), is(false));
    }

}
