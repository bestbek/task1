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
public class SearchEngineYahooImpl implements SearchEngine {
	private Result result;
	/**
	 * 
	 * @param String keyword to search
	 * @return Result
	 */
	@Override
	public Result search(String text) throws IOException {
		result = new Result();
		System.out.println("\tYahoo Search Engine: ");	
		Document document = Jsoup.connect("https://search.yahoo.com/search?q=" + text).timeout(10000)
				.userAgent(USER_AGENT).get();
		Element idWeb = document.getElementById("web");
		Element classSearchCenterMiddle = idWeb.getElementsByClass("searchCenterMiddle").first();
		Element finalElement = classSearchCenterMiddle.getElementsByClass("first").first();
		
		result.setTitle(finalElement.select("a[href]").first().text());
		result.setURL(finalElement.select("a[href]").first().attr("href"));
		return result;
	}
}