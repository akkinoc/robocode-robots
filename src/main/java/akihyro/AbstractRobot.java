package akihyro;

import robocode.AdvancedRobot;

import akihyro.log.Logger;

/**
 * ロボットの基底クラス。
 */
public abstract class AbstractRobot extends AdvancedRobot {

    /**
     * ロガー。
     */
    public final Logger log = new Logger(this);

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

}
