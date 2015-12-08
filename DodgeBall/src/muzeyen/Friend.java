package muzeyen;

import java.awt.Graphics;

public class Friend extends MovingObject{

	/**
	 * The radius of the ball.
	 */
	int radius = 10;

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
	public Friend(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left, right, top, bottom);
	}

	@Override
	/**
	 * draws the ball
	 */
	public void draw(Graphics g) {
		int drawX = (int) getX() - radius;
		int drawY = (int) getY() - radius;

		g.setColor(color);
		g.fillOval(drawX, drawY, radius * 2, radius * 2);
	}

	@Override
	public void animateOneStep() {	
	}

}
