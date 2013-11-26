import java.awt.*;
import java.applet.*;

import javax.swing.*;
import java.awt.event.*;


public class BlackjackApplet extends Applet implements ActionListener{
	private JButton hit, stay, reset, down, bet;
	private JLabel bust;
	private int value = 0;
	private JLabel win, lost, walletLabel, potLabel, score;
	private String answer;

	private Deck table;
	private Hand player;
	private Hand dealer;
	private int totalCards;
	private int wallet, pot, dealerWallet, playerBet, playerTotal, dealerTotal;
	private int playerWin = 0;
	private int dealerWin = 0;
	private boolean front = false;
	private JLabel playerWin, dealerWin;
	
	public void startinit() {
		score.setText("                                                    Currently Playing");


		playerBet = 0;
		setPot(0);
		int total = 0;
		table = newDeck();
		player = new Hand();
		dealer = new Hand();
		table.shuffle();
		player.addACard(table.deal);
		dealer.addACard(table.deal);
		player.addACard(table.deal);
		dealer.addACard(table.deal);
		playerTotal = player.getValue();
		dealerTotal = dealer.getValue();
	}

	public void init() {
		
		setWallet(1000);
		setPot(0);		

		int total = 0;
		table = new Deck();
		player = new Hand();
		dealer = new Hand();
		table.shuffle();
		player.addACard(table.deal());
		dealer.addACard(table.deal());
		player.addACard(table.deal());
		dealer.addACard(table.deal());

		walletLabel = new JLabel("You have $" + wallet + "dollars.");
		walletLabel.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(walletLabel);

		potLabel = new JLabel("There is $" + getPot() + "in the pot.");
		potLabel.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(potLabel);

		
		


		String title = "Hit";

		hit = new JButton(title);
		hit.setActionCommand(title);
		hit.addActionListener(this);
		this.add(hit);

		title = "Stay";
		stay = new JButton(title);
		stay.setActionCommand(title);
		stay.addActionListener(this);
		this.add(stay);

		title = "Bet $10";
		bet = new JButton(title);
		bet.setActionCommand(title);
		bet.addActionListener(this);
		this.add(bet);

		title = "Double down";
		down = new JButton(title);
		down.setActionCommand(title);
		down.addActionListener(this);
		this.add(down);

		title = "New Game";
		reset = new JButton(title);
		reset.setActionCommand(title);
		reset.addActionListener(this);
		this.add(reset);

		

		score = new JLabel("Currently playing...");
		score.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(score);

		playerWin = new JLabel("Player Wins: " + playerWin);
		playerWin.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(playerWin);

		dealerWin = new JLabel("Dealer Wins: " + dealerWin);
		dealerWin.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(dealerWin);


	
	}
	public int getWallet(){
		return this.wallet;
	}
	public void setWallet(int wallet){
		this.wallet = wallet;
	}
	public int getPot(){
		return this.pot;
	}
	public void setPot(int pot){
		this.pot = pot;
	}

	public Deck getTable(){
		return this.table;
	}
	public Hand getPlayer(){
		return this.player;
	}
	public void setTable(Deck table){
		this.table = table;
	}
	public void setPlayer(Hand player){
		this.player = player;
	}
	public void actionPerformed(ActionEvent ae){
		int playerTotal = player.getValue();
		int dealerTotal = dealer.getValue();

		if ("Hit".equals(ae.getActionCommand())) {

			if (playerTotal < 21) {
				player.addACard(table.deal());
				repaint();
			}
			playerTotal = player.getValue();	
			if (playerTotal > 21) {
					setWallet(getWallet() - getPot());
					score.setText("You busted! Dealer wins.");
					dealerWin++;
			}else if(playerTotal == 21) {
			 
				setWallet(getWallet() + getPot());
				score.setText("21!!!");
				playerWin++;
			}else if ("Stay".equals(ae.getActionCommand())) {
				int dealertotal = dealer.getValue();
				front = true;

				while(dealertotal < 16){
				dealer.addACard(table.deal());
				dealertotal = dealer.getValue();
				repaint();

				if (playerTotal > 21) {
					setWallet(getWallet() - getPot());
					score.setText("You Busted! Dealer Wins.");
					dealerWin++;
			}else if (playerTotal == 21) {
				setWallet(getWallet() + getPot());
				score.setText("21!!!");
				playerWin++;
			}else if (playerTotal > dealerTotal && dealerTotal < 21 && playerTotal <= 21) {
				setWallet(getWallet() + getPot());
				score.setText("You win!!!");
				playerWin++;
			}else if (dealerTotal > playerTotal && dealerTotal <= 21 && playerTotal < 21) {
				setWallet(getWallet() - getPot());
				score.setText("You lost");
				dealerWin++;
			}else if (dealerTotal == playerTotal) {
				setWallet(getWallet());
				score.setText("Draw");
			}
			}if (dealerTotal <= 21 && dealerTotal >= 16) {
				dealerTotal = dealer.getValue();
				repaint();

				if (playerTotal > 21) {
					setWallet(getWallet() - getPot());
					score.setText("You busted! Dealer Wins.");
					dealerWin++;
			}else if (playerTotal == 21) {
				setWallet(getWallet() + getPot());
				score.setText("21!!!");
				playerWin++;
			}else if (playerTotal > dealerTotal && dealerTotal < 21 && playerTotal <= 21) {
				setWallet(getWallet() + getPot());
				score.setText("You win!");
				playerWin++;
			}else if(dealerTotal > playerTotal && dealerTotal <= 21 && playerTotal < 21) {
				setWallet(getWallet() - getPot());
				score.setText("You lost.");
				dealerWin++;
			}else if (dealerTotal == playerTotal) {
				setWallet(getWallet());
				score.setText("Draw");
			}
			}
		
			
			

		
		}else if ("New Game".equals(ae.getActionCommand())) {
			front = false;
			setWallet(getWallet());
			walletLabel.setText("You have $" + getWallet() + " dollars.");
			playerWin.setText("Player Wins: " + playerWin);
			dealerWin.setText("Dealer Wins: " + dealerWin);
			startinit();
			potLabel.setText("There is $" + getPot() + " in the pot.");
			repaint();
		}
		if ("Double Down".equals(ae.getActionCommand())){
			setWallet(getWallet() - playerBet);
			walletLabel.setText("You have $" + getWallet() + "dollars.");
			setPot(getPot() + playerBet);
			potLabel.setText("There is $" + getPot() + " in the pot.");

			player.addACard(table.deal());
			repaint();

			playerTotal = player.getValue();
			if (playerTotal > 21) {
				setWallet(getWallet() - getPot());
				score.setText("You busted! Dealer wins");

			}else if (playerTotal == 21) {
				setWallet(getWallet() + getPot());
				score.setText("21!!!");
			}else if (playerTotal > dealerTotal && dealerTotal < 21 && playerTotal <= 21) {
				setWallet(getWallet() + getPot());
				score.setText("You win!!!");
			}else if (dealerTotal > playerTotal && dealerTotal <= 21 && playerTotal < 21) {
				setWallet(getWallet() - getPot());
				score.setText("You lost.");
			}else if (dealerTotal == playerTotal) {
				setWallet(getWallet());
				score.setText("Draw");
			}
			repaint();
		}
		 if ("Bet $10".equals(ae.getActionCommand())) {
			setWallet(getWallet() - 10);
			walletLabel.setText("You have $" + getWallet() + "dollars.");
			setPot(getPot() + 20);
			potLabel.setText("There is $" + getPot() + " in the pot.");
			playerBet += 10;
			repaint();
			
		}

		

	}

	public void paint(Graphics g) {
		super.paint(g);
		player.drawPlayer(g);
		if(front == true) {
			dealer.drawDealer(g);
		}else {
			dealer.drawDealerFirst(g);
		}

		dealer.drawDealerFirst(g);
		g.drawString(answer, 200, 400);
	}
	

}