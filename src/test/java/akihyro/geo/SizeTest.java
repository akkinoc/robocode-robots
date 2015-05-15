package akihyro.geo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link Size} のテスト。
 */
public class SizeTest {

    /**
     * {@link Size#Size(double, double)} をテストする。
     */
    @Test
    public void new_幅と高さを指定してインスタンスを生成できる() {
        double width = 1.2;
        double height = 3.4;
        Size size = new Size(width, height);
        assertThat(size.getWidth(), is(width));
        assertThat(size.getHeight(), is(height));
    }

}
