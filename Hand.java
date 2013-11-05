public class Hand {

	Card[] hand = new Card[11];

	private Deck cards;

	public Hand(){
		

		for (int i = 0; i<11; i++) {
			int totalValue = 0;

			totalValue += cards[i].getValue();
			if (totalValue < 21) {
				hand[i] = cards[i]
			}
		}
	}
}