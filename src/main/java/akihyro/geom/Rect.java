package akihyro.geom;

import lombok.Data;
import lombok.NonNull;

/**
 * 長方形。
 */
@Data
public class Rect {

    /**
     * ポイント (左下隅)。
     */
    @NonNull
    protected final Point point;

    /**
     * サイズ。
     */
    @NonNull
    protected final Size size;

    /**
     * 2つの長方形が近似かどうか判定する。
     *
     * @param rect 比較対象の長方形。
     * @return 2つの長方形が近似かどうか。
     */
    public boolean nears(@NonNull Rect rect) {
        return point.nears(rect.point) && size.nears(rect.size);
    }

}
