package pt.isel.mpd.mycine_async.sequences;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static pt.isel.mpd.mycine_async.sequences.Sequence.empty;
import static pt.isel.mpd.mycine_async.sequences.Sequence.from;


public class SequenceTests {
    @Test
    public void emptySequenceTest() {
        var seq = empty();
        
        assertFalse(seq.tryAdvance((t) -> {
            System.out.println("Não é suposto chegar aqui!");
        }));
    }
    
    @Test
    public void fromIterableSequenceTest() {
        var elems = List.of(1,2,3);
        var seq = from(elems);
        var result = new ArrayList<Integer>();
        while(seq.tryAdvance(t -> result.add(t)));
        assertEquals(elems, result);
    }
}
