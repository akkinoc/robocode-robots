package akihyro;

import java.awt.Color;

import akihyro.log.Log;

/**
 * Robot: Luceid.
 */
public class Luceid extends AbstractRobot {

    /**
     * ログ。
     */
    private final Log log = getLog();

    /** {@inheritDoc} */
    @Override
    protected void setup() {
        log.startMethod();

        // 塗装する
        setBodyColor(new Color(0x9D, 0x73, 0xBB));
        setGunColor(new Color(0xB6, 0x69, 0x4A));
        setRadarColor(new Color(0xC6, 0xC6, 0xC6));
        setBulletColor(new Color(0xF6, 0xCA, 0x06));
        setScanColor(new Color(0x23, 0xAC, 0x0E));

        log.endMethod();
    }

    /** {@inheritDoc} */
    @Override
    protected void tick() {
        log.startMethod();

        // TODO
        doNothing();

        log.endMethod();
    }

}
