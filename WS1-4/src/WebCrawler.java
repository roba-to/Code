import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/** WebCrawler.java
 * 	WebCrawler is a class for Exercise 3 of Worksheet 4 for MSc Software Workshop.
 * 	It is a simple web crawler which starts with a particular web page and then collects
 * 	web pages which can be reached in a single step from this starting page.
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-07
 *	@version	2016-11-07
 */
public class WebCrawler {
	
	/**	extractUrls is a method which takes a String containing one or more URLs 
	 * and extracts all URLs from that String. 
	 * 	If no URLs are present then an empty ArrayList is returned.
	 * 
	 *	@param readString 	The line of text (String) that you wish to extract URLs from
	 *	@return				All URLs contained in the String as an ArrayList<String> 
	 */
	public static ArrayList<String> extractUrls(String readString) {
		ArrayList<String> stringArray = new ArrayList<String>();
		//only executes if given String actually contains any URLs
		if (readString.contains("<a href=\"")) { 
//			//split String at each instance of <a href=" until following "
			String regex = " |.*<a href=\"|\".*";
			for (String s : readString.split(regex)) {
				//looks for URLs but ignores any <a name="
				if (s.contains("http") | s.contains(".php")) {
					stringArray.add(s);
				}
			}
		}
		return stringArray;
	}
	
	/**	collectUrls is a method which crawls through a single web page and finds
	 * 	all of the URLs on that page which can be reached in a single step.
	 * 
	 *	@param urlString	The URL of the page that you wish to crawl for URLs
	 *	@return				Returns an ArrayList<String> containing all URLs found the page corresponding to urlString
	 */
	public static ArrayList<String> collectUrls(String urlString) {
		ArrayList<String> urlList = new ArrayList<String>();
		String readString;
		try {
			URL url = new URL(urlString);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			while ((readString = in.readLine()) != null) { 
				for (String elements : extractUrls(readString)) {
					urlList.add(elements);
				}
			}
		}
		
		catch (IOException e) {
			System.out.println("Can't access URL: " + urlString);
		}
		return urlList;
	}//end method collectUrls
	
	/** A method for printing out all Urls collected via the collectUrls method to the console.
	 * 
	 *	@param url the url you wish to test collectUrls method on
	 */
	public static void trialRun(String url) {
		System.out.println("Testing: " + url);
		for (String s : collectUrls(url)) {
			System.out.println(s);
		}
	}
	
	
	public static void main(String[] args) {
//		String testUrl = "http://cs.bham.ac.uk/~mmk/teaching/java/test.html";
//		String manfedUrl = "http://www.cs.bham.ac.uk/~mmk/teaching.php";
//		String htmlUrl = "http://html.net/about/";
		
//		trialRun(htmlUrl);
				
		
	}//end main method
	
}//end class WebCrawler
