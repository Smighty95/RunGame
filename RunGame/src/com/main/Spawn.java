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
			/*if(hud.getScore()==100 || hud.getScore()%800==0) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.BasicEnemy));
			}
			if(hud.getScore()%1000==0) {
				handler.addObject(new AdvancedEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.AdvancedEnemy,handler));
			}
		
			if(hud.getScore()==5000) {
				for(int i=0;i<handler.object.size();i++) {
					if(handler.object.get(i).getID()!=ID.Player && handler.object.get(i).getID()!=ID.Player2) {
						handler.object.remove(i);
						i--;
					}
				}
				b++;
				no=10;
				handler.addObject(new EnemyShip(0,0,ID.EnemyShip));
			}
			if(b>0) {
				if(hud.getScore()%200==0 && no!=0) {
					if(hud.getScore()<10000) {
					handler.addObject(new BasicEnemy(EnemyShip.posX,0,ID.BasicEnemy));
					no--;
					}
					else {
						handler.addObject(new SuperEnemy(EnemyShip.posX,0,ID.BasicEnemy,handler));
						no--;
					}
				}
			}
				
			if(hud.getScore()==7500) {
				for(int i=0;i<handler.object.size();i++) {
					if(handler.object.get(i).getID()!=ID.Player && handler.object.get(i).getID()!=ID.Player2) {
						handler.object.remove(i);
						i--;
					}
				}
				for(int i=0;i<7;i++) {
					handler.addObject(new BasicEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.BasicEnemy));
				}
				for(int i=0;i<5;i++) {
					handler.addObject(new AdvancedEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.AdvancedEnemy,handler));
				}
			}
			
			if(hud.getScore()==10000) {
				for(int i=0;i<handler.object.size();i++) {
					if(handler.object.get(i).getID()!=ID.Player && handler.object.get(i).getID()!=ID.Player2) {
						handler.object.remove(i);
						i--;
					}
				}
			}
				if(hud.getScore()==10001) {
					for(int i=0;i<handler.object.size();i++) {
						if(handler.object.get(i).getID()!=ID.Player && handler.object.get(i).getID()!=ID.Player2) {
							handler.object.remove(i);
							i--;
						}
					}
					no=10;
					handler.addObject(new EnemyShip(0,0,ID.EnemyShip));
					b++;
				}*/
		
				if(hud.getScore()<10000) {
					if(hud.getScore()==100) {
						handler.addObject(new BasicEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.BasicEnemy));
					}
					if(hud.getScore()==5000) {
						for(int i=0;i<handler.object.size();i++) {
							if(handler.object.get(i).getID()!=ID.Player && handler.object.get(i).getID()!=ID.Player2) {
								handler.object.remove(i);
								i--;
							}
						}
						handler.addObject(new EnemyShip(0,0,ID.EnemyShip));
						b++;
						no=10;
					}
					if(hud.getScore()%1000==0) {
						handler.addObject(new AdvancedEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.AdvancedEnemy,handler));
					}
					if(hud.getScore()%800==0 && b==0) {
						handler.addObject(new BasicEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.BasicEnemy));
					}
					else {
						if(hud.getScore()%200==0 && no!=0) {
							handler.addObject(new BasicEnemy(EnemyShip.posX,0,ID.BasicEnemy));
							no--;
						}
					}
					if(hud.getScore()==7500) {
						for(int i=0;i<handler.object.size();i++) {
							if(handler.object.get(i).getID()!=ID.Player && handler.object.get(i).getID()!=ID.Player2) {
								handler.object.remove(i);
								i--;
							}
						}
						for(int i=0;i<7;i++) {
							handler.addObject(new BasicEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.BasicEnemy));
						}
						for(int i=0;i<5;i++) {
							handler.addObject(new AdvancedEnemy(r.nextInt(Game.width-60),r.nextInt(Game.height-60),ID.AdvancedEnemy,handler));
						}
					}
				}else {
					if(hud.getScore()==10000) {
						for(int i=0;i<handler.object.size();i++) {
							if(handler.object.get(i).getID()!=ID.Player && handler.object.get(i).getID()!=ID.Player2) {
								handler.object.remove(i);
								i--;
							}
						}
						no=10;
						handler.addObject(new EnemyShip(0,0,ID.EnemyShip));
					}
					if(hud.getScore()%200==0 && no!=0) {
						handler.addObject(new SuperEnemy(EnemyShip.posX,0,ID.SuperEnemy,handler));
					}
				}
			}
		}	
					
		
				
			
		
	