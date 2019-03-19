package com.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
	
	private Thread thread;
	private boolean running=false;
	private Handler handler;
	public static int width=1200,height=700;
	private Spawn spawner;
	private HUD hud;
	private Menu menu;
	
	public enum State{
		Menu, Game,End,Help,Pause;
	}
	
	public static State GameState=State.Menu;
	
	public static BufferedImage picture_sheet1,picture_sheet2;
	
	public synchronized void start() {
		thread =new Thread(this);
		thread.start();
		running=true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
				this.requestFocus();
				long lastTime=System.nanoTime();
				double amountOfTics=60.0;
				double ns=1000000000/ amountOfTics;
				double delta=0;
				long timer=System.currentTimeMillis();
				int frames=0;
				while(running) {
					long now=System.nanoTime();
					delta+=(now-lastTime)/ns;
					lastTime=now;
					while(delta>=1) {
						tick();
						delta--;
					}
					if(running) {
						render();
					}
					frames++;
					if(System.currentTimeMillis()-timer>1000) {
						timer+=1000;
						System.out.println("FPS:" +frames);
						frames=0;
					}
				}
				stop();
				}
	
	private void tick() {
		handler.tick();
		if(GameState==State.Game) {
			hud.tick();
			spawner.tick();
		}
		else {
			if(GameState==State.Menu || GameState==State.End) {
				menu.tick();
			}
		}
	}
	
	private void render() {
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width,height);
		handler.render(g);
		if(GameState==State.Game) {
			hud.render(g);
		}else {
			if(GameState==State.Menu || GameState==State.End || GameState==State.Help) {
			menu.render(g);
			}
		}
		g.dispose();
		bs.show();
	}
	
	public Game() {
		BufferedImageLoader load=new BufferedImageLoader();
		try{
		picture_sheet1=load.loadImage("/p1a.png");
		picture_sheet2=load.loadImage("/p2m.png");
		}catch(Exception e) {
			e.printStackTrace();
		}
		handler = new Handler();
		hud=new HUD();
		menu=new Menu(this, handler,hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		AudioPlayer.init();
		AudioPlayer.getMusic("music").loop();
		new window(width,height,"Game",this);
		spawner= new Spawn(handler,hud);
	}

	public static float clamp(float var,float min,float max) {
		if(var>=max) {
			return var=max;
		}
		else {
			if(var<=min) {
				return var=min;
			}
			else {
				return var;
			}
		}
	}
	
	public static void main(String args[]) {
		new Game();
	}

}
