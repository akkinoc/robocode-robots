package akihyro.geom;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import robocode.util.Utils;

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
        if (x == 0.0 && y == 0.0) {
            return ORIGIN;
        }
        return new Point(x, y);
    }

    /**
     * 近似かどうか判定する。
     *
     * @param point ポイント。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Point point) {
        return Utils.isNear(x(), point.x())
                && Utils.isNear(y(), point.y());
    }

}
