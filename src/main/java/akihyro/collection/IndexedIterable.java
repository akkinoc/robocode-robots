package akihyro.collection;

import static java.util.Arrays.asList;

import lombok.Getter;
import lombok.NonNull;

/**
 * インデックス付きで反復可能な {@link Iterable}。
 *
 * @param <T> 反復する要素のタイプ。
 */
public class IndexedIterable<T> implements Iterable<IndexedElement<T>> {

    /**
     * ソースとなる {@link Iterable}。
     */
    @Getter
    private final Iterable<T> source;

    /**
     * コンストラクタ。
     *
     * @param source ソースとなる {@link Iterable}。
     */
    protected IndexedIterable(@NonNull Iterable<T> source) {
        this.source = source;
    }

    /** {@inheritDoc} */
    @Override
    public IndexedIterator<T> iterator() {
        return IndexedIterator.withIndex(source.iterator());
    }

    /**
     * インデックス付きで反復可能な {@link Iterable} に変換する。
     *
     * @param <T> 反復する要素のタイプ。
     * @param source ソースとなる配列。
     * @return インデックス付きで反復可能な {@link Iterable}。
     */
    public static <T> IndexedIterable<T> withIndex(@NonNull T... source) {
        return withIndex(asList(source));
    }

    /**
     * インデックス付きで反復可能な {@link Iterable} に変換する。
     *
     * @param <T> 反復する要素のタイプ。
     * @param source ソースとなる {@link Iterable}。
     * @return インデックス付きで反復可能な {@link Iterable}。
     */
    public static <T> IndexedIterable<T> withIndex(@NonNull Iterable<T> source) {
        return new IndexedIterable<>(source);
    }

}
