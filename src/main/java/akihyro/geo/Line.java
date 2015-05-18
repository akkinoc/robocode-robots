package akihyro.geo;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

import lombok.NonNull;
import lombok.Value;

/**
 * 直線。
 * 2つの点を結ぶ直線を示す。
 */
@Value
public class Line {

    /**
     * 始点。
     */
    @NonNull
    private final Point from;

    /**
     * 終点。
     */
    @NonNull
    private final Point to;

    /**
     * 距離を取得する。
     *
     * @return 距離。
     */
    public double getDistance() {
        double x = to.getX() - from.getX();
        double y = to.getY() - from.getY();
        return sqrt(x * x + y * y);
    }

    /**
     * 角度を取得する。
     *
     * @return 角度。
     */
    public double getAngle() {
        double x = to.getX() - from.getX();
        double y = to.getY() - from.getY();
        return atan2(x, y);
    }

}
