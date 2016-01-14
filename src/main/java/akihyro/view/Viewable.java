package akihyro.view;

/**
 * ビュー化可能なことを表すインターフェイス。
 */
public interface Viewable {

    /**
     * ビューを取得する。
     *
     * @return ビュー。
     */
    View view();

}
