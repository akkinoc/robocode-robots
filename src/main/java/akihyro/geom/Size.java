package akihyro.geom;

import lombok.Data;
import lombok.NonNull;
import robocode.util.Utils;

/**
 * サイズ。
 */
@Data
public class Size {

    /**
     * 空のサイズ。
     */
    public static final Size EMPTY = new Size(0.0, 0.0);

    /**
     * 幅。
     */
    protected final double width;

    /**
     * 高さ。
     */
    protected final double height;

    /**
     * 2つのサイズを結合する。
     *
     * @param size 結合するサイズ。
     * @return 結合後のサイズ。
     */
    public Size union(@NonNull Size size) {
        return new Size(width + size.width, height + size.height);
    }

    /**
     * 2つのサイズを水平方向に結合する。
     *
     * @param size 結合するサイズ。
     * @return 結合後のサイズ。
     */
    public Size unionHorizontal(@NonNull Size size) {
        return new Size(width + size.width, Math.max(height, size.height));
    }

    /**
     * 2つのサイズを垂直方向に結合する。
     *
     * @param size 結合するサイズ。
     * @return 結合後のサイズ。
     */
    public Size unionVertical(@NonNull Size size) {
        return new Size(Math.max(width, size.width), height + size.height);
    }

    /**
     * 2つのサイズが近似かどうか判定する。
     *
     * @param size 比較対象のサイズ。
     * @return 2つのサイズが近似かどうか。
     */
    public boolean nears(@NonNull Size size) {
        return Utils.isNear(width, size.width) && Utils.isNear(height, size.height);
    }

}
