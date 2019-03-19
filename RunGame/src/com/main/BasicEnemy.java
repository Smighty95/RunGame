package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	public BasicEnemy(float x, float y, ID id) {
		super(x, y, id);
		velX=5;
		velY=5;
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}

	public void tick() {
		x+=velX;
		y+=velY;
		if(y<=0 || y>=Game.height-40) {
			velY*=-1;
		}
		if(x<=0 || x>=Game.width-20) {
			velX*=-1;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int)x,(int) y, 16, 16);
	}
}
