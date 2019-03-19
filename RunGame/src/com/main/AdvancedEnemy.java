package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AdvancedEnemy extends GameObject {

	@SuppressWarnings("unused")
	private Handler handler;
	private GameObject player1,player2;
	private boolean thereIsPlayer2=false;
	public AdvancedEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		for(int i=0;i<handler.object.size();i++) {
			if(handler.object.get(i).getID()==ID.Player) {
				player1=handler.object.get(i);
			}else {
			if(handler.object.get(i).getID()==ID.Player2) {
				player2=handler.object.get(i);
				thereIsPlayer2=true;
			}
			}
		}
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}

	
	public void tick() {
		x+=velX;
		y+=velY;
		float difX1,difY1,dist1,difX2,difY2,dist2;
		 difX1=x-player1.getX()-4;
		 difY1=y-player1.getY()-4;
		 dist1=(float) Math.sqrt((x-player1.getX())*(x-player1.getX())+(y-player1.getY())*(y-player1.getY()));
		if(thereIsPlayer2==true) {
				difX2=x-player2.getX()-4;
				difY2=y-player2.getY()-4;
				dist2=(float) Math.sqrt((x-player2.getX())*(x-player2.getX())+(y-player2.getY())*(y-player2.getY()));
				if(dist1>dist2) {
					velX=(float) ((-1.0/dist2)*difX2*1.2);
					velY=(float) ((-1.0/dist2)*difY2*1.2);
				}
				else {
					velX=(float) ((-1.0/dist1)*difX1*1.2);
					velY=(float) ((-1.0/dist1)*difY1*1.2);
				}
			}
		else {
			velX=(float) ((-1.0/dist1)*difX1*1.2);
			velY=(float) ((-1.0/dist1)*difY1*1.2);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval((int)x,(int) y, 16, 16);
		
	}

}
