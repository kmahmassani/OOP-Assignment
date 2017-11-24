package mutableRankingList;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void testEqualsObject() {
		App app = new App("Whatsapp","Social Media");
		
		assertEquals(true, app.equals(app));
		
		assertEquals(false, app.equals(null));
		
		App app2 = new App("Whatsapp","Social Media");
		
		assertEquals(true, app.equals(app2));
		
		assertEquals(true, app2.equals(app));
		
		App app3 = new App("FaceBook","Social Media");
		assertEquals(false, app.equals(app3));
		
		App app4 = new App("FaceBook","Wastes of Time");
		assertEquals(false, app3.equals(app4));
	}

}
