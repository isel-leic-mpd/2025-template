package pt.isel.mpd.mycine_async.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TvSeriesDto {
	private String first_air_date;
	private  int[] genre_ids;
	private  int id;
	private  String name;
	private  double popularity;
	private List<NetworkDto> networks;
	
	public LocalDate getStartDate() {
		if (first_air_date == null || first_air_date.isEmpty())
			return LocalDate.of(2000,1,1);
		return LocalDate.parse(first_air_date);
	}

	public String getName() {
		return name;
	}

	public List<String> getNetworks() {
		return
			networks == null ? List.of() :
			networks.stream().map( n -> n.name).toList();
	}
	
	public int getId() {
		return id;
	}

	public double getPopularity() {
		return popularity;
	}

	public List<Integer> getGenreIds() {
		var ids = new ArrayList<Integer>();
		for( var genre_id : genre_ids) ids.add(genre_id);
		return ids;
	}
	
	public String toString() {
		return "{ "
			+ "series name=" + getName()
			+ ", start_date=" + getStartDate()
			+ ", series_id=" + id
			+ ", popularity=" + popularity
		    + ", genre ids=" + getGenreIds()
			+ " }";
	}
	
}
