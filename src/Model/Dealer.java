package Model;


public class Dealer extends Person{
			
		public Dealer(int cardsvalue, int cardscount, String[] cards, boolean ace, boolean blackjack) {
			super(cardsvalue,cardscount,cards,ace,blackjack);
		}
		
		@Override
		public String toString() {
			return super.toString();
		}	
}
