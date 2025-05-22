package pt.isel.mpd.mycine_utils.requests.async;


import pt.isel.mpd.mycine_utils.requests.Request;

import java.io.Reader;
import java.util.concurrent.CompletableFuture;

public class CounterAsyncRequest implements AsyncRequest {
	
	public CounterAsyncRequest(AsyncRequest req) {
		// TO IMPLEMENT
		
	}

	@Override
	public CompletableFuture<Reader> getAsync(String path) {
		// TO IMPLEMENT
		return null;
	}

	public int getCount() {
		// TO IMPLEMENT
		return 0;
	}
}

