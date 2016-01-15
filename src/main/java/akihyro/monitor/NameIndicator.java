package akihyro.monitor;

import akihyro.graphics.context.GraphicsContext;
import akihyro.graphics.view.DelegateView;
import akihyro.graphics.view.TextView;
import akihyro.graphics.view.View;
import java.awt.Color;
import java.awt.Font;
import lombok.Getter;
import lombok.NonNull;
import robocode.Robot;

/**
 * ロボット名インジケータ。
 */
public class NameIndicator extends Indicator {

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
    public NameIndicator(@NonNull Robot robot) {
        this.robot = robot;
        this.view = new NameIndicatorView();
    }

    /**
     * ロボット名インジケータビュー。
     */
    protected class NameIndicatorView extends DelegateView {

        /**
         * ロボット名ビュー。
         */
        private final TextView nameView = new TextView()
                .pattern(Color.WHITE)
                .font(new Font(Font.MONOSPACED, Font.BOLD, 12));

        /**
         * コンストラクタ。
         */
        public NameIndicatorView() {
            view(nameView);
        }

        /** {@inheritDoc} */
        @Override
        public NameIndicatorView layout(GraphicsContext context) {
            nameView.text(robot().getName());
            super.layout(context);
            return this;
        }

    }

}
