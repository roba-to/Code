import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**	Ex3Tests.java
 * 	Public tests for Exercise 3, Worksheet 4 for MSc Software Workshop.
 * 	Tests functionality of simple web crawler. Much work needed to make this
 * 	fully functional. Doesn't handle duplicates or URLs that don't start
 * 	with <a href="
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-14
 *	@version	2016-11-14
 */

public class Ex3Tests {
	private String url;

	@Test
	public void Ex3Test1() {
		url = "http://www.cs.bham.ac.uk/~axk/";
		
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("http://www.cs.bham.ac.uk/~axk/timetable.html"));
		
		assertEquals("Failure in Ex3Test1, expected String = ", 
				expected, 
				WebCrawler.collectUrls(url));
	}
	
	@Test
	public void Ex3Test2() {
		url = "http://html.com/";
	
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("http://html.com/",
																		"http://html.com/",
																		"http://html.com/cheat-sheet/",
																		"http://html.com/document/",
																		"http://html.com/semantic-markup/",
																		"http://html.com/css/",
																		"http://html.com/anchors-links/",
																		"http://html.com/fonts/",
																		"http://html.com/images/",
																		"http://html.com/lists/",
																		"http://html.com/forms/",
																		"http://html.com/tables/",
																		"http://html.com/javascript/",
																		"http://html.com/applets/",
																		"http://html.com/tags/comment-tag/",
																		"http://html.com/frames/",
																		"http://html.com/paragraphs/",
																		"http://html.com/media/",
																		"http://html.com/character-codes/",
																		"http://html.com/invalid-html/",
																		"http://twitter.com/share",
																		"http://html.com/attributes/form-method/",
																		"http://html.com/document/",
																		"http://html.com/attributes/a-target/#comments",
																		"http://html.com/attributes/link-href/#comments",
																		"http://html.com/attributes/img-src/#comments",
																		"http://html.com/tags/marquee/#comments",
																		"http://html.com/attributes/img-align/#comments",
																		"http://html.com/privacy/",
																		"http://html.com/feed/rss/"));	
		
		assertEquals("Failure in Ex3Test2, expected String = ", 
				expected, 
				WebCrawler.collectUrls(url));
	}
	
	@Test
	public void Ex3Test3() {
		url = "http://www.e-try.com/black.htm"; //blank page!
		
		ArrayList<String> expected = new ArrayList<String>(); //no URLs expected
		
		assertEquals("Failure in Ex3Test3, expected String = ", 
				expected, 
				WebCrawler.collectUrls(url));
	}
	
	@Test
	public void Ex3Test4() {
		url = "http://html.net/about/";
		
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("http://twitter.com/share?count=horizontal&amp;",
																	"http://www.cohnjacobsen.dk/?lang=en",
																	"http://www.bitma.com",
																	"http://www.output.dk/?lang=en",
																	"http://www.maujor.com/",
																	"/forums/memberlist.php"));
		
		assertEquals("Failure in Ex3Test4, expected String = ", expected, WebCrawler.collectUrls(url));
	}

}
