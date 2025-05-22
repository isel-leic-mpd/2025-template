package pt.isel.mpd.mycine_async.model;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static pt.isel.mpd.mycine_utils.Errors.TODO;

public class Genre {
	private int id;
	private String name;

	// TO CHANGE
	Stream<TvSeries> series;

	public Genre(int id, String name, Stream<TvSeries>  series) {
		this.id = id;
		this.name =  name;
		this.series = series;
	}

	public CompletableFuture<Stream<TvSeries>> getSeries() {
		// TO CHANGE
		return CompletableFuture.completedFuture(Stream.empty());
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "{ "
			+ "name = " + name
			+ ", id = " + id
			+ " }";
	}
}
