package akihyro.geom;

import static java.lang.Math.max;
import static java.lang.Math.min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import static robocode.util.Utils.isNear;

/**
 * サイズ。
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
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
     * サイズを取得する。
     *
     * @param width 幅。
     * @param height 高さ。
     * @return サイズ。
     */
    public static Size of(double width, double height) {
        if (width == EMPTY.width() && height == EMPTY.height()) {
            return EMPTY;
        }
        return new Size(width, height);
    }

    /**
     * 空かどうか判定する。
     *
     * @return 空かどうか。
     */
    public boolean isEmpty() {
        return width() == 0.0 || height() == 0.0;
    }

    /**
     * 和集合を採る。
     *
     * @param size サイズ。
     * @return 和集合を表すサイズ。
     */
    public Size union(@NonNull Size size) {
        return of(
                max(width(), size.width()),
                max(height(), size.height())
        );
    }

    /**
     * 積集合を採る。
     *
     * @param size サイズ。
     * @return 積集合を表すサイズ。
     */
    public Size intersect(@NonNull Size size) {
        return of(
                min(width(), size.width()),
                min(height(), size.height())
        );
    }

    /**
     * 加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plus(@NonNull Size size) {
        return of(
                width() + size.width(),
                height() + size.height()
        );
    }

    /**
     * 幅を加算する。
     *
     * @param width 幅。
     * @return 加算後のサイズ。
     */
    public Size plusWidth(double width) {
        return of(
                width() + width,
                height()
        );
    }

    /**
     * 高さを加算する。
     *
     * @param height 高さ。
     * @return 加算後のサイズ。
     */
    public Size plusHeight(double height) {
        return of(
                width(),
                height() + height
        );
    }

    /**
     * 水平方向に加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plusHorizontal(@NonNull Size size) {
        return of(
                width() + size.width(),
                max(height(), size.height())
        );
    }

    /**
     * 垂直方向に加算する。
     *
     * @param size サイズ。
     * @return 加算後のサイズ。
     */
    public Size plusVertical(@NonNull Size size) {
        return of(
                max(width(), size.width()),
                height() + size.height()
        );
    }

    /**
     * 近似かどうか判定する。
     *
     * @param size サイズ。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Size size) {
        return isNear(width(), size.width()) && isNear(height(), size.height());
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "(" + width() + " x " + height() + ")";
    }

}
