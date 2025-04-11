package pt.isel.mpd.mycine_utils.streams;

import java.util.*;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static pt.isel.mpd.mycine_utils.Errors.TODO;

public class StreamUtils {

	public static <T> Supplier<Stream<T>> cache(Stream<T> src) {
		TODO("cache");
		return null;
	}
	
	public static <T> Stream<T> sortedIntersection(Comparator<T> cmp, Stream<T> s1, Stream<T> s2) {
		TODO("sortedIntersection");
		return null;
	}
}