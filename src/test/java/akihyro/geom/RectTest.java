package akihyro.geom;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static robocode.util.Utils.NEAR_DELTA;

/**
 * {@link Rect} のテスト。
 */
public class RectTest {

    /**
     * {@link Rect#Rect(Point, Size)} をテストする。
     */
    @Test
    public void new_インスタンスを生成できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.bottomLeft()).isEqualTo(new Point(1.2, 3.4));
        assertThat(rect.size()).isEqualTo(new Size(5.6, 7.8));
    }

    /**
     * {@link Rect#topRight()} をテストする。
     */
    @Test
    public void topRight_右上隅のポイントが取得できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.topRight()).isEqualTo(new Point(6.8, 11.2));
    }

    /**
     * {@link Rect#left()} をテストする。
     */
    @Test
    public void left_左下隅のX座標が取得できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.left()).isEqualTo(1.2);
    }

    /**
     * {@link Rect#bottom()} をテストする。
     */
    @Test
    public void bottom_左下隅のY座標が取得できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.bottom()).isEqualTo(3.4);
    }

    /**
     * {@link Rect#right()} をテストする。
     */
    @Test
    public void right_右上隅のX座標が取得できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.right()).isEqualTo(6.8);
    }

    /**
     * {@link Rect#top()} をテストする。
     */
    @Test
    public void top_右上隅のY座標が取得できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.top()).isEqualTo(11.2);
    }

    /**
     * {@link Rect#width()} をテストする。
     */
    @Test
    public void width_幅が取得できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.width()).isEqualTo(5.6);
    }

    /**
     * {@link Rect#height()} をテストする。
     */
    @Test
    public void height_高さが取得できる() {
        Rect rect = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        assertThat(rect.height()).isEqualTo(7.8);
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_閾値内の場合はtrueを返す() {
        Rect rect1 = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        Rect rect2 = new Rect(
                new Point(
                        rect1.bottomLeft().x() + NEAR_DELTA / 2.0,
                        rect1.bottomLeft().y() + NEAR_DELTA / 2.0
                ),
                new Size(
                        rect1.size().width() + NEAR_DELTA / 2.0,
                        rect1.size().height() + NEAR_DELTA / 2.0
                )
        );
        assertThat(rect1.nears(rect2)).isTrue();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_左下隅のX座標が閾値外の場合はfalseを返す() {
        Rect rect1 = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        Rect rect2 = new Rect(
                new Point(
                        rect1.bottomLeft().x() + NEAR_DELTA * 2.0,
                        rect1.bottomLeft().y() + NEAR_DELTA / 2.0
                ),
                new Size(
                        rect1.size().width() + NEAR_DELTA / 2.0,
                        rect1.size().height() + NEAR_DELTA / 2.0
                )
        );
        assertThat(rect1.nears(rect2)).isFalse();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_左下隅のY座標が閾値外の場合はfalseを返す() {
        Rect rect1 = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        Rect rect2 = new Rect(
                new Point(
                        rect1.bottomLeft().x() + NEAR_DELTA / 2.0,
                        rect1.bottomLeft().y() + NEAR_DELTA * 2.0
                ),
                new Size(
                        rect1.size().width() + NEAR_DELTA / 2.0,
                        rect1.size().height() + NEAR_DELTA / 2.0
                )
        );
        assertThat(rect1.nears(rect2)).isFalse();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_幅が閾値外の場合はfalseを返す() {
        Rect rect1 = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        Rect rect2 = new Rect(
                new Point(
                        rect1.bottomLeft().x() + NEAR_DELTA / 2.0,
                        rect1.bottomLeft().y() + NEAR_DELTA / 2.0
                ),
                new Size(
                        rect1.size().width() + NEAR_DELTA * 2.0,
                        rect1.size().height() + NEAR_DELTA / 2.0
                )
        );
        assertThat(rect1.nears(rect2)).isFalse();
    }

    /**
     * {@link Rect#nears(Rect)} をテストする。
     */
    @Test
    public void nears_高さが閾値外の場合はfalseを返す() {
        Rect rect1 = new Rect(
                new Point(1.2, 3.4),
                new Size(5.6, 7.8)
        );
        Rect rect2 = new Rect(
                new Point(
                        rect1.bottomLeft().x() + NEAR_DELTA / 2.0,
                        rect1.bottomLeft().y() + NEAR_DELTA / 2.0
                ),
                new Size(
                        rect1.size().width() + NEAR_DELTA / 2.0,
                        rect1.size().height() + NEAR_DELTA * 2.0
                )
        );
        assertThat(rect1.nears(rect2)).isFalse();
    }

}
