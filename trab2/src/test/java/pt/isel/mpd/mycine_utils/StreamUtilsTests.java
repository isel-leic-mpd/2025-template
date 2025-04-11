package pt.isel.mpd.mycine_utils;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pt.isel.mpd.mycine_utils.streams.StreamUtils.*;



public class StreamUtilsTests {
	
	@Test
	public void intersectionTest() {
		Comparator<Integer> cmp = Comparator.comparing((Integer v) -> v);

		Stream<Integer> ints1 = Stream.of(3, 1, 5, 9, 7, 7).sorted(cmp);
		Stream<Integer> ints2 = Stream.of(5, 3, 4, 7, 10, 12).sorted(cmp);
		var expected = List.of(3, 5, 7);

		Stream<Integer> res = sortedIntersection(cmp, ints1, ints2);
		var list = res.collect(Collectors.toList());
		System.out.println(list);

		assertEquals(expected, list);
	}
}
