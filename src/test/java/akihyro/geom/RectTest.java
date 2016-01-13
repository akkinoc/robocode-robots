package akihyro.geom;

import static akihyro.test.assertion.PointAssert.assertThat;
import static akihyro.test.assertion.SizeAssert.assertThat;
import static java.lang.Math.nextUp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import org.junit.Test;
/**
 * {@link Rect} のテスト。
 */
public class RectTest {

    /**
     * {@link Rect#fromBottomLeft(Point, Size)} をテストする。
     */
    @Test
    public void fromBottomLeft_矩形を取得できる() {
        Rect actual = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(actual.bottomLeft()).isNearTo(Point.of(1.2, 3.4));
        assertThat(actual.size()).isNearTo(Size.of(5.6, 7.8));
    }

    /**
     * {@link Rect#fromBottomRight(Point, Size)} をテストする。
     */
    @Test
    public void fromBottomRight_矩形を取得できる() {
        Rect actual = Rect.fromBottomRight(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(actual.bottomLeft()).isNearTo(Point.of(-4.4, 3.4));
        assertThat(actual.size()).isNearTo(Size.of(5.6, 7.8));
    }

    /**
     * {@link Rect#fromTopLeft(Point, Size)} をテストする。
     */
    @Test
    public void fromTopLeft_矩形を取得できる() {
        Rect actual = Rect.fromTopLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(actual.bottomLeft()).isNearTo(Point.of(1.2, -4.4));
        assertThat(actual.size()).isNearTo(Size.of(5.6, 7.8));
    }

    /**
     * {@link Rect#fromTopRight(Point, Size)} をテストする。
     */
    @Test
    public void fromTopRight_矩形を取得できる() {
        Rect actual = Rect.fromTopRight(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(actual.bottomLeft()).isNearTo(Point.of(-4.4, -4.4));
        assertThat(actual.size()).isNearTo(Size.of(5.6, 7.8));
    }

    /**
     * {@link Rect#fromCenter(Point, Size)} をテストする。
     */
    @Test
    public void fromCenter_矩形を取得できる() {
        Rect actual = Rect.fromCenter(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(actual.bottomLeft()).isNearTo(Point.of(-1.6, -0.5));
        assertThat(actual.size()).isNearTo(Size.of(5.6, 7.8));
    }

    /**
     * {@link Rect#left()} をテストする。
     */
    @Test
    public void left_左下隅のX座標が取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.left()).isCloseTo(1.2, within(0.1));
    }

    /**
     * {@link Rect#bottom()} をテストする。
     */
    @Test
    public void bottom_左下隅のY座標が取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.bottom()).isCloseTo(3.4, within(0.1));
    }

    /**
     * {@link Rect#right()} をテストする。
     */
    @Test
    public void right_右上隅のX座標が取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.right()).isCloseTo(6.8, within(0.1));
    }

    /**
     * {@link Rect#top()} をテストする。
     */
    @Test
    public void top_右上隅のY座標が取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.top()).isCloseTo(11.2, within(0.1));
    }

    /**
     * {@link Rect#centerX()} をテストする。
     */
    @Test
    public void centerX_中央のX座標が取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.centerX()).isCloseTo(4.0, within(0.1));
    }

    /**
     * {@link Rect#centerY()} をテストする。
     */
    @Test
    public void centerY_中央のY座標が取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.centerY()).isCloseTo(7.3, within(0.1));
    }

    /**
     * {@link Rect#width()} をテストする。
     */
    @Test
    public void width_幅が取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.width()).isCloseTo(5.6, within(0.1));
    }

    /**
     * {@link Rect#height()} をテストする。
     */
    @Test
    public void height_高さが取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.height()).isCloseTo(7.8, within(0.1));
    }

    /**
     * {@link Rect#bottomRight()} をテストする。
     */
    @Test
    public void bottomRight_右下隅のポイントを取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.bottomRight()).isNearTo(Point.of(6.8, 3.4));
    }

    /**
     * {@link Rect#topLeft()} をテストする。
     */
    @Test
    public void topLeft_左上隅のポイントを取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.topLeft()).isNearTo(Point.of(1.2, 11.2));
    }

    /**
     * {@link Rect#topRight()} をテストする。
     */
    @Test
    public void topRight_右上隅のポイントを取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.topRight()).isNearTo(Point.of(6.8, 11.2));
    }

    /**
     * {@link Rect#center()} をテストする。
     */
    @Test
    public void center_中央のポイントを取得できる() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.center()).isNearTo(Point.of(4.0, 7.3));
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        Rect other = Rect.fromBottomLeft(Point.of(nextUp(1.2), nextUp(3.4)), Size.of(nextUp(5.6), nextUp(7.8)));
        assertThat(rect.nears(other)).isTrue();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_左下隅のX座標が閾値外の場合はfalseを返す() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        Rect other = Rect.fromBottomLeft(Point.of(1.3, 3.4), Size.of(5.6, 7.8));
        assertThat(rect.nears(other)).isFalse();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_左下隅のY座標が閾値外の場合はfalseを返す() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        Rect other = Rect.fromBottomLeft(Point.of(1.2, 3.5), Size.of(5.6, 7.8));
        assertThat(rect.nears(other)).isFalse();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_幅が閾値外の場合はfalseを返す() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        Rect other = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.7, 7.8));
        assertThat(rect.nears(other)).isFalse();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_高さが閾値外の場合はfalseを返す() {
        Rect rect = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        Rect other = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.9));
        assertThat(rect.nears(other)).isFalse();
    }

    /**
     * {@link Rect#toString()} をテストする。
     */
    @Test
    public void toString_文字列に変換できる() {
        Rect actual = Rect.fromBottomLeft(Point.of(1.2, 3.4), Size.of(5.6, 7.8));
        assertThat(actual).hasToString("(bottomLeft=(1.2, 3.4), size=(5.6 x 7.8))");
    }

}
