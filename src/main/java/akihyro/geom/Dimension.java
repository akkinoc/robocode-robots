package akihyro.geom;

import robocode.util.Utils;

import lombok.NonNull;
import lombok.Value;

/**
 * 寸法。
 * 2次元の面を示す。
 */
@Value
public class Dimension {

    /**
     * 幅。
     */
    private final double width;

    /**
     * 高さ。
     */
    private final double height;

    /**
     * 2つの寸法が近似かどうか判定する。
     *
     * @param dimension 比較対象の寸法。
     * @return 2つの寸法が近似かどうか。
     */
    public boolean isNear(@NonNull Dimension dimension) {
        return Utils.isNear(width, dimension.width) && Utils.isNear(height, dimension.height);
    }

}
