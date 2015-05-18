package akihyro;

import robocode.AdvancedRobot;

import lombok.Getter;

import akihyro.geo.Direction;
import akihyro.geo.Point;
import akihyro.geo.Size;
import akihyro.log.Log;

/**
 * ロボットの基底クラス。
 */
public abstract class AbstractRobot extends AdvancedRobot {

    /**
     * ログ。
     */
    @Getter
    private final Log log = new Log(this);

    /** {@inheritDoc} */
    @Override
    public void run() {
        setup();
        while (true) {
            tick();
        }
    }

    /**
     * セットアップする。
     */
    protected void setup() {
    }

    /**
     * メインループを進める。
     */
    protected void tick() {
        doNothing();
    }

    /**
     * 位置を取得する。
     *
     * @return 位置。
     */
    public Point getPosition() {
        return new Point(getX(), getY());
    }

    /**
     * サイズを取得する。
     *
     * @return サイズ。
     */
    public Size getSize() {
        return new Size(getWidth(), getHeight());
    }

    /**
     * 方向を取得する。
     *
     * @return 方向。
     */
    public Direction getDirection() {
        return new Direction(getHeadingRadians());
    }

}
