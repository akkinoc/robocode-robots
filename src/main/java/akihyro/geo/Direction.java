package akihyro.geo;

import static java.lang.Math.PI;

import static robocode.util.Utils.isNear;
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
     * 前方。
     */
    public static final Direction FRONT = new Direction(0.0);

    /**
     * 後方。
     */
    public static final Direction BACK = new Direction(- PI);

    /**
     * 右方。
     */
    public static final Direction RIGHT = new Direction(PI / 2.0);

    /**
     * 左方。
     */
    public static final Direction LEFT = new Direction(- PI / 2.0);

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
     * 2つの角度が誤差範囲内かどうか判定する。
     *
     * @return 2つの角度が誤差範囲内かどうか。
     */
    public boolean nears(@NonNull Direction direction) {
        return isNear(angle, direction.getAngle());
    }

    /**
     * 相対的な方向を求める。
     *
     * @param direction 相対化する方向。
     * @return 相対的な方向。
     */
    public Direction relativize(@NonNull Direction direction) {
        return new Direction(direction.getAngle() - angle);
    }

}
