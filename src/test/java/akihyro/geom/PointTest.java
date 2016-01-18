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
    public void of_ポイントを取得できる() {
        Point actual = Point.of(1.2, 3.4);
        assertThat(actual.x()).isCloseTo(1.2, within(0.1));
        assertThat(actual.y()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Point#of(double, double)} をテストする。
     */
    @Test
    public void of_原点を取得できる() {
        Point actual = Point.of(0.0, 0.0);
        assertThat(actual).isSameAs(Point.ORIGIN);
    }

    /**
     * {@link Point#offset(double, double)} をテストする。
     */
    @Test
    public void offset_オフセットを採れる() {
        Point point = Point.of(1.2, 3.4);
        Point actual = point.offset(5.6, 7.8);
        assertThat(actual.x()).isCloseTo(6.8, within(0.1));
        assertThat(actual.y()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Point#offset(Point)} をテストする。
     */
    @Test
    public void offset_ポイント指定でオフセットを採れる() {
        Point point = Point.of(1.2, 3.4);
        Point offset = Point.of(5.6, 7.8);
        Point actual = point.offset(offset);
        assertThat(actual.x()).isCloseTo(6.8, within(0.1));
        assertThat(actual.y()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Point#offsetX(double)} をテストする。
     */
    @Test
    public void offsetX_X座標のオフセットを採れる() {
        Point point = Point.of(1.2, 3.4);
        Point actual = point.offsetX(5.6);
        assertThat(actual.x()).isCloseTo(6.8, within(0.1));
        assertThat(actual.y()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Point#offsetY(double)} をテストする。
     */
    @Test
    public void offsetY_Y座標のオフセットを採れる() {
        Point point = Point.of(1.2, 3.4);
        Point actual = point.offsetY(7.8);
        assertThat(actual.x()).isCloseTo(1.2, within(0.1));
        assertThat(actual.y()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Point point = Point.of(1.2, 3.4);
        Point other = Point.of(nextUp(1.2), nextUp(3.4));
        assertThat(point.nears(other)).isTrue();
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_X座標が閾値外の場合はfalseを返す() {
        Point point = Point.of(1.2, 3.4);
        Point other = Point.of(1.3, 3.4);
        assertThat(point.nears(other)).isFalse();
    }

    /**
     * {@link Point#nears(Point)} をテストする。
     */
    @Test
    public void nears_Y座標が閾値外の場合はfalseを返す() {
        Point point = Point.of(1.2, 3.4);
        Point other = Point.of(1.2, 3.5);
        assertThat(point.nears(other)).isFalse();
    }

}
