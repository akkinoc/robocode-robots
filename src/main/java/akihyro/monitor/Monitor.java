package akihyro.monitor;

import akihyro.graphics.view.ColumnView;
import akihyro.graphics.view.DelegateView;
import akihyro.graphics.view.PanelView;
import akihyro.graphics.view.View;
import akihyro.graphics.view.Viewable;
import static java.util.Arrays.asList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import lombok.Getter;
import lombok.NonNull;

/**
 * モニタ。
 */
public class Monitor implements Viewable {

    /**
     * インジケータリスト。
     */
    @Getter
    private final List<Indicator> indicators;

    /**
     * ビュー。
     */
    @Getter
    private final View view;

    /**
     * コンストラクタ。
     *
     * @param indicators インジケータリスト。
     */
    public Monitor(@NonNull Indicator... indicators) {
        this.indicators = asList(indicators);
        this.view = new MonitorView();
    }

    /**
     * モニタビュー。
     */
    protected class MonitorView extends DelegateView {

        /**
         * インジケータリストビュー。
         */
        private final ColumnView indicatorsView = new ColumnView()
                .views(indicators().stream().map(Indicator::view).collect(toList()));

        /**
         * コンストラクタ。
         */
        public MonitorView() {
            view(new PanelView().view(indicatorsView));
        }

    }

}
