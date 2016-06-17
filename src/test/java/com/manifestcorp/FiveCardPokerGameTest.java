package com.manifestcorp;


import static com.manifestcorp.Card.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FiveCardPokerGameTest {
	
	private Hand highHand;
	private Hand pairHand;
	private Hand threeOfAKindHand;
	private Hand fourOfAKindHand;
	private Hand flushHand;
	private Hand straightHand;
	private Hand fullHouseHand;
	private Hand straightFlushHand;
	private Hand winningHighHand;
	private Hand twoPairHand;
	private Hand royalFlushHand;
	private Hand winningFullHouseHand;
	private Hand winningStraightHand;
	private Hand winningFlushHand;
	private Hand winningFourOfAKindHand;
	private Hand winningThreeOfAKindHand;
	private Hand winningTwoPairHand;
	private Hand winningPairHand;
	private Game game;

	@Before
	public void setUp(){
		highHand = new Hand(KING_OF_HEARTS,THREE_OF_DIAMONDS,FIVE_OF_CLUBS,SIX_OF_SPADES,QUEEN_OF_CLUBS);
		pairHand = new Hand(THREE_OF_DIAMONDS,THREE_OF_SPADES,SIX_OF_HEARTS,SEVEN_OF_CLUBS,QUEEN_OF_HEARTS);
		twoPairHand = new Hand(SIX_OF_HEARTS, SIX_OF_DIAMONDS, EIGHT_OF_SPADES, EIGHT_OF_HEARTS, NINE_OF_DIAMONDS);
		threeOfAKindHand = new Hand(FIVE_OF_HEARTS, FIVE_OF_DIAMONDS, FIVE_OF_SPADES, SIX_OF_HEARTS, TWO_OF_SPADES);
		fourOfAKindHand = new Hand(TWO_OF_HEARTS,TWO_OF_DIAMONDS,THREE_OF_HEARTS,TWO_OF_CLUBS,TWO_OF_SPADES);
		flushHand = new Hand(ACE_OF_HEARTS, NINE_OF_HEARTS, QUEEN_OF_HEARTS, TEN_OF_HEARTS, JACK_OF_HEARTS);
		straightHand = new Hand(TWO_OF_CLUBS, THREE_OF_SPADES, FOUR_OF_HEARTS, SIX_OF_CLUBS, FIVE_OF_CLUBS);
		fullHouseHand = new Hand(SEVEN_OF_HEARTS, SEVEN_OF_CLUBS, EIGHT_OF_SPADES, EIGHT_OF_HEARTS, SEVEN_OF_SPADES);
		straightFlushHand = new Hand(TWO_OF_DIAMONDS,FOUR_OF_DIAMONDS,THREE_OF_DIAMONDS, SIX_OF_DIAMONDS, FIVE_OF_DIAMONDS);
		royalFlushHand = new Hand(TWO_OF_DIAMONDS,FOUR_OF_DIAMONDS,THREE_OF_DIAMONDS, SIX_OF_DIAMONDS, FIVE_OF_DIAMONDS);
		winningHighHand = new Hand(KING_OF_HEARTS,FOUR_OF_DIAMONDS,FIVE_OF_CLUBS,SIX_OF_SPADES,QUEEN_OF_CLUBS);
		winningPairHand = new Hand(THREE_OF_HEARTS,THREE_OF_CLUBS,KING_OF_HEARTS,ACE_OF_SPADES,NINE_OF_HEARTS);
		winningTwoPairHand = new Hand(SIX_OF_HEARTS, SIX_OF_DIAMONDS, EIGHT_OF_SPADES, EIGHT_OF_HEARTS, TEN_OF_DIAMONDS);
//		winningThreeOfAKindHand = new Hand();
//		winningFourOfAKindHand = new Hand();
//		winningFlushHand = new Hand();
//		winningStraightHand = new Hand();
//		winningFullHouseHand = new Hand();
	}
	
	@Test
	public void testHighLosesToAll() {
		game = new FiveCardPokerGame(highHand, pairHand);
		assertTrue(game.getWinner() == "white");
	}

}
