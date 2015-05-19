package akihyro.geom;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import static robocode.util.Utils.NEAR_DELTA;

/**
 * {@link Dimension} のテスト。
 */
public class DimensionTest {

    /**
     * {@link Dimension#Dimension(double, double)} をテストする。
     */
    @Test
    public void new_寸法を指定してインスタンスを生成できる() {
        double width = 1.2;
        double height = 3.4;
        Dimension dimension = new Dimension(width, height);
        assertThat(dimension.getWidth(), is(width));
        assertThat(dimension.getHeight(), is(height));
    }

    /**
     * {@link Dimension#isNear(Dimension)} をテストする。
     */
    @Test
    public void isNear_2つの点が近似であればtrueを返す() {
        Dimension dimension1 = new Dimension(1.2, 3.4);
        Dimension dimension2 = new Dimension(
                dimension1.getWidth() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                dimension1.getHeight() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(dimension1.isNear(dimension2), is(true));
    }

    /**
     * {@link Dimension#isNear(Dimension)} をテストする。
     */
    @Test
    public void isNear_幅が誤差範囲外の場合はfalseを返す() {
        Dimension dimension1 = new Dimension(1.2, 3.4);
        Dimension dimension2 = new Dimension(
                dimension1.getWidth() + NEAR_DELTA,
                dimension1.getHeight() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(dimension1.isNear(dimension2), is(false));
    }

    /**
     * {@link Dimension#isNear(Dimension)} をテストする。
     */
    @Test
    public void isNear_高さが誤差範囲外の場合はfalseを返す() {
        Dimension dimension1 = new Dimension(1.2, 3.4);
        Dimension dimension2 = new Dimension(
                dimension1.getWidth() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                dimension1.getHeight() + NEAR_DELTA
        );
        assertThat(dimension1.isNear(dimension2), is(false));
    }

}
