package akihyro.geom;

import lombok.Data;
import lombok.NonNull;

/**
 * 矩形。
 */
@Data
public class Rect {

    /**
     * ポイント (左下隅)。
     */
    @NonNull
    private final Point point;

    /**
     * サイズ。
     */
    @NonNull
    private final Size size;

    /**
     * 近似かどうか判定する。
     *
     * @param rect 矩形。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Rect rect) {
        return point().nears(rect.point())
                && size().nears(rect.size());
    }

}
