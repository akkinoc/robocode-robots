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
     * 原点。
     */
    public static final Point ORIGIN = new Point(0.0, 0.0);

    /**
     * X座標。
     */
    protected final double x;

    /**
     * Y座標。
     */
    protected final double y;

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
