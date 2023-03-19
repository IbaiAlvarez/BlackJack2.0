package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Controler.Methods;
import Model.Player;

class PlayerTest {

	@Test
	void BlackJackTets() {
		Methods methods = new Methods();
		Player player = new Player(0,0,new String[0], false, false,"",1000);
		

		player.setCards("J");
		player.setCardscount(player.getCardscount()+1);
		player.setCards("A");
		player.setCardscount(player.getCardscount()+1);
		
		player.setBlackJack(methods.CheckBlackJack(player));
		System.out.println(player.toString());
		assertTrue(player.getBlackJack());
		
	}

}
