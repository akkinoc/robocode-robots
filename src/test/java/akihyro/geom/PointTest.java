package akihyro.geom;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import static robocode.util.Utils.NEAR_DELTA;

/**
 * {@link Point} のテスト。
 */
public class PointTest {

    /**
     * {@link Point#Point(double, double)} をテストする。
     */
    @Test
    public void new_座標を指定してインスタンスを生成できる() {
        double x = 1.2;
        double y = 3.4;
        Point point = new Point(x, y);
        assertThat(point.getX(), is(x));
        assertThat(point.getY(), is(y));
    }

    /**
     * {@link Point#isNear(Point)} をテストする。
     */
    @Test
    public void isNear_2つの点が近似であればtrueを返す() {
        Point point1 = new Point(1.2, 3.4);
        Point point2 = new Point(
                point1.getX() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                point1.getY() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(point1.isNear(point2), is(true));
    }

    /**
     * {@link Point#isNear(Point)} をテストする。
     */
    @Test
    public void isNear_X座標が誤差範囲外の場合はfalseを返す() {
        Point point1 = new Point(1.2, 3.4);
        Point point2 = new Point(
                point1.getX() + NEAR_DELTA,
                point1.getY() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(point1.isNear(point2), is(false));
    }

    /**
     * {@link Point#isNear(Point)} をテストする。
     */
    @Test
    public void isNear_Y座標が誤差範囲外の場合はfalseを返す() {
        Point point1 = new Point(1.2, 3.4);
        Point point2 = new Point(
                point1.getX() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                point1.getY() + NEAR_DELTA
        );
        assertThat(point1.isNear(point2), is(false));
    }

}
