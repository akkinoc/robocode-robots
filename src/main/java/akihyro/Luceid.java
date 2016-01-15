package akihyro;

import akihyro.graphics.context.GraphicsContext;
import akihyro.monitor.Monitor;
import akihyro.monitor.NameIndicator;
import akihyro.monitor.PositionIndicator;
import java.awt.Graphics2D;
import robocode.AdvancedRobot;

/**
 * Robot: Luceid.
 */
public class Luceid extends AdvancedRobot {

    /**
     * モニタ。
     */
    private final Monitor monitor = new Monitor(
            new NameIndicator(this),
            new PositionIndicator(this)
    );

    /** {@inheritDoc} */
    @Override
    public void onPaint(Graphics2D graphics) {
        GraphicsContext context = new GraphicsContext(this);
        monitor.view().layout(context).paint(context);
    }

}
