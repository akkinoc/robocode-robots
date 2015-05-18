package akihyro.geo;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import static robocode.util.Utils.NEAR_DELTA;

/**
 * {@link Line} のテスト。
 */
public class LineTest {

    /**
     * {@link Line#Line(Point, Point)} をテストする。
     */
    @Test
    public void new_始点と終点を指定してインスタンスを生成できる() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(9.8, 7.6);
        Line line = new Line(from, to);
        assertThat(line.getFrom(), is(from));
        assertThat(line.getTo(), is(to));
    }

    /**
     * {@link Line#getDistance()} をテストする。
     */
    @Test
    public void getDistance_距離を取得できる() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(1.0, sqrt(3.0));
        Line line = new Line(from, to);
        assertThat(line.getDistance(), closeTo(2.0, NEAR_DELTA));
    }

    /**
     * {@link Line#getDistance()} をテストする。
     */
    @Test
    public void getDistance_終点が始点より小さい場合でも正数を返す() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(-1.0, - sqrt(3.0));
        Line line = new Line(from, to);
        assertThat(line.getDistance(), closeTo(2.0, NEAR_DELTA));
    }

    /**
     * {@link Line#getDistance()} をテストする。
     */
    @Test
    public void getDistance_始点と終点が同一の場合は0を返す() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(1.2, 3.4);
        Line line = new Line(from, to);
        assertThat(line.getDistance(), closeTo(0.0, NEAR_DELTA));
    }

    /**
     * {@link Line#getAngle()} をテストする。
     */
    @Test
    public void getAngle_角度を取得できる() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(1.0, sqrt(3.0));
        Line line = new Line(from, to);
        assertThat(line.getAngle(), closeTo(PI / 6.0, NEAR_DELTA));
    }

    /**
     * {@link Line#getAngle()} をテストする。
     */
    @Test
    public void getAngle_終点が始点より小さい場合は負数を返す() {
        Point from = new Point(0.0, 0.0);
        Point to = new Point(-1.0, - sqrt(3.0));
        Line line = new Line(from, to);
        assertThat(line.getAngle(), closeTo(- PI + PI / 6.0, NEAR_DELTA));
    }

    /**
     * {@link Line#getAngle()} をテストする。
     */
    @Test
    public void getAngle_始点と終点が同一の場合は0を返す() {
        Point from = new Point(1.2, 3.4);
        Point to = new Point(1.2, 3.4);
        Line line = new Line(from, to);
        assertThat(line.getAngle(), closeTo(0.0, NEAR_DELTA));
    }

}
