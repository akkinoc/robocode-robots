package akihyro.geo;

import static java.lang.Math.PI;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import static robocode.util.Utils.NEAR_DELTA;

/**
 * {@link Direction} のテスト。
 */
public class DirectionTest {

    /**
     * {@link Direction#Direction(double)} をテストする。
     */
    @Test
    public void new_角度を指定してインスタンスを生成できる() {
        double angle = PI / 2.0;
        Direction direction = new Direction(angle);
        assertThat(direction.getAngle(), is(angle));
    }

    /**
     * {@link Direction#Direction(double)} をテストする。
     */
    @Test
    public void new_PI以上の角度はノーマライズされる() {
        Direction direction = new Direction(PI);
        assertThat(direction.getAngle(), is(-PI));
    }

    /**
     * {@link Direction#Direction(double)} をテストする。
     */
    @Test
    public void new_マイナスPI未満の角度はノーマライズされる() {
        Direction direction = new Direction(-PI - 0.1);
        assertThat(direction.getAngle(), is(PI - 0.1));
    }

    /**
     * {@link Direction#nears(Direction)} をテストする。
     */
    @Test
    public void nears_2つの角度が誤差範囲内であればtrueを返す() {
        Direction direction1 = new Direction(PI / 2.0);
        Direction direction2 = new Direction(direction1.getAngle() + (NEAR_DELTA - NEAR_DELTA / 10));
        assertThat(direction1.nears(direction2), is(true));
    }

    /**
     * {@link Direction#nears(Direction)} をテストする。
     */
    @Test
    public void nears_2つの角度が誤差範囲外であればfalseを返す() {
        Direction direction1 = new Direction(PI / 2.0);
        Direction direction2 = new Direction(direction1.getAngle() + NEAR_DELTA);
        assertThat(direction1.nears(direction2), is(false));
    }

    /**
     * {@link Direction#relativize(Direction)} をテストする。
     */
    @Test
    public void relativize_相対化した方向を取得できる() {
        Direction direction1 = new Direction(PI / 3.0);
        Direction direction2 = new Direction(2.0 * PI / 3.0);
        assertThat(direction1.relativize(direction2).getAngle(), closeTo(PI / 3.0, NEAR_DELTA));
    }

}
