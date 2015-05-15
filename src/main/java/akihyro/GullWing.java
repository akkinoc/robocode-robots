package akihyro;

import java.awt.Color;
import java.awt.event.MouseEvent;

import static robocode.util.Utils.normalRelativeAngle;

import akihyro.geo.Point;
import akihyro.geo.PointToPoint;
import akihyro.log.Log;

/**
 * Robot: GullWing.
 */
public class GullWing extends AbstractRobot {

    /**
     * ログ。
     */
    private final Log log = getLog();

    /**
     * 目的地。
     */
    private Point destination;

    /** {@inheritDoc} */
    @Override
    protected void setup() {
        log.startMethod();

        // 塗装する
        setBodyColor(new Color(0xB4, 0x6A, 0x36));
        setGunColor(new Color(0xB4, 0x6A, 0x36));
        setRadarColor(new Color(0xB4, 0x6A, 0x36));
        setBulletColor(new Color(0xB4, 0x6A, 0x36));
        setScanColor(new Color(0xB4, 0x6A, 0x36));

        // 目的地を初期化する
        destination = getPosition();

        log.endMethod();
    }

    /** {@inheritDoc} */
    @Override
    protected void tick() {
        log.startMethod();

        // 目的地へ向かう
        PointToPoint p2p = new PointToPoint(getPosition(), destination);
        setAhead(p2p.getDistance());
        setTurnRightRadians(normalRelativeAngle(p2p.getDirection() - getHeadingRadians()));

        execute();
        log.endMethod();
    }

    /** {@inheritDoc} */
    @Override
    public void onMouseMoved(MouseEvent event) {
        log.startMethod(event);

        // 目的地をマウス位置にセットする
        destination = new Point(event.getX(), event.getY());

        log.endMethod();
    }

}
