package pt.isel.mpd.mycine_async.sequences;

import java.util.function.Consumer;
import java.util.function.Function;

public interface Sequence<T> {
    boolean tryAdvance(Consumer<T> action);
    
    static <T> Sequence<T> from(Iterable<T> src) {
        var it = src.iterator();
        return action -> {
            if (it.hasNext()) {
                action.accept(it.next());
                return true;
            }
            else {
                return false;
            }
        };
    }
    
    static <T> Sequence<T> empty() {
        return action -> false;
    }
    
    default <U> Sequence<U> map(Function<T,U> mapper) {
        return action -> tryAdvance(t ->
                            action.accept(mapper.apply(t))
                         );
    }
    
    
    
}
