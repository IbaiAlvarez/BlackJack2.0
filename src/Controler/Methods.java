package Controler;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Model.Player;

public class Methods {
	
	public boolean CheckBet(Player player, String bet) {
		boolean valid = false;
		int bet_int=0;

		try {
			bet_int = Integer.parseInt(bet);
			if(bet_int<=player.getMoney()) {
				valid=true;
			}
		}catch(Exception e) {
		}
		
		return valid;
	}
	
	public String[][] ShuffleDeck(){
		
		String [][] deck = {{"A","2","3","4","5","6","7","8","9","10","J","Q","K"},{"4","4","4","4","4","4","4","4","4","4","4","4","4"}};
		
		return deck;
	}
	
	public String DealCard(String[][] deck) {
		int random = 0;
		
		do{
			random=ThreadLocalRandom.current().nextInt(0, 12 + 1);
		}while(Integer.parseInt(deck[1][random])==0);		
		
		return deck[0][random];
	}
	
	public String[][] RestCard(String[][] deck, String card){
		boolean deleted = false;
		for(int i=0;i<deck.length;i++) {
			if(deck[i].equals(card)) {
				int cant = Integer.valueOf(deck[1][i])-1;
				deck[1][i] = String.valueOf(cant);
				deleted = true;
			}
		}		
		return deck;
	}
	
	public boolean CheckBlackJack(Player player) {
		boolean blackjack= false;
		if(player.getCardscount()==2 && player.getCardsValue()==21) {
			blackjack = true;
		}
		return blackjack;
	}
}
