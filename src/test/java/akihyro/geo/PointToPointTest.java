package akihyro.geo;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import static robocode.util.Utils.NEAR_DELTA;

/**
 * {@link PointToPoint} のテスト。
 */
public class PointToPointTest {

    /**
     * {@link PointToPoint#PointToPoint(Point, Point)} をテストする。
     */
    @Test
    public void new_FROMとTOを指定してインスタンスを生成できる() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(9.8, 7.6);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getFrom(), is(from));
        assertThat(p2p.getTo(), is(to));
    }

    /**
     * {@link PointToPoint#getDistanceX()} をテストする。
     */
    @Test
    public void getDistanceX_X軸の距離を取得できる() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(9.8, 7.6);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistanceX(), closeTo(8.6, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistanceX()} をテストする。
     */
    @Test
    public void getDistanceX_X軸のTOの位置がFROMの位置より小さい場合でもX軸の距離を取得できる() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(-9.8, 7.6);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistanceX(), closeTo(-11.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistanceX()} をテストする。
     */
    @Test
    public void getDistanceX_X軸が同一の座標間では0が返される() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(1.2, 7.6);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistanceX(), closeTo(0.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistanceY()} をテストする。
     */
    @Test
    public void getDistanceY_Y軸の距離を取得できる() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(9.8, 7.6);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistanceY(), closeTo(4.2, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistanceY()} をテストする。
     */
    @Test
    public void getDistanceY_Y軸のTOの位置がFROMの位置より小さい場合でもY軸の距離を取得できる() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(9.8, -7.6);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistanceY(), closeTo(-11.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistanceY()} をテストする。
     */
    @Test
    public void getDistanceY_Y軸が同一の座標間では0が返される() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(9.8, 3.4);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistanceY(), closeTo(0.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistance()} をテストする。
     */
    @Test
    public void getDistance_距離を取得できる() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(1.0, sqrt(3.0));
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistance(), closeTo(2.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistance()} をテストする。
     */
    @Test
    public void getDistance_TOの位置がFROMの位置より小さい場合でも距離を取得できる() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(-1.0, - sqrt(3.0));
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistance(), closeTo(2.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDistance()} をテストする。
     */
    @Test
    public void getDistance_同一の座標間では0が返される() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(1.2, 3.4);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDistance(), closeTo(0.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDirection()} をテストする。
     */
    @Test
    public void getDirection_方向を取得できる() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(1.0, sqrt(3.0));
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDirection(), closeTo(PI / 6.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDirection()} をテストする。
     */
    @Test
    public void getDirection_TOの位置がFROMの位置より小さい場合でも方向を取得できる() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(-1.0, - sqrt(3.0));
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDirection(), closeTo(- PI + PI / 6.0, NEAR_DELTA));
    }

    /**
     * {@link PointToPoint#getDirection()} をテストする。
     */
    @Test
    public void getDirection_同一の座標間では0が返される() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(1.2, 3.4);
        PointToPoint p2p = new PointToPoint(from, to);
        assertThat(p2p.getDirection(), closeTo(0.0, NEAR_DELTA));
    }

}
