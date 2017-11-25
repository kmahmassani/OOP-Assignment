package immutableRankingList;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ImmutableRankingListTests {

	@Test
	public void testIncrementDownloadsCount() {
		
		App testApp = new App("Whatsapp","Social Media");
		
		ImmutableRankingList<App> list = new ImmutableRankingList<App>(testApp);
		
		assertEquals(1, list.getDownloadsCount(testApp));
		
		ImmutableRankingList<App> list2 = list.incrementDownloadsCount(testApp);
		
		assertEquals(2, list2.getDownloadsCount(testApp));
		assertEquals(1, list.getDownloadsCount(testApp));
	}
	
	@Test
	public void testAlphabeticalRetrieval() {				
		App alfaApp = new App("Alfa", "");
		App bravoApp = new App("Bravo", "");
		App charlieApp = new App("Charlie", "");
		App deltaApp = new App("Delta", "");
		
		ImmutableRankingList<App> list = new ImmutableRankingList<App>(bravoApp);
		list = list.incrementDownloadsCount(alfaApp);
		list = list.incrementDownloadsCount(deltaApp);
		list = list.incrementDownloadsCount(charlieApp);
		
		Iterator<App> it = list.iterator();
		
		assertEquals(alfaApp.title, it.next().title);
		assertEquals(bravoApp.title, it.next().title);
		assertEquals(charlieApp.title, it.next().title);
		assertEquals(deltaApp.title, it.next().title);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNonExistantApp() {
		App testApp = new App("Whatsapp","Social Media");
		
		ImmutableRankingList<App> list = new ImmutableRankingList<App>(testApp);
		
		list.getDownloadsCount(new App("xyz", "Alphabet"));
	}
	
	@Test
	public void testImmutabilityOfItem() {
				
		App testApp = new App("Whatsapp","Social Media");
		ImmutableRankingList<App> list = new ImmutableRankingList<App>(testApp);
		
		testApp.title.name = "test";
		
		Iterator<App> it = list.iterator();
		App listApp = it.next();
		
		assertEquals(false, listApp == testApp);
		assertEquals("Whatsapp", listApp.title.name);
	}
}
