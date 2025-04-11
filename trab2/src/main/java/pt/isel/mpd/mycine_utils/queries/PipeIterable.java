package pt.isel.mpd.mycine_utils.queries;

import pt.isel.mpd.mycine_utils.queries.iterators.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface PipeIterable<T> extends Iterable<T> {
    
    // Construction Operations
    
    static <T> PipeIterable<T> from(Iterable<T> src) {
        //  Could be done as an anonymous class like this,
        //  but using the lambda is better
        //        return new PipeIterable<T>() {
        //            @Override
        //            public Iterator<T> iterator() {
        //                return src.iterator();
        //            }
        //        };
        
        return () -> src.iterator();
    }
    
    static <T> PipeIterable<T> iterator(T seed,
                                   UnaryOperator<T> nextValue) {
        return () -> new Iterator<T>() {
            T next = seed;
            @Override
            public boolean hasNext() {
                return true;
            }
            
            @Override
            public T next() {
                var curr = next;
                next = nextValue.apply(curr);
                return curr;
            }
        };
    }

    @SuppressWarnings("unchecked")
    static <T> PipeIterable<T> of( T ... parms ) {
        // TO IMPLEMENT
        return null;
    }
    
    // Intermediate Operations

    default PipeIterable<T> filter(Predicate<T> pred) {
        return () -> new FilterIterator<>(this, pred);
    }
    
    default <U> PipeIterable<U> map(Function<T,U> mapper) {
        return () -> new MapIterator<>(this, mapper);
    }

    default <U> PipeIterable<U> flatMap(Function<T, Iterable<U>> mapper) {
        return () -> new FlatMapIterator<>(this, mapper);
    }
    
    default PipeIterable<T> skip(int n) {
        // TO IMPLEMENT
        return null;
    }
    
  
    default PipeIterable<T> takeWhile(Predicate<T> pred) {
        // TO IMPLEMENT
        return null;
    }
    
    
    default PipeIterable <T> distinct() {
        // TO IMPLEMENT
        return null;
    }
    
// Terminal Operations

    default Optional<T> max(Comparator<T> cmp) {
        T result = null;
        for(var e : this) {
            if (result == null || cmp.compare(e, result) > 0) {
                result = e;
            }
        }
        return Optional.ofNullable(result);
    }
    
    default long count() {
        long result = 0;
        for(var e : this) {
            result++;
        }
        return  result;
    }

    
    default <U> Optional<U> reduce(BiFunction<U,T, U> reducer) {
        // TO IMPLEMENT
        return Optional.empty();
    }
}
