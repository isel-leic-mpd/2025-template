package pt.isel.mpd.mycine_streams;

import pt.isel.mpd.mycine_streams.dto.*;
import pt.isel.mpd.mycine_streams.model.*;
import java.util.List;
import java.util.stream.Stream;

import static pt.isel.mpd.mycine_utils.Errors.TODO;

public class MoviesDbService {

	private MoviesDbWebApi api;
	
	public Stream<TvSeries> searchByGenre(int maxSeries, List<Integer> genreIds) {
		// TO IMPLEMENT
		TODO("searchByGenre");
		return  Stream.empty();
	}

	public Stream<TvSeries> searchByName(int maxSeries, String match ) {
		TODO("searchByName");
		return Stream.empty();
	}

	public Stream<Genre> getGenres() {
		TODO("getGenres");
		return Stream.empty();
	}

	public Stream<Genre> getGenres(List<Integer> genreIds) {
		TODO("getGenres");
		return Stream.empty();
	}

	public Stream<TvSeries> getTvSeriesRecommendations(int maxSeries, int tvSeriesId) {
		TODO("getTvSeriesRecommendations");
		return  Stream.empty();
	 
	}

	public Stream<Actor> getTvSeriesActors(int tvSeriesId) {
		TODO("getTvSeriesActors");
		return Stream.empty();
	}
	
	public Stream<TvSeries> getActorTvSeries(int actorId) {
		TODO("getActorTvSeries");
		return Stream.empty();
	}
	
	private TvSeries dtoToTvSeries(TvSeriesDto dto) {
		return new TvSeries(
			dto.getStartDate(),
			dto.getName(),
			dto.getId(),
			dto.getPopularity(),
			dto.getNetworks(),
			getTvSeriesActors(dto.getId()),
			getGenres(dto.getGenreIds()),
			// Altere este código para
			// poder especificar o máximo de séries na
			// chamada ao método getSeries de Genre
			getTvSeriesRecommendations(100, dto.getId()));
	}

	

	private Genre dtoToGenre(GenreDto dto) {
	    return new Genre(dto.getId(),
		                 dto.getName(),
						 // Altere este código para
						 // poder especificar o máximo de séries na
						 // chamada ao método getSeries de Genre
		                 searchByGenre(20, List.of(dto.getId())));
	}

	private Actor dtoToActor(ActorDto dto) {
		return new Actor(dto.getId(),
						dto.getName(),
						dto.getPopularity(),
						getActorTvSeries(dto.getId()));
	}

	public MoviesDbService(MoviesDbWebApi api) {
		this.api = api;
	}
}
