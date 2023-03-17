package Model;

import java.util.Arrays;

public class Dealer {
	
		private int cardsvalue;
		private int cardscount;
		private String[] cards;
		private boolean ace;
		private boolean BlackJack;
		
		public Dealer() {	
			this.cardsvalue=0;
			this.cardscount=0;
			this.cards= new String[0];
			this.ace = false;
			this.BlackJack=false;
		}		
		

		//Setters
		public void setCardscount(int cardscount) {
			this.cardscount = cardscount;
		}
		public void setCards(String[] cards) {
			this.cards = cards;
		}
		public void setBlackJack(boolean blackJack) {
			BlackJack = blackJack;
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
			return BlackJack;
		}
		public int getCardsValue() {
			return this.cardsvalue;
		}
		public boolean getAce() {
			return this.ace;
		}
		public boolean getBlackJack() {
			return this.BlackJack;
		}


		@Override
		public String toString() {
			return "Dealer [cardsvalue=" + cardsvalue + ", cardscount=" + cardscount + ", cards="
					+ Arrays.toString(cards) + ", ace=" + ace + ", BlackJack=" + BlackJack + "]";
		}


		
		
}
