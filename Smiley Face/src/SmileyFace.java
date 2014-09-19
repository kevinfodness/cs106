/* Add graphics library capabilities. */
import java.awt.*;

/**
 * Contains a program to create a smiley face.
 * 
 * @author Kevin Fodness <kevin@kevinfodness.com>
 * @version 1.0
 */
public class SmileyFace {

	/**
	 * Main method - does all the things.
	 * 
	 * @param args Arguments passed to the program.
	 */
	public static void main(String[] args) {
		
		/* Create a drawing panel. */
		DrawingPanel panel = new DrawingPanel(500, 500);

		/* Get the graphics object to start drawing. */
		Graphics g = panel.getGraphics();
		
		/* Draw the smiley face. */
		drawYellowCircle(g);
		
		/* TODO: Create two black circles for eyes. */
		/* TODO: Create a semicircle for a mouth. */
	}
	
	/**
	 * This method draws a yellow circle with a black border.
	 * 
	 * @returns void
	 */
	public static void drawYellowCircle(Graphics g) {

		/* Create a yellow circle. */
		g.setColor(Color.YELLOW);
		g.fillOval(50, 50, 400, 400);
		
		/* Add a black border to the circle. */
		g.setColor(Color.BLACK);
		g.drawOval(50, 50, 400, 400);
	}
}
