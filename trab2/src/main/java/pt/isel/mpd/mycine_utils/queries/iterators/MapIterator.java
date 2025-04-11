package pt.isel.mpd.mycine_utils.queries.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MapIterator<T,U> implements Iterator<U> {

    private final Iterator<T> srcIt;
    private final  Function<T,U> mapper;

    public MapIterator(Iterable<T> src,
                       Function<T,U> mapper) {
        this.srcIt = src.iterator();
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return srcIt.hasNext();
    }

    @Override
    public U next() {
        if (!hasNext()) throw new NoSuchElementException();
        /*
        T srcElem = srcIt.next();
        U nextElem = mapper.apply(srcElem);
        return nextElem;
         */
        return mapper.apply(srcIt.next());
    }
}
