package pt.isel.mpd.mycine_streams.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static pt.isel.mpd.mycine_utils.Errors.TODO;

public class TvSeries {
	private LocalDate start_date;

	private  int id;
	private  String name;
	private  double popularity;
	private Stream<Actor> actors;
	private  Stream<Genre> genres;
	private  List<String>  networks;
	private  Stream<TvSeries> recommendations;

	public TvSeries(LocalDate start_date,
					String name,
					int id,
					double popularity,
					List<String> networks,
					Stream<Actor> actors,
					Stream<Genre> genres,
					Stream<TvSeries> recommendations
	             ) {
		this.id = id;
		this.name = name;
		this.actors = actors;
		this.genres = genres;
	    this.popularity = popularity;
	    this.start_date = start_date;
	    this.recommendations = recommendations;
		this.networks = networks;
	}
	
	public Stream<Actor> getActors() {
		TODO("getActors");
		return Stream.empty();
	}

	public Stream<Genre> getGenres() {
		TODO("getGenres");
		return Stream.empty();
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getPopularity() {
		return popularity;
	}
	
	public LocalDate getStartDate() {
		return start_date;
	}

	private Stream<String> getNetworks() {
		return  networks.stream();
	}

	public Stream<TvSeries> getRecommendations() {
		TODO("getRecommendations");
		return Stream.empty();
	}

	public String toString() {
		return "{ "
			+ "series name=" + getName()
			+ ", start_date=" + getStartDate()
			+ ", series_id=" + id
			+ ", popularity=" + popularity
			+ ", networks=" + getNetworks ()
			+ " }";
	}
}
