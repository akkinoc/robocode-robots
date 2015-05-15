package akihyro.collection;

import java.util.Iterator;

import lombok.Getter;
import lombok.NonNull;

/**
 * インデックス付きで反復可能な {@link Iterator}。
 *
 * @param <T> 反復する要素のタイプ。
 */
public class IndexedIterator<T> implements Iterator<IndexedElement<T>> {

    /**
     * ソースとなる {@link Iterator}。
     */
    @Getter
    private final Iterator<T> source;

    /**
     * インデックス。
     */
    @Getter
    private int index;

    /**
     * コンストラクタ。
     *
     * @param source ソースとなる {@link Iterator}。
     */
    protected IndexedIterator(@NonNull Iterator<T> source) {
        this.source = source;
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasNext() {
        return source.hasNext();
    }

    /** {@inheritDoc} */
    @Override
    public IndexedElement<T> next() {
        return new IndexedElement<>(index++, source.next());
    }

    /** {@inheritDoc} */
    @Override
    public void remove() {
        source.remove();
    }

    /**
     * インデックス付きで反復可能な {@link Iterator} に変換する。
     *
     * @param <T> 反復する要素のタイプ。
     * @param source ソースとなる {@link Iterator}。
     * @return インデックス付きで反復可能な {@link Iterator}。
     */
    public static <T> IndexedIterator<T> withIndex(@NonNull Iterator<T> source) {
        return new IndexedIterator<>(source);
    }

}
