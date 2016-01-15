package akihyro.monitor;

import akihyro.geom.Point;
import akihyro.graphics.context.GraphicsContext;
import akihyro.graphics.view.ColumnView;
import akihyro.graphics.view.DelegateView;
import akihyro.graphics.view.TextView;
import akihyro.graphics.view.View;
import java.awt.Color;
import java.awt.Font;
import static java.util.Arrays.asList;
import lombok.Getter;
import lombok.NonNull;
import robocode.Robot;

/**
 * ロボット位置インジケータ。
 */
public class PositionIndicator extends Indicator {

    /**
     * ロボット。
     */
    @Getter
    private final Robot robot;

    /**
     * ビュー。
     */
    @Getter
    private final View view;

    /**
     * コンストラクタ。
     *
     * @param robot ロボット。
     */
    public PositionIndicator(@NonNull Robot robot) {
        this.robot = robot;
        this.view = new PositionIndicatorView();
    }

    /**
     * ロボット位置インジケータビュー。
     */
    protected class PositionIndicatorView extends DelegateView {

        /**
         * タイトルビュー。
         */
        private final TextView titleView = new TextView()
                .text("-- Position --")
                .pattern(Color.LIGHT_GRAY)
                .font(new Font(Font.MONOSPACED, Font.BOLD, 12));

        /**
         * ロボット位置ビュー。
         */
        private final TextView positionView = new TextView()
                .pattern(Color.WHITE)
                .font(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        /**
         * コンストラクタ。
         */
        public PositionIndicatorView() {
            view(new ColumnView().views(asList(titleView, positionView)));
        }

        /** {@inheritDoc} */
        @Override
        public PositionIndicatorView layout(GraphicsContext context) {
            positionView.text(Point.of(robot().getX(), robot().getY()).toString());
            super.layout(context);
            return this;
        }

    }

}
