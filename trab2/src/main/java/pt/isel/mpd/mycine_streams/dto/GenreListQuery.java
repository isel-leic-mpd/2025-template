package pt.isel.mpd.mycine_streams.dto;

import java.util.List;

public class GenreListQuery {
	public  final List<GenreDto> genres;

	public GenreListQuery(List<GenreDto> genres) {
		this.genres = genres;
	}

	public List<GenreDto> getGenres() {
		return genres;
	}
}
