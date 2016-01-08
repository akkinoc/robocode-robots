package akihyro.geom;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import static robocode.util.Utils.isNear;

/**
 * 矩形領域内側4辺のオフセット。
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Insets {

    /**
     * 空のオフセット。
     */
    public static final Insets EMPTY = new Insets(0.0, 0.0, 0.0, 0.0);

    /**
     * 左辺のオフセット。
     */
    private final double left;

    /**
     * 下辺のオフセット。
     */
    private final double bottom;

    /**
     * 右辺のオフセット。
     */
    private final double right;

    /**
     * 上辺のオフセット。
     */
    private final double top;

    /**
     * 矩形領域内側4辺のオフセットを取得する。
     *
     * @param left 左辺のオフセット。
     * @param bottom 下辺のオフセット。
     * @param right 右辺のオフセット。
     * @param top 上辺のオフセット。
     * @return 矩形領域内側4辺のオフセット。
     */
    public static Insets of(double left, double bottom, double right, double top) {
        if (left == EMPTY.left() && bottom == EMPTY.bottom() && right == EMPTY.right() && top == EMPTY.top()) {
            return EMPTY;
        }
        return new Insets(left, bottom, right, top);
    }

    /**
     * 矩形領域内側4辺のオフセットを取得する。
     *
     * @param leftRight 左辺/右辺のオフセット。
     * @param bottomTop 下辺/上辺のオフセット。
     * @return 矩形領域内側4辺のオフセット。
     */
    public static Insets of(double leftRight, double bottomTop) {
        return of(leftRight, bottomTop, leftRight, bottomTop);
    }

    /**
     * 矩形領域内側4辺のオフセットを取得する。
     *
     * @param all 各辺のオフセット。
     * @return 矩形領域内側4辺のオフセット。
     */
    public static Insets of(double all) {
        return of(all, all, all, all);
    }

    /**
     * 近似かどうか判定する。
     *
     * @param insets 矩形領域内側4辺のオフセット。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Insets insets) {
        return isNear(left(), insets.left()) && isNear(bottom(), insets.bottom())
                && isNear(right(), insets.right()) && isNear(top(), insets.top());
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "(left=" + left() + ", bottom=" + bottom() + ", right=" + right() + ", top=" + top() + ")";
    }

}
