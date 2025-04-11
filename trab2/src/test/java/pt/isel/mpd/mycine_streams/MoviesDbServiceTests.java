package pt.isel.mpd.mycine_streams;

import org.junit.jupiter.api.Test;
import pt.isel.mpd.mycine_streams.model.Genre;
import pt.isel.mpd.mycine_streams.model.TvSeries;
import pt.isel.mpd.mycine_utils.requests.CounterRequest;
import pt.isel.mpd.mycine_utils.requests.HttpRequest;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoviesDbServiceTests {

	@Test
	public void getGenresTest() {
		CounterRequest req = new CounterRequest( new HttpRequest() );
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));

		Stream<Genre> sgenres = serv.getGenres();
		assertEquals(0, req.getCount());

		List<Genre> genres = sgenres.collect(toList());
		genres.forEach(System.out::println);
		assertEquals(16, genres.size());
		assertEquals(1, req.getCount());
	}

	
	@Test
	public void getCrimeAndOrMisteryTvSeriesTest() {
		CounterRequest req = new CounterRequest( new HttpRequest() );
		int misteryGenreId = 9648;
		int crimeGenreId = 80;
		int maxSeries = 40;

		MoviesDbService serv =
			new MoviesDbService(
				new MoviesDbWebApi(
					req
				)
			);
		
		Stream<TvSeries> series =
			serv.searchByGenre(maxSeries, List.of(misteryGenreId, crimeGenreId) );

		assertEquals(0, req.getCount());
		System.out.println(series.count());

		assertEquals(2, req.getCount());

		Stream<TvSeries> firstTen =
				serv.searchByGenre(maxSeries, List.of(misteryGenreId, crimeGenreId))
				.limit(10);

		assertEquals(2, req.getCount());

		firstTen.forEach(series2 -> {
			System.out.println(series2.getName() + " actors:");
			series2.getActors().forEach(System.out::println);
			System.out.println();
		});
	 
		assertEquals(13, req.getCount());
		
	}

	@Test
	public void getActorsOfWestWorldSeriesTest() {
		int westWorldSeriesId = 63247; // WestWorld, 2020
		CounterRequest req = new CounterRequest(new HttpRequest());
		MoviesDbService serv =
			  new MoviesDbService(new MoviesDbWebApi(req));

		
		var actorsList = serv.getTvSeriesActors(westWorldSeriesId).toList();
		actorsList.forEach(System.out::println);
		assertEquals(1, req.getCount());
		assertEquals(9, actorsList.size());
		assertEquals(1, req.getCount());
	}

 

	@Test
	public void getRachelWoodMoviesTest() {
		CounterRequest req = new CounterRequest(new HttpRequest());
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));

		int rachelWoodId = 38940;
		Stream<TvSeries> seriesStream =
			serv.getActorTvSeries(rachelWoodId);
		assertEquals(0, req.getCount());

		var seriesList = seriesStream.collect(toList());
		
		seriesList.forEach(System.out::println);
		assertEquals(1, req.getCount());
		assertEquals(28, seriesList.size());
	}


}
