package akihyro.geo;

import lombok.Value;

/**
 * サイズ。
 */
@Value
public class Size {

    /**
     * 幅。
     */
    private final double width;

    /**
     * 高さ。
     */
    private final double height;

    /**
     * コンストラクタ。
     *
     * @param width 幅。
     * @param height 高さ。
     */
    public Size(double width, double height) {
        this.width = width;
        this.height = height;
    }

}
