package akihyro.geom;

import static java.lang.Math.PI;

import robocode.util.Utils;
import static robocode.util.Utils.normalRelativeAngle;

import lombok.NonNull;
import lombok.Value;

/**
 * 方向。
 * - {@link PI} ～ {@link PI} の角度を示す。
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
     * 2つの方向が近似かどうか判定する。
     *
     * @param direction 比較対象の方向。
     * @return 2つの方向が近似かどうか。
     */
    public boolean isNear(@NonNull Direction direction) {
        return Utils.isNear(angle, direction.angle);
    }

    /**
     * 相対的な方向を求める。
     *
     * @param direction 相対化する方向。
     * @return 相対的な方向。
     */
    public Direction relativize(@NonNull Direction direction) {
        return new Direction(direction.angle - angle);
    }

}
