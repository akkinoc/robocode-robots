package akihyro;

import java.awt.Color;

import robocode.AdvancedRobot;

/**
 * ロボット: Luceid.
 */
public class Luceid extends AdvancedRobot {

    /** {@inheritDoc} */
    @Override
    public void run() {
        setup();
    }

    /**
     * セットアップする。
     */
    private void setup() {
        setBodyColor(new Color(0x9D, 0x73, 0xBB));
        setGunColor(new Color(0xB6, 0x69, 0x4A));
        setRadarColor(new Color(0xC6, 0xC6, 0xC6));
        setBulletColor(new Color(0xF6, 0xCA, 0x06));
        setScanColor(new Color(0x23, 0xAC, 0x0E));
    }

}
