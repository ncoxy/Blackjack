public class Card{
	private int value;
	private int value2;
	private String suit;
	private int facenumber;
	int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};

	public Card(int value, String suit){
		this.suit = suit;
		this.value = value;
		// System.out.println("" + this.value + "of " + suit);
	}

	public Card(int value, int value2, String suit) {
		this.suit = suit;
		this.value = value;
		this.value2 = value2;
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








}