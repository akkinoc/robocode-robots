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
     * オフセットを採る。
     *
     * @param width 幅の差分。
     * @param height 高さの差分。
     * @return オフセットしたサイズ。
     */
    public Size offset(double width, double height) {
        return of(
                width() + width,
                height() + height
        );
    }

    /**
     * オフセットを採る。
     *
     * @param size 差分。
     * @return オフセットしたサイズ。
     */
    public Size offset(@NonNull Size size) {
        return offset(size.width(), size.height());
    }

    /**
     * 幅のオフセットを採る。
     *
     * @param width 幅の差分。
     * @return オフセットしたサイズ。
     */
    public Size offsetWidth(double width) {
        return offset(width, 0.0);
    }

    /**
     * 高さのオフセットを採る。
     *
     * @param height 高さの差分。
     * @return オフセットしたサイズ。
     */
    public Size offsetHeight(double height) {
        return offset(0.0, height);
    }

    /**
     * 和集合を採る。
     *
     * @param size 集合に含めるサイズ。
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
     * @param size 集合に含めるサイズ。
     * @return 積集合を表すサイズ。
     */
    public Size intersect(@NonNull Size size) {
        return of(
                min(width(), size.width()),
                min(height(), size.height())
        );
    }

    /**
     * 水平方向に連結する。
     *
     * @param size 連結するサイズ。
     * @return 連結後のサイズ。
     */
    public Size joinHorizontal(@NonNull Size size) {
        return of(
                width() + size.width(),
                max(height(), size.height())
        );
    }

    /**
     * 垂直方向に連結する。
     *
     * @param size 連結するサイズ。
     * @return 連結後のサイズ。
     */
    public Size joinVertical(@NonNull Size size) {
        return of(
                max(width(), size.width()),
                height() + size.height()
        );
    }

    /**
     * エッジ付きのサイズを採る。
     *
     * @param edge 矩形エッジ。
     * @return エッジ付きのサイズ。
     */
    public Size edged(@NonNull RectEdge edge) {
        return of(
                width() + edge.left() + edge.right(),
                height() + edge.bottom() + edge.top()
        );
    }

    /**
     * 近似かどうか判定する。
     *
     * @param size 比較対象のサイズ。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Size size) {
        return isNear(width(), size.width()) && isNear(height(), size.height());
    }

}
