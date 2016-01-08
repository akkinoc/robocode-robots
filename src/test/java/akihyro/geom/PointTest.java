package akihyro.geom;

import static java.lang.Math.nextUp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import org.junit.Test;

/**
 * {@link Point} のテスト。
 */
public class PointTest {

    /**
     * {@link Point#of(double, double)} をテストする。
     */
    @Test
    public void of_インスタンスを取得できる() {
        Point point = Point.of(1.2, 3.4);
        assertThat(point.x()).isCloseTo(1.2, within(0.1));
        assertThat(point.y()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Point#of(double, double)} をテストする。
     */
    @Test
    public void of_原点を取得できる() {
        Point point = Point.of(0.0, 0.0);
        assertThat(point).isSameAs(Point.ORIGIN);
    }

    /**
     * {@link Point#offset(double, double)} をテストする。
     */
    @Test
    public void offset_オフセットを採れる() {
        Point point = Point.of(1.2, 3.4).offset(5.6, 7.8);
        assertThat(point.x()).isCloseTo(6.7, within(0.1));
        assertThat(point.y()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Point#offsetX(double)} をテストする。
     */
    @Test
    public void offsetX_X座標のオフセットを採れる() {
        Point point = Point.of(1.2, 3.4).offsetX(5.6);
        assertThat(point.x()).isCloseTo(6.7, within(0.1));
        assertThat(point.y()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Point#offsetY(double)} をテストする。
     */
    @Test
    public void offsetY_Y座標のオフセットを採れる() {
        Point point = Point.of(1.2, 3.4).offsetY(7.8);
        assertThat(point.x()).isCloseTo(1.2, within(0.1));
        assertThat(point.y()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Point point1 = Point.of(1.2, 3.4);
        Point point2 = Point.of(nextUp(1.2), nextUp(3.4));
        assertThat(point1.nears(point2)).isTrue();
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_X座標が閾値外の場合はfalseを返す() {
        Point point1 = Point.of(1.2, 3.4);
        Point point2 = Point.of(1.3, 3.4);
        assertThat(point1.nears(point2)).isFalse();
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_Y座標が閾値外の場合はfalseを返す() {
        Point point1 = Point.of(1.2, 3.4);
        Point point2 = Point.of(1.2, 3.5);
        assertThat(point1.nears(point2)).isFalse();
    }

}
