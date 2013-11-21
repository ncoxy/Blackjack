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
	int loc = 0;
	Random random = new Random();
	int total = 0;
	int totalCards = 0;
	Card[] cards = new Card[52];
	
	public Deck() {
		for (int i=1; i<=13; i++) {
			int x = i;
			if (i > 10) {
				x = 10;
			}
			Card hearts = new Card(x, "Hearts", i);
			cards[i-1] = hearts;
			
		}
		for (int a=1; a<=13; a++) {
			int x = a;
			if (a > 10) {
				x = 10;
			}
			Card diamonds = new Card(x, "Diamonds", a);
			cards[a+12] = diamonds;
		}
		for (int b=1; b<=13; b++) {
			int x = b;
			if (b > 10) {
				x = 10;
			}
			Card spades = new Card(x, "Spades", b);
			cards[b+25] = spades;
		}
		for (int c=1; c<= 13; c++) {
			int x = c;
			if (c > 10) {
				x = 10;
			}
			Card clubs = new Card(x, "Clubs", c);
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

	public void draw(Graphics g, int xOffset, int yOffset, int amount){		
		for (int i = 0; i<amount; i++) {
			if (total > 21) {
				System.out.println(total);
			}else{
				cards[loc].draw(g, new Rectangle(xOffset, yOffset, 200, 300));
				total += cards[loc].getValue();
				xOffset += 25;
				loc++;
				System.out.println(total);
			
			}
		
		}
		if (loc > 41) {
			shuffle();
			loc = 0;
		}
	}

	public void print(){
		for (int i=0; i<52; i++) {
			cards[i].print();
		}
	}

	public Card deal(){
		totalCards++;
		return cards[totalCards - 1];
	}


	
}