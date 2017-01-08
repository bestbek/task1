package kg.zensoft.main;

import java.io.IOException;

import java.util.Scanner;
import static java.lang.System.*;
import kg.zensoft.model.Result;
import kg.zensoft.search.SearchEngine;
import kg.zensoft.search.impl.SearchEngineBingImpl;
import kg.zensoft.search.impl.SearchEngineGoogleImpl;
import kg.zensoft.search.impl.SearchEngineYahooImpl;

/**
 * 
 * @author Mickey
 *
 */
public class ZenRun {
	/*
	 * Tested on MacBook Pro (Retina, 13-inch, Early 2015) OS X El Capitan
	 * 10.11.6 Firefox 49.0.2 tested for keywords eminem, hello
	 */
	public static void main(String[] args) throws IOException {

		SearchEngine engineGoogle = new SearchEngineGoogleImpl();
		SearchEngine engineBing = new SearchEngineBingImpl();
		SearchEngine engineYahoo = new SearchEngineYahooImpl();
		String text = new Scanner(System.in).nextLine();

		Result googleResult = engineGoogle.search(text);
		out.println("\tWhat google says:\n" + googleResult.getTitle() + "\n" + googleResult.getURL() + "\n");

		Result bingResult = engineBing.search(text);
		out.println("\tWhat bing says:\n" + bingResult.getTitle() + "\n" + bingResult.getURL() + "\n");

		Result yahooResult = engineYahoo.search(text);
		out.println("\tWhat yahoo says:\n" + yahooResult.getTitle() + "\n" + yahooResult.getURL() + "\n");
	}

}
