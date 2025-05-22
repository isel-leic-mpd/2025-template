package pt.isel.mpd.mycine_async.dto;

import java.util.List;

public class TvSeriesQueryDto {
    private List<TvSeriesDto> results;
    private int total_pages;
    private int total_results;
    
    public List<TvSeriesDto> getResults() {
        return results;
    }
    
    public int getTotalResults() {
        return total_results;
    }
    
    public int getTotalPages() {
        return total_pages;
    }
}
