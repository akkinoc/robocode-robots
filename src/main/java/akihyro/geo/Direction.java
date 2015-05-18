package akihyro.geo;

import static robocode.util.Utils.normalRelativeAngle;

import lombok.NonNull;
import lombok.Value;

/**
 * 方向。
 */
@Value
public class Direction {

    /**
     * 角度。
     */
    private final double angle;

    /**
     * コンストラクタ。
     *
     * @param angle 角度。
     */
    public Direction(double angle) {
        this.angle = normalRelativeAngle(angle);
    }

    /**
     * 相対的な方向を求める。
     *
     * @param base 基準となる方向。
     * @return 相対的な方向。
     */
    public Direction relativize(@NonNull Direction base) {
        return new Direction(angle - base.getAngle());
    }

    /**
     * 相対的な方向を求める。
     *
     * @param base 基準となる角度。
     * @return 相対的な方向。
     */
    public Direction relativize(double base) {
        return new Direction(angle - base);
    }

}
