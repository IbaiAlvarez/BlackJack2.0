package Model;

import java.util.Arrays;

public abstract class Person {
	private int cardsvalue;
	private int cardscount;
	private String[] cards;
	private boolean ace;
	private boolean blackjack;
	
	public Person(int cardsvalue, int cardscount, String[] cards, boolean ace, boolean blackjack) {
		super();
		this.cardsvalue=cardsvalue;
		this.cardscount=cardscount;
		this.cards= cards;
		this.ace = ace;
		this.blackjack= blackjack;
	}		
	

	//Setters
	public void setCardscount(int cardscount) {
		this.cardscount = cardscount;
	}
	public void setCards(String[] cards) {
		this.cards = cards;
	}
	public void setBlackJack(boolean blackJack) {
		blackjack = blackJack;
	}
	public void setCardsValue(String card) {
		int value = this.cardsvalue;
			if(card.equals("K") || card.equals("Q") || card.equals("J")) {
				value+=10;
			}else if(card.equals("A") && (value+11)<=21) {
				value+=11;
				setAce(true);
			}else if(card.equals("A") && (value+11)>21) {
				value+=1;
			}else {
				value+= Integer.valueOf(card);
			}
			if(value>21 && this.ace) {
				value-=10;
				setAce(false);
			}			
		
		this.cardsvalue = value;
	}
	public void setCards(String card) {
		String[] holder = new String[this.cards.length+1];
		for(int i=0;i<this.cards.length;i++) {
			holder[i]=this.cards[i];
		}
		holder[this.cards.length]=card;
		setCardsValue(card);
		this.cards = holder;
	}
	public void setAce(boolean ace) {
		this.ace=ace;
	}

	//Getters
	public int getCardscount() {
		return cardscount;
	}
	public String[] getCards() {
		return cards;
	}
	public boolean isBlackJack() {
		return blackjack;
	}
	public int getCardsValue() {
		return this.cardsvalue;
	}
	public boolean getAce() {
		return this.ace;
	}
	public boolean getBlackJack() {
		return this.blackjack;
	}


	@Override
	public String toString() {
		return "Person [cardsvalue=" + cardsvalue + ", cardscount=" + cardscount + ", cards=" + Arrays.toString(cards)
				+ ", ace=" + ace + ", blackjack=" + blackjack + "]";
	}	
	
}
