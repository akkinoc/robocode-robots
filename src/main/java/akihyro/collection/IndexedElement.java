package akihyro.collection;

import lombok.Value;

/**
 * インデックス付きのコレクション要素。
 *
 * @param 値のタイプ。
 */
@Value
public class IndexedElement<T> {

    /**
     * インデックス。
     */
    private final int index;

    /**
     * 値。
     */
    private final T value;

}
