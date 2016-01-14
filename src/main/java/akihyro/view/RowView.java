package akihyro.view;

import akihyro.geom.Size;
import java.awt.Graphics2D;
import static java.util.Collections.emptyList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 水平方向に並べて描画するビュー。
 */
public class RowView extends View {

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
    public RowView layout(@NonNull Graphics2D graphics) {
        size = Size.EMPTY;
        for (View view : views()) {
            view.layout(graphics);
            size = size.joinHorizontal(view.size());
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public RowView paint(@NonNull Graphics2D graphics) {
        double offset = 0.0;
        for (View view : views()) {
            graphics.translate(offset, 0.0);
            view.paint(graphics);
            graphics.translate(- offset, 0.0);
            offset += view.size().width();
        }
        return this;
    }

}
