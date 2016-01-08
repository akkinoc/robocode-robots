package akihyro.geom;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import static robocode.util.Utils.isNear;

/**
 * ポイント。
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Point {

    /**
     * 原点。
     */
    public static final Point ORIGIN = new Point(0.0, 0.0);

    /**
     * X座標。
     */
    private final double x;

    /**
     * Y座標。
     */
    private final double y;

    /**
     * ポイントを取得する。
     *
     * @param x X座標。
     * @param y Y座標。
     * @return ポイント。
     */
    public static Point of(double x, double y) {
        if (x == ORIGIN.x() && y == ORIGIN.y()) {
            return ORIGIN;
        }
        return new Point(x, y);
    }

    /**
     * オフセットを採る。
     *
     * @param x X座標の移動量。
     * @param y Y座標の移動量。
     * @return オフセットしたポイント。
     */
    public Point offset(double x, double y) {
        return of(x() + x, y() + y);
    }

    /**
     * X座標のオフセットを採る。
     *
     * @param x X座標の移動量。
     * @return オフセットしたポイント。
     */
    public Point offsetX(double x) {
        return offset(x, 0.0);
    }

    /**
     * Y座標のオフセットを採る。
     *
     * @param y Y座標の移動量。
     * @return オフセットしたポイント。
     */
    public Point offsetY(double y) {
        return offset(0.0, y);
    }

    /**
     * 近似かどうか判定する。
     *
     * @param point ポイント。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Point point) {
        return isNear(x(), point.x()) && isNear(y(), point.y());
    }

}
