package akihyro.geo;

import static robocode.util.Utils.isNear;

import lombok.NonNull;
import lombok.Value;

/**
 * 点。
 * 二次元の座標を示す。
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
     * 2つの座標が誤差範囲内かどうか判定する。
     *
     * @return 2つの座標が誤差範囲内かどうか。
     */
    public boolean nears(@NonNull Point point) {
        return isNear(x, point.x) && isNear(y, point.y);
    }

}
