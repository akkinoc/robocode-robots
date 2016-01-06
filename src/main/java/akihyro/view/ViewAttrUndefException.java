package akihyro.view;

/**
 * ビュー属性未定義例外。
 */
public class ViewAttrUndefException extends RuntimeException {

    /**
     * コンストラクタ。
     *
     * @param message メッセージ。
     */
    public ViewAttrUndefException(String message) {
        super(message);
    }

}
