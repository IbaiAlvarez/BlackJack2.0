package Model;

public class Player extends Person {
	
	private String name;
	private int money;
	
	public Player(int cardsvalue, int cardscount, String[] cards, boolean ace, boolean blackjack,String name, int money) {
		super(cardsvalue,cardscount,cards,ace,blackjack);
		this.name=name;
		this.money=money;
	}

	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	//Getters
	public String getName() {
		return this.name;
	}
	public int getMoney() {
		return this.money;
	}

	@Override
	public String toString() {
		String player = super.toString() + "Player [name=" + name + ", money=" + money + "]";
		return player;
	}

	
	
}
