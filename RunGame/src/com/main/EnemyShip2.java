package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class EnemyShip2 extends GameObject {
	
	public static float posX;

	public EnemyShip2(float x, float y, ID id) {
		super(x, y, id);
		velX=2;
		velY=2;
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,80,80);
	}

	public void tick() {
		x+=velX;
		if(x<=0 || x>=Game.width-80) {
			velX*=-1;
		}
		posX=x;
	}	
	
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int)x,(int) y, 80, 80);
	}
}
