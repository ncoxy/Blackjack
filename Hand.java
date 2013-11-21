import java.awt.*;


public class Hand {

	private Card[] maxCards;
	private int amountOfCards = 0;

	public Hand(){
		int total = 0;
		this.maxCards = new Card[11];
	}
	public void addACard(Card newCard){
		maxCards[amountOfCards] = newCard;
		amountOfCards++;
	}

	public void drawPlayer(Graphics g){
		int xOffset = 25;
		for (int i=0; i<amountOfCards; i++) {
			maxCards[i].draw(g, new Rectangle(xOffset, 50, 200, 300));
			xOffset += 50;
		}
		g.drawString( "Player Total:" + this.getValue(), 40, 370);
	}

	public void drawDealerFirst(Graphics g){
		int xOffset = 25;
		for (int i = 0; i<amountOfCards; i++) {
			if (i == 0) {
				maxCards[i].drawbackOfCard(g, new Rectangle(xOffset, 500, 200, 300));
			}else{
				maxCards[i].draw(g, new Rectangle(xOffset, 500, 200, 300));
			}
			xOffset += 50;
			
		}
		g.drawString( "Dealer Total:" + this.getValue(), 40, 820);
	}
	public void drawDealer(Graphics g){
		int xOffset = 25;
		for (int i = 0; i<amountOfCards; i++) {
			maxCards[i].draw(g, new Rectangle(xOffset, 500, 200, 300));
				xOffset += 50;
		}
		g.drawString( "Dealer Total:" + this.getValue(), 40, 820);
	}
	public int getValue() {
		int total = 0;
		for (int i = 0; i<amountOfCards; i++) {
			total += maxCards[i].getValue2();
		}
		if (total >21) {
			total = 0;
			for (int i = 0; i<amountOfCards; i++) {
				total += maxCards[i].getValue();
			}
		}
		return total;
	}
	

}