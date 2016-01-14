package akihyro.graphics.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import static java.util.Collections.emptyList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 垂直方向に並べて描画するビュー。
 */
public class ColumnView extends View {

    /**
     * ビューリスト。
     */
    @NonNull
    @Getter
    @Setter
    private List<View> views = emptyList();

    /**
     * サイズ。
     */
    @Getter
    private Size size = Size.EMPTY;

    /** {@inheritDoc} */
    @Override
    public ColumnView layout(@NonNull Graphics2D graphics) {
        size = Size.EMPTY;
        for (View view : views()) {
            view.layout(graphics);
            size = size.joinVertical(view.size());
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ColumnView paint(@NonNull Graphics2D graphics) {
        double offset = size().height();
        for (View view : views()) {
            offset -= view.size().height();
            graphics.translate(0.0, offset);
            view.paint(graphics);
            graphics.translate(0.0, - offset);
        }
        return this;
    }

}
