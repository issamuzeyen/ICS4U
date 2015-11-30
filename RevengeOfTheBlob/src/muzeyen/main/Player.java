package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	
	private double x; //x-cord of player
	private double y; //y-cord of player
	
	//used to make movement smother 
	private double velX = 0;
	private double velY = 0;
	
	private BufferedImage player;
	
	public Player(double x, double y, Game game){
		
		//initialize player and sets x and y c-cord
		this.x = x;
		this.y = y;
		
		//received from getter method in Game class
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		player = ss.grabImage(1, 1, 32, 32);
	}
	
	//update method
	public void tick(){
		x+=velX;
		y+=velY;
		
		//prevents player from leaving the screen
		if(x <= 0){
			x=0;
		}
		if(x>=640-20){ //-20 was a result of trial and error
			x=640-20;
		}
		if(y <= 0){
			y=0;
		}
		if(y>=480-32){ //-32 was a result of trial and error
			y=480-32;
		}
	}
	
	//draw image method
	public void render(Graphics g){
		
		g.drawImage(player, (int)x, (int)y, null);
		
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	
	public void setVelX(double velX){
		this.velX = velX;
	}
	public void setVelY(double velY){
		this.velY = velY;
	}

}
