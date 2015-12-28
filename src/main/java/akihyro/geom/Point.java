package akihyro.geom;

import lombok.Data;
import lombok.NonNull;
import robocode.util.Utils;

/**
 * ポイント。
 */
@Data
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
     * 2つのポイントが近似かどうか判定する。
     *
     * @param point 比較対象のポイント。
     * @return 2つのポイントが近似かどうか。
     */
    public boolean nears(@NonNull Point point) {
        return Utils.isNear(x, point.x) && Utils.isNear(y, point.y);
    }

}
