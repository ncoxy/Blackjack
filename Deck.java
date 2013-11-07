import java.util.Random;

public class Deck{

	private int value;
	private String name;
	Random random = new Random();

	Card[] cards = new Card[52];
	public Deck() {
		for (int i=1; i<=13; i++) {
			int x = i;
			if (i > 10) {
				x = 10;
			}
			Card hearts = new Card(x, "Hearts");
			cards[i-1] = hearts;
			
		}
		for (int a=1; a<=13; a++) {
			int x = a;
			if (a > 10) {
				x = 10;
			}
			Card diamonds = new Card(x, "Diamonds");
			cards[a+12] = diamonds;
		}
		for (int b=1; b<=13; b++) {
			int x = b;
			if (b > 10) {
				x = 10;
			}
			Card spades = new Card(x, "Spades");
			cards[b+25] = spades;
		}
		for (int c=1; c<= 13; c++) {
			int x = c;
			if (c > 10) {
				x = 10;
			}
			Card clubs = new Card(x, "Clubs");
			cards[c+38] = clubs;

		}
		shuffle();
		print();
	}

	public void shuffle(){

		
		for (int i = cards.length - 1; i>0; i--) {
			Card a = cards[i];
			int temp = random.nextInt(i);
			cards[i] = cards[temp];
			cards[temp] = a;
		}
	}

	public void drawCard(){
		// asdfasdf
	}

	public void print(){
		for (int i=0; i<cards.length; i++) {
			System.out.println(cards[i].getValue() + " of " + cards[i].getSuit());
		}
	}


	
}