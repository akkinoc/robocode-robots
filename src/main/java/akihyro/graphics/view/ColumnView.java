package akihyro.graphics.view;

import akihyro.geom.Point;
import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
import akihyro.graphics.scope.TranslateScope;
import static java.util.Collections.emptyList;
import java.util.List;
import lombok.Cleanup;
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
    public ColumnView layout(@NonNull GraphicsContext context) {
        size = Size.EMPTY;
        for (View view : views()) {
            view.layout(context);
            size = size.joinVertical(view.size());
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ColumnView paint(@NonNull GraphicsContext context) {
        Point offset = Point.of(0.0, size().height());
        for (View view : views()) {
            offset = offset.offsetY(- view.size().height());
            @Cleanup TranslateScope translateScope = new TranslateScope(context, offset).begin();
            view.paint(context);
        }
        return this;
    }

}
