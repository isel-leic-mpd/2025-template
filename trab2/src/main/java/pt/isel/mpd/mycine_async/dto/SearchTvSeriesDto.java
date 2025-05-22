package pt.isel.mpd.mycine_async.dto;

import java.util.List;

public class SearchTvSeriesDto {
	private int page;
	private List<TvSeriesDto> results;
	private int total_pages;
	private int total_results;

	public List<TvSeriesDto> getResults() {
		return results;
	}
}
