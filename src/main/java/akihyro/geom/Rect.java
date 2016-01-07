package akihyro.geom;

import lombok.Data;
import lombok.NonNull;

/**
 * 矩形。
 */
@Data
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
     * 右上隅のポイントを取得する。
     *
     * @return 右上隅のポイント。
     */
    public Point topRight() {
        return new Point(right(), top());
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
     * 近似かどうか判定する。
     *
     * @param rect 矩形。
     * @return 近似かどうか。
     */
    public boolean nears(@NonNull Rect rect) {
        return bottomLeft().nears(rect.bottomLeft())
                && size().nears(rect.size());
    }

}
