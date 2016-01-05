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
    private final double x;

    /**
     * Y座標。
     */
    private final double y;

    /**
     * 近似かどうか判定する。
     *
     * @param point ポイント。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Point point) {
        return Utils.isNear(getX(), point.getX())
                && Utils.isNear(getY(), point.getY());
    }

}
