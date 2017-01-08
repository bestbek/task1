package kg.zensoft.search;

import java.io.IOException;

import kg.zensoft.model.Result;

/**
 * 
 * @author Mickey
 *
 */
public interface SearchEngine {
	String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:49.0) Gecko/20100101 Firefox/49.0";

	Result search(String text) throws IOException;
}
