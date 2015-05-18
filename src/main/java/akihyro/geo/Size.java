package akihyro.geo;

import static robocode.util.Utils.isNear;

import lombok.NonNull;
import lombok.Value;

/**
 * サイズ。
 * 二次元の寸法を示す。
 */
@Value
public class Size {

    /**
     * 幅。
     */
    private final double width;

    /**
     * 高さ。
     */
    private final double height;

    /**
     * 2つの寸法が誤差範囲内かどうか判定する。
     *
     * @return 2つの寸法が誤差範囲内かどうか。
     */
    public boolean nears(@NonNull Size size) {
        return isNear(width, size.width) && isNear(height, size.height);
    }

}
