package pt.isel.mpd.mycine_utils.requests;

import java.io.Reader;

public interface Request {
	Reader get(String path);
}
