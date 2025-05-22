package pt.isel.mpd.mycine_utils.requests.async;

import java.io.Reader;
import java.util.concurrent.CompletableFuture;

public class MockAsyncRequest implements AsyncRequest {
	
	@Override
	public CompletableFuture<Reader> getAsync(String path) {
		// To implement
		return null;
	}
	
}
