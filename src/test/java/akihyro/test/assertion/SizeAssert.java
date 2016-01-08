package akihyro.test.assertion;

import akihyro.geom.Size;
import org.assertj.core.api.AbstractAssert;

/**
 * {@link Size} アサーション。
 *
 * @param <S> 自身のタイプ。
 */
public class SizeAssert<S extends SizeAssert<S>> extends AbstractAssert<S, Size> {

    /**
     * コンストラクタ。
     *
     * @param actual 検証対象。
     */
    protected SizeAssert(Size actual) {
        this(actual, SizeAssert.class);
    }

    /**
     * コンストラクタ。
     *
     * @param actual 検証対象。
     * @param selfClass 自身のクラス。
     */
    protected SizeAssert(Size actual, Class<?> selfClass) {
        super(actual, selfClass);
    }

    /**
     * 近似であることを検証する。
     *
     * @param size サイズ。
     * @return 自身のインスタンス。
     */
    public S isNearTo(Size size) {
        isNotNull();
        if (!actual.nears(size)) {
            failWithMessage("%nExpecting:%n <%s>%nto be near to:%n <%s>%nbut was not.", actual, size);
        }
        return myself;
    }

    /**
     * 近似でないことを検証する。
     *
     * @param size サイズ。
     * @return 自身のインスタンス。
     */
    public S isNotNearTo(Size size) {
        isNotNull();
        if (actual.nears(size)) {
            failWithMessage("%nExpecting:%n <%s>%nto be not near to:%n <%s>%nbut was not.", actual, size);
        }
        return myself;
    }

    /**
     * アサーションを開始する。
     *
     * @param actual 検証対象。
     * @return アサーション。
     */
    public static SizeAssert<?> assertThat(Size actual) {
        return new SizeAssert<>(actual);
    }

}
