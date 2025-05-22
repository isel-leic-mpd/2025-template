package pt.isel.mpd.mycine_utils.requests.async;

import java.io.Reader;
import java.util.concurrent.CompletableFuture;

public class SaverAsyncRequest implements AsyncRequest {
    @Override
    public CompletableFuture<Reader> getAsync(String path) {
        // TO IMPLEMENT
        return null;
    }
    
}