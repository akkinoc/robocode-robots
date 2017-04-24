package akihyro.ext

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * `Number` の拡張のテスト。
 */
class NumberTest {

    /**
     * `Number.nears` をテストする。
     */
    @Test
    fun nears_近似値である場合はtrueを返す() {
        val actual = 1.234_567 nears 1.234_567 + 0.000_009
        assertThat(actual).isTrue()
    }

    /**
     * `Number.nears` をテストする。
     */
    @Test
    fun nears_近似値でない場合はfalseを返す() {
        val actual = 1.234_567 nears 1.234_567 + 0.000_011
        assertThat(actual).isFalse()
    }

}
