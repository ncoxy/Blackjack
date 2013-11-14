import java.awt.Graphics;


public class Hand {

	private int amountOfCards;
	private int totalValue = 0;
	Card[] hand = new Card[11];
	private Deck cards;

	public Hand(Deck cards, Graphics g, int xOffset){
		Card[] hand = new Card[11];
		this.cards = cards;	
		
		for (int i=0; i<hand.length; i++) {
			if (totalValue < 21) {
				dealPlayer(g, 1);

			}
			totalValue += cards.getValue();
			xOffset += 25;
		}
		this.amountOfCards = 0;
	}

	public void dealPlayer(Graphics g, int number){
		cards.draw(g, 0, 50, 2);
		cards.draw(g, 0, 100, 3);
	}

	public void dealDealer(Graphics g, int number){
		cards.draw(g, 0, 200, 4);
	}

	public void draw(Graphics g){
		for (int i = 0; i<amountOfCards; i++) {
			this.hand[i].draw(g, new Rectangle(x, 50, 200, 300));
		}
	}

}