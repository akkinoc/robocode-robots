package akihyro.geom;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import static robocode.util.Utils.isNear;

/**
 * 矩形エッジ。
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RectEdge {

    /**
     * 空の矩形エッジ。
     */
    public static final RectEdge EMPTY = new RectEdge(0.0, 0.0, 0.0, 0.0);

    /**
     * 左辺。
     */
    private final double left;

    /**
     * 下辺。
     */
    private final double bottom;

    /**
     * 右辺。
     */
    private final double right;

    /**
     * 上辺。
     */
    private final double top;

    /**
     * 矩形エッジを取得する。
     *
     * @param left 左辺。
     * @param bottom 下辺。
     * @param right 右辺。
     * @param top 上辺。
     * @return 矩形エッジ。
     */
    public static RectEdge of(double left, double bottom, double right, double top) {
        if (left == EMPTY.left() && bottom == EMPTY.bottom() && right == EMPTY.right() && top == EMPTY.top()) {
            return EMPTY;
        }
        return new RectEdge(left, bottom, right, top);
    }

    /**
     * 矩形エッジを取得する。
     *
     * @param leftRight 左辺/右辺。
     * @param bottomTop 下辺/上辺。
     * @return 矩形エッジ。
     */
    public static RectEdge of(double leftRight, double bottomTop) {
        return of(leftRight, bottomTop, leftRight, bottomTop);
    }

    /**
     * 矩形エッジを取得する。
     *
     * @param all 左辺/右辺/下辺/上辺。
     * @return 矩形エッジ。
     */
    public static RectEdge of(double all) {
        return of(all, all, all, all);
    }

    /**
     * 近似かどうか判定する。
     *
     * @param edge 比較対象の矩形エッジ。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull RectEdge edge) {
        return isNear(left(), edge.left()) && isNear(bottom(), edge.bottom())
                && isNear(right(), edge.right()) && isNear(top(), edge.top());
    }

}
