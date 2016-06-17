package com.manifestcorp;

public class FiveCardPokerGame implements Game {
	private Hand black;
	private Hand white;
	private String winner;
	
	public FiveCardPokerGame(Hand black, Hand white) {
		this.black = black;
		this.white = white;
		this.winner = scoreGame();
		
	}
	
	public String getWinner(){
		return winner;
	}
	
	private boolean playGame(){
		return true;
	}
	
	private String scoreGame(){
		return playGame() ? "black" : "white";
	}

}
