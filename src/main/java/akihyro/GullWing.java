package akihyro;

import java.awt.Color;
import java.awt.event.MouseEvent;
import static java.lang.Math.PI;
import static java.lang.Math.abs;

import akihyro.geo.Direction;
import akihyro.geo.Line;
import akihyro.geo.Point;
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
        setPathToDestination();
        execute();
        log.endMethod();
    }

    /**
     * 目的地へ向かうよう進路をセットする。
     */
    private void setPathToDestination() {

        // 既に目的地に居るなら何もしない
        Point position = getPosition();
        if (position.nears(destination)) {
            return;
        }

        // 進路をセットする
        Line line = new Line(position, destination);
        Direction direction = getDirection().relativize(new Direction(line.getAngle()));
        double rightAngle = PI / 2.0;
        setAhead(line.getDistance() * (rightAngle - abs(direction.getAngle())) / rightAngle);
        setTurnRightRadians(direction.getAngle());

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
