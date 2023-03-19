package BlackJack_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.Methods;
import Model.Dealer;
import Model.Player;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BlackJack_App extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	Methods methods = new Methods();
	Player player = new Player(0,0,new String[0], false, false,"",1000);
	Dealer dealer = new Dealer(0,0,new String[0], false, false);
	private JTextField textField_bet;
	int bet=0;
	int total_money = 0;
	String card = "";
	String[][] deck = new String[0][0];
	String[] cardsPlayer_array = new String[0];
	String[] cardsDealer_array = new String[0];
	String cardsPlayer = "Cards: ";
	String valuePlayer = "Value: ";
	String cardsDealer = "Cards: ";
	String valueDealer = "Value: ";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJack_App frame = new BlackJack_App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlackJack_App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel inicio = new JPanel();
		contentPane.add(inicio, "name_176543992180000");
		inicio.setLayout(null);
		
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setForeground(new Color(255, 255, 255));
		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_name.setBounds(307, 312, 65, 26);
		inicio.add(lbl_name);

		
		JLabel lbl_name_game = new JLabel("");
		lbl_name_game.setForeground(Color.WHITE);
		lbl_name_game.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_name_game.setBounds(317, 388, 102, 26);
		inicio.add(lbl_name_game);
		
		JLabel lbl_money = new JLabel("");
		lbl_money.setForeground(Color.WHITE);
		lbl_money.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_money.setBounds(10, 11, 197, 26);
		inicio.add(lbl_money);

		JLabel lbl_bet_game = new JLabel("");
		lbl_bet_game.setForeground(Color.WHITE);
		lbl_bet_game.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_bet_game.setBounds(10, 54, 156, 26);
		inicio.add(lbl_bet_game);
				
		JLabel CardsPlayer = new JLabel("");
		CardsPlayer.setForeground(Color.WHITE);
		CardsPlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		CardsPlayer.setBounds(258, 327, 287, 26);
		inicio.add(CardsPlayer);
		CardsPlayer.setVisible(false);

		JLabel ValuePlayer = new JLabel("");
		ValuePlayer.setForeground(Color.WHITE);
		ValuePlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		ValuePlayer.setBounds(296, 290, 107, 26);
		inicio.add(ValuePlayer);
		ValuePlayer.setVisible(false);

		JLabel CardsDealer = new JLabel("");
		CardsDealer.setForeground(Color.WHITE);
		CardsDealer.setFont(new Font("Tahoma", Font.BOLD, 20));
		CardsDealer.setBounds(263, 27, 287, 26);
		inicio.add(CardsDealer);
		
		JLabel ValueDealer = new JLabel("");
		ValueDealer.setForeground(Color.WHITE);
		ValueDealer.setFont(new Font("Tahoma", Font.BOLD, 20));
		ValueDealer.setBounds(258, 65, 107, 26);
		inicio.add(ValueDealer);
							
		textField_name = new JTextField();
		textField_name.setBounds(271, 351, 138, 26);
		inicio.add(textField_name);
		textField_name.setColumns(10);
		

		textField_bet = new JTextField();
		textField_bet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)){
					e.consume();
				}
			}
		});
		textField_bet.setColumns(10);
		textField_bet.setBounds(271, 262, 138, 26);
		inicio.add(textField_bet);
		textField_bet.setVisible(false);
		

		JButton btn_bet = new JButton("BET");

		JButton btn_play = new JButton("PLAY");
		btn_play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_name.getText()!=null && !textField_name.getText().equals("")) {
					player.setName(textField_name.getText());
					btn_play.setVisible(false);
					textField_name.setVisible(false);
					lbl_name.setVisible(false);
					lbl_name_game.setText(textField_name.getText());
					textField_bet.setVisible(true);
					lbl_money.setText("Money: "+player.getMoney()+"$");
					btn_bet.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null,"Invalid Name!","Alerta", JOptionPane.INFORMATION_MESSAGE);					
				}
			}
		});
		btn_play.setBounds(296, 200, 89, 23);
		inicio.add(btn_play);

		JButton btn_ask = new JButton("ASK");
		btn_ask.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				player.setCards(methods.DealCard(deck));
				CardsPlayer.setVisible(true);
				cardsPlayer_array = player.getCards(); 
				cardsPlayer = "Cards: ";
				for(int i =0;i<cardsPlayer_array.length;i++) {
					cardsPlayer += cardsPlayer_array[i]+" ,";
				}
				CardsPlayer.setText(String.valueOf(cardsPlayer));
				ValuePlayer.setText(valuePlayer +player.getCardsValue());
				if(player.getCardsValue()>=21) {
					btn_ask.setVisible(false);
				}
			}
		});
		btn_ask.setBounds(477, 293, 89, 23);
		inicio.add(btn_ask);
		btn_ask.setVisible(false);		

		JButton btn_stay = new JButton("STAY");
		btn_stay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while(dealer.getCardsValue()<17) {
					dealer.setCards(methods.DealCard(deck));			
				}
				//Dealer data
				cardsDealer_array = dealer.getCards(); 
				cardsDealer = "Cards: ";
				for(int i =0;i<cardsDealer_array.length;i++) {
					cardsDealer += cardsDealer_array[i]+", ";
				}
				CardsDealer.setText(String.valueOf(cardsDealer));
				ValueDealer.setVisible(true);
				ValueDealer.setText(valueDealer +dealer.getCardsValue());	
				
				if(methods.VerifyWin(player, dealer)==1 && player.getBlackJack()) {
					total_money = (int) (player.getMoney() + Math.round(bet*1.5));
					player.setMoney(total_money);
					JOptionPane.showMessageDialog(null,"You won "+Math.round(bet*1.5)+"$","Alerta", JOptionPane.INFORMATION_MESSAGE);
				}else if(methods.VerifyWin(player, dealer)==1) {
					player.setMoney(player.getMoney()+bet);
					JOptionPane.showMessageDialog(null,"You won "+bet+"$","Alerta", JOptionPane.INFORMATION_MESSAGE);
				}else if(methods.VerifyWin(player, dealer)==-1) {
					player.setMoney(player.getMoney()-bet);
					JOptionPane.showMessageDialog(null,"You lost "+bet+"$","Alerta", JOptionPane.INFORMATION_MESSAGE);
				}else if(methods.VerifyWin(player, dealer)==0) {
					JOptionPane.showMessageDialog(null,"Draw!","Alerta", JOptionPane.INFORMATION_MESSAGE);
				}
				lbl_money.setText("Money: "+player.getMoney()+"$");
				btn_stay.setVisible(false);
				btn_ask.setVisible(false);
				ValuePlayer.setVisible(false);
				CardsPlayer.setVisible(false);
				ValueDealer.setVisible(false);
				CardsDealer.setVisible(false);
				btn_bet.setVisible(true);
				textField_bet.setVisible(true);
				lbl_bet_game.setText("Bet: 0$");
				player.setCards(new String[0]);
				player.ResetCardsValue();
				dealer.setCards(new String[0]);
				dealer.ResetCardsValue();	
			}
		});
		btn_stay.setBounds(124, 293, 89, 23);
		inicio.add(btn_stay);
		btn_stay.setVisible(false);
		
		btn_bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(methods.CheckBet(player, textField_bet.getText())) {
					btn_bet.setVisible(false);
					textField_bet.setVisible(false);
					bet = Integer.parseInt(textField_bet.getText());
					lbl_bet_game.setText("Bet: "+bet+"$");
					deck = methods.ShuffleDeck();
					//Initial Deal
					card =methods.DealCard(deck);
					player.setCards(card);
					player.setCardscount(player.getCardscount()+1);
					deck = methods.RestCard(deck, card);
					
					card =methods.DealCard(deck);
					dealer.setCards(card);
					dealer.setCardscount(dealer.getCardscount()+1);
					deck = methods.RestCard(deck, card);
					
					card =methods.DealCard(deck);
					player.setCards(card);
					player.setCardscount(player.getCardscount()+1);
					deck = methods.RestCard(deck, card);

					card =methods.DealCard(deck);
					dealer.setCards(card);
					dealer.setCardscount(dealer.getCardscount()+1);
					deck = methods.RestCard(deck, card);
					
					player.setBlackJack(methods.CheckBlackJack(player));
					
					CardsPlayer.setVisible(true);
					cardsPlayer_array = player.getCards(); 
					cardsPlayer="Cards: ";
					for(int i =0;i<cardsPlayer_array.length;i++) {
						cardsPlayer += cardsPlayer_array[i]+" ,";
					}
					CardsPlayer.setText(String.valueOf(cardsPlayer));
					ValuePlayer.setVisible(true);
					ValuePlayer.setText(valuePlayer +player.getCardsValue());
					
					//Dealer data
					CardsDealer.setVisible(true);
					cardsDealer_array = dealer.getCards(); 
					cardsDealer="Cards: ";
					CardsDealer.setText(cardsDealer+cardsDealer_array[0]);
					ValueDealer.setVisible(true);
					ValueDealer.setText(valueDealer +Methods.GetCardValue(cardsDealer_array[0]));
					
					btn_ask.setVisible(true);
					btn_stay.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Invalid Bet!","Alerta", JOptionPane.INFORMATION_MESSAGE);						
				}
			}
		});
		btn_bet.setBounds(296, 228, 89, 23);
		inicio.add(btn_bet);
		btn_bet.setVisible(false);
		
		
		JLabel lbl_fondo = new JLabel("");
		lbl_fondo.setIcon(new ImageIcon("src\\resources\\crupier.jpg"));
		lbl_fondo.setBounds(0, 0, 708, 439);
		inicio.add(lbl_fondo);
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("src\\resources\\crupier.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image img_fondo = img.getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(img_fondo);
		lbl_fondo.setIcon(imageIcon);
						
		JPanel fin = new JPanel();
		fin.setLayout(null);
		contentPane.add(fin, "name_176721581162400");
		
		JLabel fin_txt = new JLabel("FIN DEL JUEGO");
		fin_txt.setFont(new Font("Tahoma", Font.PLAIN, 27));
		fin_txt.setBounds(254, 170, 231, 54);
		fin.add(fin_txt);
	}
}
