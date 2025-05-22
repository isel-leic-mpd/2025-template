package pt.isel.mpd.mycine_async;

import org.junit.jupiter.api.Test;
import pt.isel.mpd.mycine_async.model.*;
import pt.isel.mpd.mycine_utils.requests.async.*;
import pt.isel.mpd.mycine_utils.requests.async.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoviesDbServiceTests {
 
	@Test
	public void getGenresTest() {
		var req = new CounterAsyncRequest( new HttpAsyncRequest() );
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));
		
		Stream<Genre> sgenres = serv.getGenres().join();
		assertEquals(1, req.getCount());
		
		List<Genre> genres = sgenres.collect(toList());
		genres.forEach(System.out::println);
		assertEquals(16, genres.size());
		assertEquals(1, req.getCount());
	}
	
	
	@Test
	public void getCrimeAndOrMisteryTvSeriesTest() {
  
		var req = new CounterAsyncRequest( new HttpAsyncRequest() );
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
			serv.searchByGenre(maxSeries, List.of(misteryGenreId, crimeGenreId)).join();
		
		assertEquals(2, req.getCount());
		System.out.println(series.count());
		
		assertEquals(2, req.getCount());
		
		Stream<TvSeries> firstTen =
			serv.searchByGenre(maxSeries, List.of(misteryGenreId, crimeGenreId))
				.join()
				.limit(10);
		
		assertEquals(4, req.getCount());
		
		firstTen.forEach(series2 -> {
			System.out.println(series2.getName() + " actors:");
            // TO CHANGE
			series2.getActors()
				   .join()
				   .forEach(System.out::println);
			System.out.println();
		});
		
		assertEquals(14, req.getCount());
		
	}
	
	@Test
	public void getActorsOfWestWorldSeriesTest() {
		int westWorldSeriesId = 63247; // WestWorld, 2020
		var req = new CounterAsyncRequest(new HttpAsyncRequest());
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));
		
		
		var actorsList = serv.getTvSeriesActors(westWorldSeriesId).join().toList();
		actorsList.forEach(System.out::println);
		assertEquals(1, req.getCount());
		assertEquals(9, actorsList.size());
		assertEquals(1, req.getCount());
	}
	
	
	
	@Test
	public void getRachelWoodMoviesTest() {
		var req = new CounterAsyncRequest(new HttpAsyncRequest());
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));
		
		int rachelWoodId = 38940;
		Stream<TvSeries> seriesStream =
			serv.getActorTvSeries(rachelWoodId).join();
		assertEquals(1, req.getCount());
		
		var seriesList = seriesStream.collect(toList());
		
		seriesList.forEach(System.out::println);
		assertEquals(1, req.getCount());
		assertEquals(28, seriesList.size());
	}
 
}
