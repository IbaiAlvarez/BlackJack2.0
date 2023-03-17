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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BlackJack_App extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	Methods methods = new Methods();
	Player player = new Player();
	Dealer dealer = new Dealer();
	private JTextField textField_bet;
	int bet=0;
	String card = "";
	String[][] deck = new String[0][0];

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
		
		textField_name = new JTextField();
		textField_name.setBounds(271, 351, 138, 26);
		inicio.add(textField_name);
		textField_name.setColumns(10);
		

		textField_bet = new JTextField();
		textField_bet.setColumns(10);
		textField_bet.setBounds(271, 262, 138, 26);
		inicio.add(textField_bet);
		textField_bet.setVisible(false);
		
		JButton btn_bet = new JButton("BET");
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
					
					System.out.println(player);
					System.out.println(dealer);
				}else {
					JOptionPane.showMessageDialog(null,"Invalid Bet!","Alerta", JOptionPane.INFORMATION_MESSAGE);						
				}
			}
		});
		btn_bet.setBounds(296, 228, 89, 23);
		inicio.add(btn_bet);
		btn_bet.setVisible(false);
		
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
					btn_bet.setVisible(true);
					lbl_money.setText("Money: "+player.getMoney()+"$");
				}else {
					JOptionPane.showMessageDialog(null,"Invalid Name!","Alerta", JOptionPane.INFORMATION_MESSAGE);					
				}
			}
		});
		btn_play.setBounds(296, 200, 89, 23);
		inicio.add(btn_play);
		
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
