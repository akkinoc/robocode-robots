package akihyro.geo;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

import static robocode.util.Utils.normalAbsoluteAngle;

import lombok.NonNull;
import lombok.Value;

/**
 * 2座標。
 */
@Value
public class PointToPoint {

    /**
     * FROM。
     */
    @NonNull
    private final Point from;

    /**
     * TO。
     */
    @NonNull
    private final Point to;

    /**
     * X軸の距離を取得する。
     *
     * @return X軸の距離。
     */
    public double getDistanceX() {
        return to.getX() - from.getX();
    }

    /**
     * Y軸の距離を取得する。
     *
     * @return Y軸の距離。
     */
    public double getDistanceY() {
        return to.getY() - from.getY();
    }

    /**
     * 距離を取得する。
     *
     * @return 距離。
     */
    public double getDistance() {
        double x = getDistanceX();
        double y = getDistanceY();
        return sqrt(x * x + y * y);
    }

    /**
     * 方向を取得する。
     *
     * @return 方向。
     */
    public double getDirection() {
        double x = getDistanceX();
        double y = getDistanceY();
        double direction = atan2(x, y);
        return normalAbsoluteAngle(direction);
    }

}
