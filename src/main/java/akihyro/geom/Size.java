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
     * 空かどうか判定する。
     *
     * @return 空かどうか。
     */
    public boolean isEmpty() {
        return width == 0.0 || height == 0.0;
    }

    /**
     * 和集合を採る。
     *
     * @param size サイズ。
     * @return 和集合を表すサイズ。
     */
    public Size union(@NonNull Size size) {
        return new Size(Math.max(width, size.width), Math.max(height, size.height));
    }

    /**
     * 積集合を採る。
     *
     * @param size サイズ。
     * @return 積集合を表すサイズ。
     */
    public Size intersect(@NonNull Size size) {
        return new Size(Math.min(width, size.width), Math.min(height, size.height));
    }

    /**
     * 加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plus(@NonNull Size size) {
        return new Size(width + size.width, height + size.height);
    }

    /**
     * 幅を加算する。
     *
     * @param value 幅。
     * @return 加算後のサイズ。
     */
    public Size plusWidth(double value) {
        return new Size(width + value, height);
    }

    /**
     * 高さを加算する。
     *
     * @param value 高さ。
     * @return 加算後のサイズ。
     */
    public Size plusHeight(double value) {
        return new Size(width, height + value);
    }

    /**
     * 水平方向に加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plusHorizontal(@NonNull Size size) {
        return new Size(width + size.width, Math.max(height, size.height));
    }

    /**
     * 垂直方向に加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plusVertical(@NonNull Size size) {
        return new Size(Math.max(width, size.width), height + size.height);
    }

    /**
     * 近似かどうか判定する。
     *
     * @param size サイズ。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Size size) {
        return Utils.isNear(width, size.width) && Utils.isNear(height, size.height);
    }

}
