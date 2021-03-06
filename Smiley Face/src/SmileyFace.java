/* Add graphics library capabilities. */
import java.awt.*;

/**
 * Contains a program to create a smiley face.
 * 
 * @see Building Java Programs, chapter 3 supplement
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
		drawEye(g, 325, 200);
		drawEye(g, 175, 200);
		
		/* TODO: Create a semicircle for a mouth. */
	}
	
	/**
	 * A method to draw an eye on the smiley face.
	 * 
	 * @param g The graphics object attached to the canvas.
	 * @param x The x position of the eye.
	 * @param y The y position of the eye.
	 * 
	 * @return void
	 */
	public static void drawEye(Graphics g, int x, int y) {
		
		/* Store eye dimensions. */
		int height = 100;
		int width = 50;
		
		/* Draw an eye. */
		g.setColor(Color.BLACK);
		g.fillOval(x - (width / 2), y - (height / 2), width, height);
	}
	
	/**
	 * This method draws a yellow circle with a black border.
	 * 
	 * @param g The graphics object attached to the canvas.
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
