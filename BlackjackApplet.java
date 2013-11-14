import java.awt.*;
import java.applet.*;

public class BlackjackApplet extends Applet {

	private Deck table;
	private Hand player;

	public void init() {
		table = new Deck();
		player = new Hand(table, g, 25);
	}

	public void paint(Graphics g) {
		// table.draw(g, 0, 50, 51);
		table.shuffle();
		player.dealPlayer(g, 2);
		
	}

}