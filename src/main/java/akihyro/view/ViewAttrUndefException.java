package akihyro.view;

/**
 * ビュー属性未定義例外。
 */
public class ViewAttrUndefException extends RuntimeException {

    /**
     * コンストラクタ。
     */
    public ViewAttrUndefException() {
        super("ViewAttr is undefined");
    }

}
