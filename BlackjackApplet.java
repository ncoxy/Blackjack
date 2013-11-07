import java.awt.*;
import java.applet.*;

public class BlackjackApplet extends Applet {

	private Deck table;

	public void init() {
		table = new Deck();
	}

	public void paint(Graphics g) {
		table.draw(g);
	}

}