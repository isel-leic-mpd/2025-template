package pt.isel.mpd.mycine_utils.queries.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

public class FlatMapIterator<T,U> implements Iterator<U> {

    private final Function<T, Iterable<U>> mapper;
    private final Iterator<T> srcIt;

    private Optional<U> value = Optional.empty();

    private Iterator<U> itCurr = null;

    public FlatMapIterator(Iterable<T> src, Function<T,Iterable<U>> mapper) {
        this.srcIt  = src.iterator();
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        if (value.isPresent()) return true;
        while(itCurr == null || !itCurr.hasNext()) {
            if (!srcIt.hasNext()) return false;
            itCurr = mapper.apply(srcIt.next()).iterator();
        }
        value = Optional.of(itCurr.next());

        return true;
    }

    @Override
    public U next() {
        if (!hasNext())
            throw new NoSuchElementException();
        var next = value.get();
        value = Optional.empty();
        return next;
    }
}
