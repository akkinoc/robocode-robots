package akihyro.graphics.view;

import akihyro.geom.Point;
import akihyro.geom.RectEdge;
import akihyro.geom.Size;
import akihyro.graphics.context.GraphicsContext;
import akihyro.graphics.scope.TranslateScope;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * エッジ付きで描画するビュー。
 */
public class EdgedView extends View {

    /**
     * ビュー。
     */
    @NonNull
    @Getter
    @Setter
    private View view = EmptyView.INSTANCE;

    /**
     * エッジ。
     */
    @NonNull
    @Getter
    @Setter
    private RectEdge edge = RectEdge.EMPTY;

    /**
     * サイズ。
     */
    @Getter
    private Size size = Size.EMPTY;

    /**
     * オフセット。
     */
    private Point offset = Point.ORIGIN;

    /** {@inheritDoc} */
    @Override
    public EdgedView layout(@NonNull GraphicsContext context) {
        view().layout(context);
        size = view().size().edged(edge());
        offset = Point.of(edge().left(), edge().bottom());
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public EdgedView paint(@NonNull GraphicsContext context) {
        @Cleanup TranslateScope translateScope = new TranslateScope(context, offset).begin();
        view().paint(context);
        return this;
    }

}
