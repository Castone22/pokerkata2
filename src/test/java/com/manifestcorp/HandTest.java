package com.manifestcorp;

import static com.manifestcorp.Card.ACE_OF_HEARTS;
import static com.manifestcorp.Card.EIGHT_OF_HEARTS;
import static com.manifestcorp.Card.EIGHT_OF_SPADES;
import static com.manifestcorp.Card.FIVE_OF_CLUBS;
import static com.manifestcorp.Card.FIVE_OF_DIAMONDS;
import static com.manifestcorp.Card.FIVE_OF_HEARTS;
import static com.manifestcorp.Card.FIVE_OF_SPADES;
import static com.manifestcorp.Card.FOUR_OF_DIAMONDS;
import static com.manifestcorp.Card.FOUR_OF_HEARTS;
import static com.manifestcorp.Card.JACK_OF_HEARTS;
import static com.manifestcorp.Card.KING_OF_HEARTS;
import static com.manifestcorp.Card.NINE_OF_DIAMONDS;
import static com.manifestcorp.Card.NINE_OF_HEARTS;
import static com.manifestcorp.Card.QUEEN_OF_CLUBS;
import static com.manifestcorp.Card.QUEEN_OF_HEARTS;
import static com.manifestcorp.Card.SEVEN_OF_CLUBS;
import static com.manifestcorp.Card.SEVEN_OF_HEARTS;
import static com.manifestcorp.Card.SEVEN_OF_SPADES;
import static com.manifestcorp.Card.SIX_OF_CLUBS;
import static com.manifestcorp.Card.SIX_OF_DIAMONDS;
import static com.manifestcorp.Card.SIX_OF_HEARTS;
import static com.manifestcorp.Card.SIX_OF_SPADES;
import static com.manifestcorp.Card.TEN_OF_HEARTS;
import static com.manifestcorp.Card.THREE_OF_DIAMONDS;
import static com.manifestcorp.Card.THREE_OF_HEARTS;
import static com.manifestcorp.Card.THREE_OF_SPADES;
import static com.manifestcorp.Card.TWO_OF_CLUBS;
import static com.manifestcorp.Card.TWO_OF_DIAMONDS;
import static com.manifestcorp.Card.TWO_OF_HEARTS;
import static com.manifestcorp.Card.TWO_OF_SPADES;
import static com.manifestcorp.Rank.FLUSH;
import static com.manifestcorp.Rank.FOUR_OF_A_KIND;
import static com.manifestcorp.Rank.FULL_HOUSE;
import static com.manifestcorp.Rank.HIGH;
import static com.manifestcorp.Rank.PAIR;
import static com.manifestcorp.Rank.STRAIGHT;
import static com.manifestcorp.Rank.STRAIGHT_FLUSH;
import static com.manifestcorp.Rank.THREE_OF_A_KIND;
import static com.manifestcorp.Rank.TWO_PAIRS;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HandTest {
Hand highHand, pairHand, flushHand, fourOfAKindHand, straightFlushHand, straightHand,
	 fullHouseHand, threeOfAKindHand, twoPairHand;

	@Before
	public void setUp() throws Exception {
		highHand = new Hand(KING_OF_HEARTS,THREE_OF_DIAMONDS,FIVE_OF_CLUBS,SIX_OF_SPADES,QUEEN_OF_CLUBS);
		pairHand = new Hand(THREE_OF_DIAMONDS,THREE_OF_SPADES,SIX_OF_HEARTS,SEVEN_OF_CLUBS,QUEEN_OF_HEARTS);
		twoPairHand = new Hand(SIX_OF_HEARTS, SIX_OF_DIAMONDS, EIGHT_OF_SPADES, EIGHT_OF_HEARTS, NINE_OF_DIAMONDS);
		threeOfAKindHand = new Hand(FIVE_OF_HEARTS, FIVE_OF_DIAMONDS, FIVE_OF_SPADES, SIX_OF_HEARTS, TWO_OF_SPADES);
		fourOfAKindHand = new Hand(TWO_OF_HEARTS,TWO_OF_DIAMONDS,THREE_OF_HEARTS,TWO_OF_CLUBS,TWO_OF_SPADES);
		flushHand = new Hand(ACE_OF_HEARTS, NINE_OF_HEARTS, QUEEN_OF_HEARTS, TEN_OF_HEARTS, JACK_OF_HEARTS);
		straightHand = new Hand(TWO_OF_CLUBS, THREE_OF_SPADES, FOUR_OF_HEARTS, SIX_OF_CLUBS, FIVE_OF_CLUBS);
		fullHouseHand = new Hand(SEVEN_OF_HEARTS, SEVEN_OF_CLUBS, EIGHT_OF_SPADES, EIGHT_OF_HEARTS, SEVEN_OF_SPADES);
		straightFlushHand = new Hand(TWO_OF_DIAMONDS,FOUR_OF_DIAMONDS,THREE_OF_DIAMONDS, SIX_OF_DIAMONDS, FIVE_OF_DIAMONDS);
		
	}

	@After  
	public void tearDown() throws Exception {
		highHand = null;
		pairHand = null;
		twoPairHand = null;
		threeOfAKindHand = null;
		fourOfAKindHand = null;
		flushHand = null;
		straightFlushHand = null;
		fullHouseHand = null;
		straightFlushHand = null;
	}

	@Test
	public void testReturnCard() {
		assertEquals(FIVE_OF_CLUBS,highHand.getCard(1));
	}
	
	@Test
	public void testSortHand(){
		assertEquals(THREE_OF_DIAMONDS,highHand.getCard(0));
		assertEquals(FIVE_OF_CLUBS,highHand.getCard(1));
		assertEquals(SIX_OF_SPADES,highHand.getCard(2));
		assertEquals(QUEEN_OF_CLUBS,highHand.getCard(3));
		assertEquals(KING_OF_HEARTS,highHand.getCard(4));
	}
	
	@Test
	public void testScoreHand(){
		assertEquals(29,highHand.getScore());
	}
	
	@Test
	public void testHighRanking(){
		assertEquals(HIGH, highHand.getRank());
	}
	
	@Test
	public void testPairRanking(){
		assertEquals(PAIR, pairHand.getRank());
	}
	
	@Test
	public void testTwoPairsRanking(){
		assertEquals(TWO_PAIRS, twoPairHand.getRank());
	}
	
	@Test
	public void testTheeOfAKindRanking(){
		assertEquals(THREE_OF_A_KIND, threeOfAKindHand.getRank());
	}
	
	@Test
	public void testFourOfAKindRanking(){
		assertEquals(FOUR_OF_A_KIND, fourOfAKindHand.getRank());
	}
	
	@Test
	public void testFullHouseRanking(){
		assertEquals(FULL_HOUSE, fullHouseHand.getRank());
	}
	
	@Test
	public void testFlushRanking(){
		assertEquals(FLUSH, flushHand.getRank());
	}
	
	@Test
	public void testStraightRanking(){
		assertEquals(STRAIGHT, straightHand.getRank());
	}
	
	@Test
	public void testStraightFlushRanking(){
		assertEquals(STRAIGHT_FLUSH, straightFlushHand.getRank());
	}
	

	@Test
	public void testUniqueFaces(){
		assertEquals(5, highHand.getNumUniqueFaces());
		assertEquals(2, fourOfAKindHand.getNumUniqueFaces());
	}
	

}