package akihyro.graphics.view;

import akihyro.geom.Point;
import akihyro.geom.Size;
import akihyro.graphics.scope.TranslateScope;
import java.awt.Graphics2D;
import static java.util.Collections.emptyList;
import java.util.List;
import lombok.Cleanup;
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
        Point offset = Point.of(0.0, 0.0);
        for (View view : views()) {
            @Cleanup TranslateScope translateScope = new TranslateScope(graphics, offset).begin();
            view.paint(graphics);
            offset = offset.offsetX(view.size().width());
        }
        return this;
    }

}
