import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;





public class Card{
	private int value;
	private int value2;
	private String suit;
	private int facenumber;
	private String name;
	private Image image;
	int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};

	public Card(int facenumber, int value, String suit){
		this.suit = suit;
		this.value = value;
		this.facenumber = facenumber;
		this.image = Card.loadImage(getFaceNumber() + suit);

	}

	public Card(int facenumber, int value, int value2, String suit) {
		this.suit = suit;
		this.value = value;
		this.value2 = value2;
		this.facenumber = facenumber;
		this.image = Card.loadImage(getFaceNumber() + suit);
	}

	public String getFaceNumber() {

		if (facenumber == 1) {
			return "A";

		}else if (this.facenumber > 1 && this.facenumber <= 10) {
			return "" + this.facenumber;

		}else if (this.facenumber == 11) {
			return "J";

		}else if (this.facenumber == 12) {
			return "Q";

		}else if (this.facenumber == 13) {
			return "K";
		}else{
			return "";
		}
	}
	public int getValue(){
		return this.value;

	}
	public void setValue(int value) {
		this.value = value;

	}
	public String getSuit() {
		return this.suit;

	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getFace(){
		return this.facenumber;
	}

	public void setFace(int facenumber) {
		this.facenumber = facenumber;
	} 

	public void draw (Graphics g, Rectangle r) {
		g.drawImage(image, r.x, r.y, r.width, r.height, null);
	}
	


	private static Image loadImage(String name) {
		
		String path = null;
		Image image = null;

		try {
			path = "Cards" + File.separator + name + ".png";
			image = ImageIO.read(new File(path));
		}catch(IOException e) {

			System.out.println("Could not load image at path" + path);
			System.exit(1);
		}
		return image;
		

	}



}