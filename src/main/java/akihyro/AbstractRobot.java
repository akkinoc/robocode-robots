package akihyro;

import robocode.AdvancedRobot;

import lombok.Getter;

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

}
