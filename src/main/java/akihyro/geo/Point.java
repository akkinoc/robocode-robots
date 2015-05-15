package akihyro.geo;

import lombok.Value;

/**
 * 座標。
 */
@Value
public class Point {

    /**
     * X。
     */
    private final double x;

    /**
     * Y。
     */
    private final double y;

    /**
     * コンストラクタ。
     *
     * @param x X。
     * @param y Y。
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
