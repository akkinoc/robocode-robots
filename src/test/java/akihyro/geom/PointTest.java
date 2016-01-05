package akihyro.geom;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void new_インスタンスを生成できる() {
        Point point = new Point(1.2, 3.4);
        assertThat(point.x()).isEqualTo(1.2);
        assertThat(point.y()).isEqualTo(3.4);
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Point point1 = new Point(1.2, 3.4);
        Point point2 = new Point(
                point1.x() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                point1.y() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(point1.nears(point2)).isTrue();
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_X座標が閾値外の場合はfalseを返す() {
        Point point1 = new Point(1.2, 3.4);
        Point point2 = new Point(
                point1.x() + NEAR_DELTA,
                point1.y() + (NEAR_DELTA - NEAR_DELTA / 10.0)
        );
        assertThat(point1.nears(point2)).isFalse();
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_Y座標が閾値外の場合はfalseを返す() {
        Point point1 = new Point(1.2, 3.4);
        Point point2 = new Point(
                point1.x() + (NEAR_DELTA - NEAR_DELTA / 10.0),
                point1.y() + NEAR_DELTA
        );
        assertThat(point1.nears(point2)).isFalse();
    }

}
