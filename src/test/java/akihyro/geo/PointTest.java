package akihyro.geo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link Point} のテスト。
 */
public class PointTest {

    /**
     * {@link Point#Point(double, double)} をテストする。
     */
    @Test
    public void new_XとYを指定してインスタンスを生成できる() {
        double x = 1.2;
        double y = 3.4;
        Point point = new Point(x, y);
        assertThat(point.getX(), is(x));
        assertThat(point.getY(), is(y));
    }

}
