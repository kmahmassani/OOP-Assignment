package immutableRankingList;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ImmutableRankingListTests {

	@Test
	public void testIncrementDownloadsCount() {
		ImmutableRankingList<App> list = new ImmutableRankingList<App>();
		
		App testApp = new App("Whatsapp","Social Media");
		
		list.incrementDownloadsCount(testApp);
		
		assertEquals(1, list.getDownloadsCount(testApp));
		
		list.incrementDownloadsCount(testApp);
		
		assertEquals(list.getDownloadsCount(testApp), 2);
	}
	
	@Test
	public void testAlphabeticalRetrieval() {
		ImmutableRankingList<App> list = new ImmutableRankingList<App>();
		
		App alfaApp = new App("Alfa", "");
		App bravoApp = new App("Bravo", "");
		App charlieApp = new App("Charlie", "");
		App deltaApp = new App("Delta", "");
		
		list.incrementDownloadsCount(bravoApp);
		list.incrementDownloadsCount(alfaApp);
		list.incrementDownloadsCount(deltaApp);
		list.incrementDownloadsCount(charlieApp);
		
		Iterator<App> it = list.iterator();
		
		assertEquals(alfaApp.title, it.next().title);
		assertEquals(bravoApp.title, it.next().title);
		assertEquals(charlieApp.title, it.next().title);
		assertEquals(deltaApp.title, it.next().title);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNonExistantApp() {
		ImmutableRankingList<App> list = new ImmutableRankingList<App>();
		
		App testApp = new App("Whatsapp","Social Media");
		
		list.getDownloadsCount(testApp);
	}
}
