package com.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private Random r=new Random();
	private int b=0,no;

	public Spawn(Handler handler,HUD hud) {
		this.handler=handler;
		this.hud=hud;
	}
	
	public void tick() {
			if(hud.getScore()%1500==0) {
				handler.addObject(new AdvancedEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.AdvancedEnemy,handler));
			}
			if(hud.getScore()==100 || hud.getScore()%800==0) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.BasicEnemy));
			}
			if(hud.getScore()%3000==0) {
				b++;
				no=5;
				handler.addObject(new EnemyShip(0,0,ID.EnemyShip));
				}
			if(b>0) {
				if(hud.getScore()%300==0 && no!=0) {
					handler.addObject(new BasicEnemy(EnemyShip.posX,0,ID.BasicEnemy));
					no--;
				}
			}
			if(hud.getScore()%5000==0 && b>0) {
				for(int i=0;i<handler.object.size();i++) {
					if(handler.object.get(i).getID()==ID.EnemyShip) {
						handler.object.remove(i);
					}
				}
			}
		}	
	}
					
		
				
			
		
	