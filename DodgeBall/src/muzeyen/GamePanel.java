package muzeyen;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Dodgeball game where the user is a black ball and must avoid the red balls. If they 
 * touch the red ball they lose, if they touch the green ball they are awarded 1000 points
 * but is sent to the starting point. The objective of this game is to survive for as long
 * as possible and obtain the highest score you can.
 * <br>
* @version Dec. 2015
 * 
 * @author Issa Muzeyen adapted from Christina Kemp adapted from Sam Scott
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	boolean running = true; //checks if the game is running (if user lost or not)
	int xPlayer = 599; //x co-ord of user
	int yPlayer = 599; //y co-ord of user
	int score = 0;
	char key = ' ';

	int width = 600; //x of screen
	int height = 600; //y of screens

	Friend friend;
	/**
	 * The number of balls on the screen.
	 */
	int numBalls = 7;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 50;
	/**
	 * An array of balls.
	 */
	Ball[] ball = new Ball[numBalls];

	/** main program (entry point) */
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Surive!");
		JOptionPane.showMessageDialog(frame, "Move with WASD and avoid the red balls. Touching the green ball awards you 1000 points but sends you to the bottom right! Survive for as long as you can, ready?");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();
		frame.setResizable(false);

	}

	/**
	 * starts the thread and sets the speed and position of all the balls on the screen
	 */
	public GamePanel(){
		requestFocus();
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE); 

		for (int i = 0; i < numBalls; i++) {
			ball[i] = new Ball(50, 50, 0, width, 0, height);
			ball[i].setXSpeed(Math.random() * 16-8);
			ball[i].setYSpeed(Math.random() * 16-8);
			ball[i].setColor(Color.RED);

		}
		friend = new Friend(50,50,0, width,0, height);
		friend.setXSpeed(6);
		friend.setYSpeed(5);
		friend.setColor(Color.GREEN);

		this.setFocusable(true);
		addKeyListener (this);

		Thread gameThread = new Thread(this);
		gameThread.start();
	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {

		while (running) {

			repaint();
			collision();

			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {

		if (running){
			super.paintComponent(g);
			for (int i = 0; i < numBalls; i++) {
				ball[i].draw(g);
			}
			friend.draw(g);
			this.requestFocusInWindow();
			requestFocus();
			//////////////////////// where things are drawn to screen
			g.setColor(Color.black);
			g.fillOval(xPlayer, yPlayer, 10, 10);

			g.drawString("Score: " + score, 7, 20);
			////////////////////////
			score ++;
		}

		else{
			super.paintComponent(g);

			g.setFont(new Font ("Calibri", Font.PLAIN, 30));
			g.drawString("You lost! Your score was: " + score, 120, 300);
		}
	}


	/**
	 * moves user according to what letter they pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		key = e.getKeyChar();
		if (key == 'w'){
			yPlayer-=10;
		}
		repaint();
		if (key == 'a'){
			xPlayer-=10;
		}
		repaint();
		if (key == 's'){
			yPlayer+=10;
		}
		repaint();
		if (key == 'd'){
			xPlayer+=10;
		}
		repaint();
	}

	@Override
	/**
	 * resets key when w,a,s or d is released
	 */
	public void keyReleased(KeyEvent e) {
		key = ' ';
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}


	/**
	 * Checks if the user lost by colliding with the red balls or is trying to go 
	 * out of bounds. If the player touches the green ball, they are rewarded 1000 points
	 * and are sent to the bottom right of the screen.
	 */
	public  void collision(){
		for (int i = 0; i < ball.length; i++){
			double distance  = Math.sqrt((ball[i].getX() - xPlayer) * (ball[i].getX() - xPlayer) +  (ball[i].getY() - yPlayer) * (ball[i].getY() - yPlayer));
			if(distance < 33){
				running = false;
			}
			double distanceGreen  = Math.sqrt((friend.getX() - xPlayer) * (friend.getX() - xPlayer) +  (friend.getY() - yPlayer) * (friend.getY() - yPlayer));
			if(distanceGreen < 10){
				score+=1000;
				xPlayer = 599;
				yPlayer = 599;				
			}
			if (xPlayer <=0)
				xPlayer = 0;
			if (xPlayer >=600)
				xPlayer = 600;
			if (yPlayer <=0)
				yPlayer = 0;
			if (yPlayer >=600)
				yPlayer = 600;
		}
	}
}



