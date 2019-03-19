package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.main.Game.State;

public class Player extends GameObject {

	Game game;
	Handler handler;
	Random r= new Random();
	private BufferedImage player_image1,player_image2;
	
	public Player(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		PictureSheet ps1=new PictureSheet(Game.picture_sheet1);
		player_image1=ps1.grabImage(1, 1, 30, 40);
		PictureSheet ps2=new PictureSheet(Game.picture_sheet2);
		player_image2=ps2.grabImage(1, 1,30, 40);
	}
	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		x=Game.clamp(x, 0, Game.width-36);
		y=Game.clamp(y, 0, Game.height-61);
		collision();
		
	}
	private void collision() {
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getID()==ID.BasicEnemy || tempObject.getID()==ID.AdvancedEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					game.GameState=State.End;
					handler.clearObjects();
				}
			}
		}
	}
	@Override
	public void render(Graphics g) {
		if(id==ID.Player2) {
			g.setColor(Color.YELLOW);
			g.fillOval((int)x,(int)y, 30, 30);
			//g.drawImage(player_image2,(int)x,(int)y,null);
		}
		else {
			if(id==ID.Player) {
				g.setColor(Color.GREEN);
				g.fillOval((int)x,(int)y, 30, 30);
				//g.drawImage(player_image1,(int)x,(int)y,null);
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,28,28);
	}
}
