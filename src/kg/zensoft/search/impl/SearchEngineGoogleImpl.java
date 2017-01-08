package kg.zensoft.search.impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import kg.zensoft.model.Result;
import kg.zensoft.search.SearchEngine;

/**
 * 
 * @author Mickey
 *
 */
public class SearchEngineGoogleImpl implements SearchEngine {

	private Result result;

	/**
	 * 
	 * @param String keyword to search
	 * @return Result
	 */
	@Override
	public Result search(String text) throws IOException {
		result = new Result();
		System.out.println("\tGoogle Search Engine: ");
		Document document = Jsoup.connect("https://www.google.com/search?q=" + text).timeout(10000)
				.userAgent(USER_AGENT).get();

		Element onlySearches = document.getElementsByClass("srg").first();
		String url = onlySearches.getElementsByTag("cite").first().text();
		String title = onlySearches.getElementsByClass("r").first().text();

		result.setURL(url);
		result.setTitle(title);
		return result;
	}
}
