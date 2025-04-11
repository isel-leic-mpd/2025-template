package pt.isel.mpd.mycine_utils.queries.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {
    private final Iterator<T> srcIt;
    private final Predicate<T> pred;

    private Optional<T> value = Optional.empty();

    public FilterIterator(Iterable<T> src,
                       Predicate<T> pred) {
        this.srcIt = src.iterator();
        this.pred = pred;
    }

    @Override
    public boolean hasNext() {
        if (value.isPresent()) return true;
        while(srcIt.hasNext()) {
            T newVal = srcIt.next();
            if (pred.test(newVal)) {
                value = Optional.of(newVal);
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T nextElem = value.get();
        value = Optional.empty();
        return nextElem;
    }
}
