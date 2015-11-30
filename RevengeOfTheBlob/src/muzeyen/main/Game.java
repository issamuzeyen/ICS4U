package muzeyen.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	//standard JFrame dimensions
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 2;
	public final String TITLE = "Revenge of the Blob"; //title

	private boolean running = false;
	private Thread thread;

	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private BufferedImage spriteSheet = null;
	
	private Player p;
	private Controller c;



	//initialize
	public void init(){
		requestFocus(); //makes it so user doesn't have to press game to begin playing when it launces
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			spriteSheet = loader.loadImage("/sprite_sheet.png");
		}catch(IOException e){
			e.printStackTrace();	
		}

		addKeyListener(new KeyInput(this));
		
		p = new Player(200,200,this); //initializes player with x-cord and y-cord 200\
		c = new Controller(this);

	}


	//starts up initialized thread
	private synchronized void start(){
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop(){  //sync deals with threads
		if(!running)
			return;

		running = false;
		try {
			thread.join(); //joins all threads together and waits for them to terminate
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}


	//whenever a thread is called, runnable will call run
	public void run(){
		//game loop - handles updates until game is exited 
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0; //updates 60 times every time it goes through
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();	

		while (running){
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			if (delta >=1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks, FPS " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	//everything that updates
	private void tick(){
		p.tick();
		c.tick();

	}

	//everything that renders
	private void render (){

		BufferStrategy bs = this.getBufferStrategy(); //handles buffering behind the scenes, this refers to canvas
		if (bs == null){
			createBufferStrategy(3); //3 means triple buffering (loads 2 images in "stock/supply"), increases performance
			return;
		}

		Graphics g = bs.getDrawGraphics(); //draws out buffers
		//////////////////////////////

		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

		p.render(g);
		c.render(g);

		/////////////////////////////

		g.dispose();
		bs.show();
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT){
			p.setVelX(5);
		}
		else if (key == KeyEvent.VK_LEFT){
			p.setVelX(-5);
		}
		else if (key == KeyEvent.VK_DOWN){
			p.setVelY(5);
		}
		else if (key == KeyEvent.VK_UP){
			p.setVelY(-5);
		}	
		else if (key == KeyEvent.VK_SPACE){
			c.addBullet(new Bullet(p.getX(), p.getY(), this));
		}	
	}

	public void keyReleased(KeyEvent e){

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT){
			p.setVelX(0);
		}
		else if (key == KeyEvent.VK_LEFT){
			p.setVelX(0);
		}
		else if (key == KeyEvent.VK_DOWN){
			p.setVelY(0);
		}
		else if (key == KeyEvent.VK_UP){
			p.setVelY(0);
		}
	}

	public static void main(String args[]){
		Game game = new Game();

		//initializes a new dimension with a specified width and height
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();


	}

	//method that passes spriteSheet to player class
	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}


}
