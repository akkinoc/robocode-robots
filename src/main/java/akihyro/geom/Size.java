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
    private final double width;

    /**
     * 高さ。
     */
    private final double height;

    /**
     * 空かどうか判定する。
     *
     * @return 空かどうか。
     */
    public boolean isEmpty() {
        return getWidth() == 0.0 || getHeight() == 0.0;
    }

    /**
     * 和集合を採る。
     *
     * @param size サイズ。
     * @return 和集合を表すサイズ。
     */
    public Size union(@NonNull Size size) {
        return new Size(
                Math.max(getWidth(), size.getWidth()),
                Math.max(getHeight(), size.getHeight())
        );
    }

    /**
     * 積集合を採る。
     *
     * @param size サイズ。
     * @return 積集合を表すサイズ。
     */
    public Size intersect(@NonNull Size size) {
        return new Size(
                Math.min(getWidth(), size.getWidth()),
                Math.min(getHeight(), size.getHeight())
        );
    }

    /**
     * 加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plus(@NonNull Size size) {
        return new Size(
                getWidth() + size.getWidth(),
                getHeight() + size.getHeight()
        );
    }

    /**
     * 幅を加算する。
     *
     * @param value 幅。
     * @return 加算後のサイズ。
     */
    public Size plusWidth(double value) {
        return new Size(
                getWidth() + value,
                getHeight()
        );
    }

    /**
     * 高さを加算する。
     *
     * @param value 高さ。
     * @return 加算後のサイズ。
     */
    public Size plusHeight(double value) {
        return new Size(
                getWidth(),
                getHeight() + value
        );
    }

    /**
     * 水平方向に加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plusHorizontal(@NonNull Size size) {
        return new Size(
                getWidth() + size.getWidth(),
                Math.max(getHeight(), size.getHeight())
        );
    }

    /**
     * 垂直方向に加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plusVertical(@NonNull Size size) {
        return new Size(
                Math.max(getWidth(), size.getWidth()),
                getHeight() + size.getHeight()
        );
    }

    /**
     * 近似かどうか判定する。
     *
     * @param size サイズ。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Size size) {
        return Utils.isNear(getWidth(), size.getWidth())
                && Utils.isNear(getHeight(), size.getHeight());
    }

}
