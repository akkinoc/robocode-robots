package akihyro.geom;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 矩形。
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Rect {

    /**
     * 左下隅のポイント。
     */
    @NonNull
    private final Point bottomLeft;

    /**
     * サイズ。
     */
    @NonNull
    private final Size size;

    /**
     * 左下隅を基準として矩形を取得する。
     *
     * @param bottomLeft 左下隅のポイント。
     * @param size サイズ。
     * @return 矩形。
     */
    public static Rect fromBottomLeft(Point bottomLeft, Size size) {
        return new Rect(bottomLeft, size);
    }

    /**
     * 右下隅を基準として矩形を取得する。
     *
     * @param bottomRight 右下隅のポイント。
     * @param size サイズ。
     * @return 矩形。
     */
    public static Rect fromBottomRight(@NonNull Point bottomRight, @NonNull Size size) {
        return fromBottomLeft(bottomRight.offsetX(- size.width()), size);
    }

    /**
     * 左上隅を基準として矩形を取得する。
     *
     * @param topLeft 左上隅のポイント。
     * @param size サイズ。
     * @return 矩形。
     */
    public static Rect fromTopLeft(@NonNull Point topLeft, @NonNull Size size) {
        return fromBottomLeft(topLeft.offsetY(- size.height()), size);
    }

    /**
     * 右上隅を基準として矩形を取得する。
     *
     * @param topRight 右上隅のポイント。
     * @param size サイズ。
     * @return 矩形。
     */
    public static Rect fromTopRight(@NonNull Point topRight, @NonNull Size size) {
        return fromBottomLeft(topRight.offset(- size.width(), - size.height()), size);
    }

    /**
     * 中央を基準として矩形を取得する。
     *
     * @param center 中央のポイント。
     * @param size サイズ。
     * @return 矩形。
     */
    public static Rect fromCenter(@NonNull Point center, @NonNull Size size) {
        return fromBottomLeft(center.offset(- size.width() / 2.0, - size.height() / 2.0), size);
    }

    /**
     * 左下隅のX座標を取得する。
     *
     * @return 左下隅のX座標。
     */
    public double left() {
        return bottomLeft().x();
    }

    /**
     * 左下隅のY座標を取得する。
     *
     * @return 左下隅のY座標。
     */
    public double bottom() {
        return bottomLeft().y();
    }

    /**
     * 右上隅のX座標を取得する。
     *
     * @return 右上隅のX座標。
     */
    public double right() {
        return bottomLeft().x() + size().width();
    }

    /**
     * 右上隅のY座標を取得する。
     *
     * @return 右上隅のY座標。
     */
    public double top() {
        return bottomLeft().y() + size().height();
    }

    /**
     * 中央のX座標を取得する。
     *
     * @return 中央のX座標。
     */
    public double centerX() {
        return bottomLeft().x() + size().width() / 2.0;
    }

    /**
     * 中央のY座標を取得する。
     *
     * @return 中央のY座標。
     */
    public double centerY() {
        return bottomLeft().y() + size().height() / 2.0;
    }

    /**
     * 幅を取得する。
     *
     * @return 幅。
     */
    public double width() {
        return size().width();
    }

    /**
     * 高さを取得する。
     *
     * @return 高さ。
     */
    public double height() {
        return size().height();
    }

    /**
     * 右下隅のポイントを取得する。
     *
     * @return 右下隅のポイント。
     */
    public Point bottomRight() {
        return Point.of(right(), bottom());
    }

    /**
     * 左上隅のポイントを取得する。
     *
     * @return 左上隅のポイント。
     */
    public Point topLeft() {
        return Point.of(left(), top());
    }

    /**
     * 右上隅のポイントを取得する。
     *
     * @return 右上隅のポイント。
     */
    public Point topRight() {
        return Point.of(right(), top());
    }

    /**
     * 中央のポイントを取得する。
     *
     * @return 中央のポイント。
     */
    public Point center() {
        return Point.of(centerX(), centerY());
    }

    /**
     * 近似かどうか判定する。
     *
     * @param rect 比較対象の矩形。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Rect rect) {
        return bottomLeft().nears(rect.bottomLeft()) && size().nears(rect.size());
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "(bottomLeft=" + bottomLeft() + ", size=" + size() + ")";
    }

}
