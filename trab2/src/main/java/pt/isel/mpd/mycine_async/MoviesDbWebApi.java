package pt.isel.mpd.mycine_async;

import com.google.gson.Gson;
import pt.isel.mpd.mycine_async.dto.*;
import pt.isel.mpd.mycine_utils.requests.Request;
import pt.isel.mpd.mycine_utils.requests.async.AsyncRequest;
import pt.isel.mpd.mycine_utils.resources.ResourceUtils;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class MoviesDbWebApi {
	public final static int API_PAGE_SIZE=20;
	private static final String API_KEY = getApiKeyFromResources();
	private static final String MOVIES_DB_ENDPOINT =  "https://api.themoviedb.org/3/";
 
 
	private static final String TV_SERIES_GENRES =
		MOVIES_DB_ENDPOINT + "genre/tv/list?api_key=" + API_KEY;
 	
	private static final String TV_SERIES_RECOMMENDATIONS =
		MOVIES_DB_ENDPOINT + "tv/%d/recommendations?page=%d&api_key=" + API_KEY;

	private static final String TV_SERIES_SEARCH_BY_NAME =
		MOVIES_DB_ENDPOINT + "search/tv?query=%s&page=%d&api_key=" + API_KEY;

	private static final String TV_SERIES_CREDITS =
		MOVIES_DB_ENDPOINT + "tv/%d/credits?api_key="+ API_KEY;


	protected final Gson gson;
	private final AsyncRequest req;

	/**
	 * Retrieve API-KEY from resources
	 * @return
	 */
	private static String getApiKeyFromResources() {
		try {
			var bufReader = new BufferedReader(ResourceUtils.openResource("movies_db_api_key.txt"));
			return bufReader.readLine();
		} catch(Exception e) {
			throw new IllegalStateException(
				"YOU MUST GET a KEY from themoviedb.org and place it in src/main/resources/movies_db_api_key.txt");
		}
	}

	public CompletableFuture<List<GenreDto>> getGenres() {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(List.of());
	}
	
	
	public CompletableFuture<List<TvSeriesDto>> getTvSeriesRecommendations(int page, int seriesId) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(List.of());
	}

	public CompletableFuture<List<TvSeriesDto>> searchByGenreIds(int page, List<Integer> genreIds) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(List.of());
	}

	public CompletableFuture<List<TvSeriesDto>> searchByName(int page, String nameMatch) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(List.of());
	}

	public CompletableFuture<List<ActorDto>> tvSeriesActors(int tvSeriesId) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(List.of());

	}

	public CompletableFuture<List<TvSeriesDto>> actorSeries(int actorId) {
		// TO IMPLEMENT
		return CompletableFuture.completedFuture(List.of());
	}

	public MoviesDbWebApi(AsyncRequest req) {
		this.req = req;
		gson = new Gson();
	}
}
