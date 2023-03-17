package Model;

import java.util.Arrays;

public class Player {
	
	private String name;
	private int cardsvalue;
	private int cardscount;
	private String[] cards;
	private boolean ace;
	private boolean BlackJack;
	private int money;
	
	public Player() {
		this.name="";
		this.cardsvalue=0;
		this.cardscount=0;
		this.cards= new String[0];
		this.ace = false;
		this.BlackJack=false;
		this.money=1000;
	}

	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setCardsValue(String card) {
		int value = this.cardsvalue;
			if(cards.equals("K") || card.equals("Q") || card.equals("J")) {
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
	public void setCardscount(int cardscount) {		
		this.cardscount = cardscount;
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
	public void setBlackJack(boolean BlackJack) {
		this.BlackJack = BlackJack;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	//Getters
	public String getName() {
		return this.name;
	}
	public int getCardsValue() {
		return this.cardsvalue;
	}
	public int getCardscount() {
		return this.cardscount;
	}
	public String[] getCards() {
		return this.cards;
	}
	public boolean getAce() {
		return this.ace;
	}
	public boolean getBlackJack() {
		return this.BlackJack;
	}
	public int getMoney() {
		return this.money;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", cardsvalue=" + cardsvalue + ", cardscount=" + cardscount + ", cards="
				+ Arrays.toString(cards) + ", ace=" + ace + ", BlackJack=" + BlackJack + ", money=" + money + "]";
	}

	
	
}
