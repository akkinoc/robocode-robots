package akihyro.geom;

import robocode.util.Utils;

import lombok.NonNull;
import lombok.Value;

/**
 * 点。
 * 2次元の座標を示す。
 */
@Value
public class Point {

    /**
     * X座標。
     */
    private final double x;

    /**
     * Y座標。
     */
    private final double y;

    /**
     * 2つの点が近似かどうか判定する。
     *
     * @param point 比較対象の点。
     * @return 2つの点が近似かどうか。
     */
    public boolean isNear(@NonNull Point point) {
        return Utils.isNear(x, point.x) && Utils.isNear(y, point.y);
    }

}
