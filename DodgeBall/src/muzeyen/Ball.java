package muzeyen;

import java.awt.Graphics;

public class Ball extends MovingObject {
	

	/**
	 * The radius of the ball.
	 */
	private int radius;

	/**
	 * Calls the superclass constructor, plus sets radius.
	 * 
	 * @param x
	 *            The x location.
	 * @param y
	 *            The y location.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 */
	public Ball(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		radius = 33; 
	}

	public void animateOneStep() {
	}

	/**
	 * Draws the ball
	 * 
	 * @param g
	 *            The graphics context.
	 */
	public void draw(Graphics g) {
		int drawX = (int) getX() - radius;
		int drawY = (int) getY() - radius;

		g.setColor(color);
		g.fillOval(drawX, drawY, radius * 2, radius * 2);


	}


}
