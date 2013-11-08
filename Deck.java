import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;




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
			Card hearts = new Card(i, x,"Hearts");
			cards[i-1] = hearts;
			
		}
		for (int a=1; a<=13; a++) {
			int x = a;
			if (a > 10) {
				x = 10;
			}
			Card diamonds = new Card(a, x,"Diamonds");
			cards[a+12] = diamonds;
		}
		for (int b=1; b<=13; b++) {
			int x = b;
			if (b > 10) {
				x = 10;
			}
			Card spades = new Card(b, x,"Spades");
			cards[b+25] = spades;
		}
		for (int c=1; c<= 13; c++) {
			int x = c;
			if (c > 10) {
				x = 10;
			}
			Card clubs = new Card(c, x,"Clubs");
			cards[c+38] = clubs;

		}
		
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

	public void draw(Graphics g, int yOffset){
		int xOffset = 50;
		for (int i = 0; i<cards.length; i++) {
			cards[i].draw(g, new Rectangle(xOffset, yOffset, 200, 300));
			xOffset += 25;
		}
	}

	public void print(){
		for (int i=0; i<cards.length; i++) {
			System.out.println(cards[i].getValue() + " of " + cards[i].getSuit());
		}
	}


	
}