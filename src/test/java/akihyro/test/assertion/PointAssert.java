package akihyro.test.assertion;

import akihyro.geom.Point;
import org.assertj.core.api.AbstractAssert;

/**
 * {@link Point} アサーション。
 *
 * @param <S> 自身のタイプ。
 */
public class PointAssert<S extends PointAssert<S>> extends AbstractAssert<S, Point> {

    /**
     * コンストラクタ。
     *
     * @param actual 検証対象。
     */
    protected PointAssert(Point actual) {
        this(actual, PointAssert.class);
    }

    /**
     * コンストラクタ。
     *
     * @param actual 検証対象。
     * @param selfClass 自身のクラス。
     */
    protected PointAssert(Point actual, Class<?> selfClass) {
        super(actual, selfClass);
    }

    /**
     * 近似であることを検証する。
     *
     * @param point ポイント。
     * @return 自身のインスタンス。
     */
    public S isNear(Point point) {
        isNotNull();
        if (!actual.nears(point)) {
            failWithMessage("%nExpecting:%n <%s>%nto be near to:%n <%s>%nbut was not.", actual, point);
        }
        return myself;
    }

    /**
     * 近似でないことを検証する。
     *
     * @param point ポイント。
     * @return 自身のインスタンス。
     */
    public S isNotNear(Point point) {
        isNotNull();
        if (actual.nears(point)) {
            failWithMessage("%nExpecting:%n <%s>%nto be not near to:%n <%s>%nbut was not.", actual, point);
        }
        return myself;
    }

    /**
     * アサーションを開始する。
     *
     * @param actual 検証対象。
     * @return アサーション。
     */
    public static PointAssert<?> assertThat(Point actual) {
        return new PointAssert<>(actual);
    }

}
