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
public class SearchEngineBingImpl implements SearchEngine {
	private Result result;

	/**
	 * 
	 * @param String
	 *            keyword to search
	 * @return Result
	 */
	@Override
	public Result search(String text) throws IOException {
		result = new Result();
		System.out.println("\tBing Search Engine: ");
		Document document = Jsoup.connect("https://www.bing.com/search?q=" + text).timeout(10000).userAgent(USER_AGENT)
				.get();
		Element el = document.getElementsByClass("b_algo").first();
		String url = el.getElementsByTag("a").first().text();
		String title = el.getElementsByTag("a").first().attr("href");

		result.setTitle(url);
		result.setURL(title);
		return result;
	}

}
