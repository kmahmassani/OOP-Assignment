package mutableRankingList;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class MutableRankingListTests {

	@Test
	public void testIncrementDownloadsCount() {
		MutableRankingList<App> list = new MutableRankingList<App>();
		
		App testApp = new App("Whatsapp","Social Media");
		
		list.incrementDownloadsCount(testApp);
		
		assertEquals(1, list.getDownloadsCount(testApp));
		
		list.incrementDownloadsCount(testApp);
		
		assertEquals(list.getDownloadsCount(testApp), 2);
	}
	
	@Test
	public void testAlphabeticalRetrieval() {
		MutableRankingList<App> list = new MutableRankingList<App>();
		
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
		MutableRankingList<App> list = new MutableRankingList<App>();
		
		App testApp = new App("Whatsapp","Social Media");
		
		list.getDownloadsCount(testApp);
	}
}
