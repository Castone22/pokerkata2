package com.manifestcorp;
import static org.junit.Assert.*;
import static com.manifestcorp.Suit.*;
import static com.manifestcorp.Face.*;
import static com.manifestcorp.Card.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSuit() {
		assertEquals(HEARTS, KING_OF_HEARTS.getSuit());
	}
	
	@Test
	public void testGetFace() {
		assertEquals(KING, KING_OF_HEARTS.getFace());
	}
	
	

}
