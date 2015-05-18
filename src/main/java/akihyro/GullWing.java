package akihyro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.BUTTON1;
import static java.awt.event.MouseEvent.BUTTON3;
import java.awt.event.MouseWheelEvent;
import static java.lang.Math.PI;
import static java.lang.Math.abs;

import robocode.Rules;

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

    /**
     * 弾丸のパワー。
     */
    private double bulletPower = 1.0;

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

        // 砲台の回転を独立させる
        setAdjustGunForRobotTurn(true);

        // 目的地を初期化する
        destination = getPosition();

        log.endMethod();
    }

    /** {@inheritDoc} */
    @Override
    protected void tick() {
        setPathToDestination();
        execute();
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

        // 目的地をマウス位置にセットする
        destination = new Point(event.getX(), event.getY());

    }

    /** {@inheritDoc} */
    @Override
    public void onMouseClicked(MouseEvent event) {
        log.startMethod(event);

        // 左クリックで弾丸を発射する
        // 右クリックで弾丸のパワーを切り替える
        if (event.getButton() == BUTTON1) {
            setFireBullet(bulletPower);
        } else if (event.getButton() == BUTTON3) {
            bulletPower += Rules.MAX_BULLET_POWER / 3.0;
            if (bulletPower > Rules.MAX_BULLET_POWER) {
                bulletPower = Rules.MAX_BULLET_POWER / 3.0;
            }
        }

        log.endMethod();
    }

    /** {@inheritDoc} */
    @Override
    public void onMouseWheelMoved(MouseWheelEvent event) {
        log.startMethod(event);

        // マウスホイールで砲台を回転させる
        double angle = getGunTurnRemainingRadians() + PI / 20 * event.getWheelRotation();
        setTurnGunRightRadians(angle);

        log.endMethod();
    }

    /** {@inheritDoc} */
    @Override
    public void onPaint(Graphics2D graphics) {
        paintDestination(graphics);
    }

    /**
     * 目的地を描画する。
     *
     * @param graphics グラフィックス。
     */
    private void paintDestination(Graphics2D graphics) {
        int x = (int) destination.getX();
        int y = (int) destination.getY();
        int r = 15;
        graphics.setColor(new Color(0xFF, 0x33, 0x33, 0xCC));
        graphics.drawOval(x - r, y - r, r * 2, r * 2);
        graphics.drawLine(x, y - r / 2, x, y + r / 2);
        graphics.drawLine(x - r / 2, y, x + r / 2, y);
    }

}
