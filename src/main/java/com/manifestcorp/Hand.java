package com.manifestcorp;

import static com.manifestcorp.Rank.FLUSH;
import static com.manifestcorp.Rank.FOUR_OF_A_KIND;
import static com.manifestcorp.Rank.FULL_HOUSE;
import static com.manifestcorp.Rank.HIGH;
import static com.manifestcorp.Rank.PAIR;
import static com.manifestcorp.Rank.STRAIGHT;
import static com.manifestcorp.Rank.STRAIGHT_FLUSH;
import static com.manifestcorp.Rank.THREE_OF_A_KIND;
import static com.manifestcorp.Rank.TWO_PAIRS;
import static com.manifestcorp.Card.ORDINAL_CARD_SORTER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

public class Hand {
	List<Card> cardList;
	private Set<Face> uniqueFaces;
	private Set<Suit> uniqueSuits;
	private Multiset<Face> faces = EnumMultiset.create(Face.class);
	Rank rank = HIGH;
	int score = 0;
	
	
	Comparator<Card> ordinalComp = new Comparator<Card>(){
		@Override
		public int compare(Card card1, Card card2) {	
			return card1.getFace().compareTo(card2.getFace());
		}
	};
	
	
	public Hand(){
		cardList = new ArrayList<Card>();
		initHand();
	}
	
	public Hand(Card card1, Card card2, Card card3, Card card4, Card card5){
		cardList = new ArrayList<Card>();
		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5); 
		initHand();
	}
	
	public Hand(ArrayList<Card> cardList){
		this.cardList = new ArrayList<Card>(cardList);	
		initHand();
	}


	public static List<Card> sort(List<Card> cardList){
		Collections.sort(cardList, ORDINAL_CARD_SORTER);
		return cardList;
	}
	
	public int getScore() {
		return score;
	}

	public Rank getRank() {
		return rank;
	}
	
	public Card getCard(int i){
		return cardList.get(i);
	}
	
	public List<Card> getCardList(){
		return cardList;
	}
	
	public int getNumUniqueFaces(){
		return uniqueFaces.size();
	}
	
	private void initHand(){
		cardList = sort(cardList);
		score(); 
		findUniqueFacesAndSuits();
		rank();
	}
	
	private void score(){
		for(Card c : cardList){
			score += c.getFace().ordinal();
		}
	}
	
	private void findUniqueFacesAndSuits(){
		uniqueFaces = EnumSet.noneOf(Face.class);
		uniqueSuits = EnumSet.noneOf(Suit.class);
		for(Card c : cardList){
			uniqueFaces.add(c.getFace());
			faces.add(c.getFace());
			uniqueSuits.add(c.getSuit());
		}
		faces = Multisets.copyHighestCountFirst(faces);
	}
	
	private void rank(){
		Face first = cardList.get(0).getFace();
		Face last = cardList.get(4).getFace();
		int numUniqueSuits = uniqueSuits.size();
		int numUniqueFaces = uniqueFaces.size();
		boolean straight, flush = numUniqueSuits == 1;
		if (numUniqueFaces < 5){
			if (numUniqueFaces == 3 ){
				rank = faces.count(first) == 2 ? TWO_PAIRS : THREE_OF_A_KIND;
			} else if (numUniqueFaces == 2) {
				rank = faces.count(first) == 3 ? FULL_HOUSE : FOUR_OF_A_KIND;
			} else {
				rank = PAIR;
			}
		} else {
			straight = last.ordinal() - first.ordinal() == 4;
			rank = straight ? (flush ? STRAIGHT_FLUSH : STRAIGHT) 
						    : (flush ? FLUSH : HIGH);
		}
	}
	

	
}
