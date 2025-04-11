package pt.isel.mpd.mycine_utils.requests;

import pt.isel.mpd.mycine_utils.resources.ResourceUtils;

import java.io.Reader;

public class MockRequest implements Request{
	
	@Override
	public Reader get(String path) {
		return ResourceUtils.getFromCache(path);
	}
	
}
