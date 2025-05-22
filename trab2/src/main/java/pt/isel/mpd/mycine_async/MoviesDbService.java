package pt.isel.mpd.mycine_async;

import pt.isel.mpd.mycine_async.dto.ActorDto;
import pt.isel.mpd.mycine_async.dto.GenreDto;
import pt.isel.mpd.mycine_async.dto.TvSeriesDto;
import pt.isel.mpd.mycine_async.model.Actor;
import pt.isel.mpd.mycine_async.model.Genre;
import pt.isel.mpd.mycine_async.model.TvSeries;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static pt.isel.mpd.mycine_utils.Errors.TODO;

public class MoviesDbService {

	private MoviesDbWebApi api;

	/**
	 * get 2 pages in parallel starting from firstPage
	 * @param startPage
	 * @param genreIds
	 * @return
	 */
	public CompletableFuture<List<TvSeries>> searchByGenreParallel(int startPage, List<Integer> genreIds) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(List.of());
	}
	
	public CompletableFuture<Stream<TvSeries>>  searchByNameParallel(int maxSeries, String match ) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(Stream.empty());
	}
	
	public CompletableFuture<Stream<TvSeries>> searchByGenre(int maxSeries, List<Integer> genreIds) {
		// TO IMPLEMENT
		// BETTER USE searchByGenreParallel
		return CompletableFuture.completedFuture(Stream.empty());
	}

	public CompletableFuture<Stream<TvSeries>>  searchByName(int maxSeries, String match ) {
		// TO IMPLEMENT
		// BETTER USE searchByNameParallel
		return CompletableFuture.completedFuture(Stream.empty());
	}
	
	public CompletableFuture<Stream<TvSeries>>  getTvSeriesRecommendations(int maxSeries, int tvSeriesId) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(Stream.empty());
	}

	public CompletableFuture<Stream<Genre>> getGenres() {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(Stream.empty());
	}

	public CompletableFuture<Stream<Genre>> getGenres(List<Integer> genreIds) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(Stream.empty());
	}

	public CompletableFuture<Stream<Actor>> getTvSeriesActors(int tvSeriesId) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(Stream.empty());
	}
	
	public CompletableFuture<Stream<TvSeries>> getActorTvSeries(int actorId) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(Stream.empty());
	}
	
	private TvSeries dtoToTvSeries(TvSeriesDto dto) {
		return new TvSeries(
			dto.getStartDate(),
			dto.getName(),
			dto.getId(),
			dto.getPopularity(),
			dto.getNetworks(),
			// TO CHANGE nulls
			null,
			null,
			null);
	}
	
	private Genre dtoToGenre(GenreDto dto) {
	    return new Genre(dto.getId(),
		                 dto.getName(),
						 // TO CHANGE null
						null);
	}

	private Actor dtoToActor(ActorDto dto) {
		return new Actor(dto.getId(),
						dto.getName(),
						dto.getPopularity(),
						// TO CHANGE null
						null);
	}

	public MoviesDbService(MoviesDbWebApi api) {
		this.api = api;
	}
}
