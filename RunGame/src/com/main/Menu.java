package com.main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import com.main.Game.State;
import java.awt.event.*;


public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private boolean chosen;

	public Menu(Game game,Handler handler,HUD hud) {
		this.game=game;
		this.handler=handler;
		this.hud=hud;
	}

	public void render(Graphics g) {
		
		if(Game.GameState==State.Menu) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("Times New Roman",Font.ITALIC, 20));
			g.drawString("1 Player", 580, 238);
			g.drawRect(470, 200, 300, 64);
			g.drawString("2 Players", 580, 338);
			g.drawRect(470, 300, 300, 64);
			g.drawString("Help", 600, 438);
			g.drawRect(470, 400, 300, 64);
			g.drawString("Exit", 600, 538);
			g.drawRect(470, 500, 300, 64);
			}
		if(Game.GameState==State.End) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("Times New Roman",Font.ITALIC, 20));
			g.drawString("Game over! Your score is: "+hud.getScore(), 500, 338);
			g.drawString("Try again?", 580, 438);
			g.drawRect(470, 400, 300, 64);
			g.drawString("Back to main menu", 550, 535);
			g.drawRect(470, 500, 300, 64);
		}
		if(Game.GameState==State.Help) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("Times New Roman",Font.ITALIC, 20));
			g.drawString("Controlls", 580, 135);
			g.drawString("Player 1 uses Num8/Num5/Num4/Num6 for Up/Down/Left/Right", 380, 235);
			g.drawRect(280, 200, 700, 64);
			g.drawString("Player 2 uses W/S/A/D for Up/Down/Left/Right", 440, 335);
			g.drawRect(280, 300, 700, 64);
			g.drawString("Hit ESC for main menu", 540, 435);
			g.drawRect(280, 400, 700, 64);
		}
		if(Game.GameState==State.Pause) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("Times New Roman",Font.ITALIC,20));
			g.drawString("Pause?", 480, 438);
			g.drawRect(370, 400, 300, 64);
		}
	}
	
	public void tick() {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		int my=e.getY();
		int mx=e.getX();
		if(Game.GameState==State.Menu) {
			if(Game.GameState==State.Menu && mouseOver(mx,my,370,200,300,64)) {
				Game.GameState=State.Game;
				handler.addObject(new Player(Game.width/2+64,Game.height/2-32,ID.Player,handler));
				chosen=true;
			}
		if(Game.GameState==State.Menu && mouseOver(mx,my,370, 300, 300, 64)) {
			Game.GameState=State.Game;
			handler.addObject(new Player(Game.width/2+64,Game.height/2-32,ID.Player2,handler));	
			handler.addObject(new Player(Game.width/2-32,Game.height/2-32,ID.Player,handler));
			chosen=false;
		}
		if(Game.GameState==State.Menu && mouseOver(mx,my,370, 400, 300, 64)) {
			Game.GameState=State.Help;
		}
		if(Game.GameState==State.Menu && mouseOver(mx,my,370, 500, 300, 64)) {
			System.exit(1);
			}
		}
		if(Game.GameState==State.End) {
			if(mouseOver(mx,my,370,400,300,64) && Game.GameState==State.End) {
				Game.GameState=State.Game;
				hud.score(0);
				if(chosen==true) {
					handler.addObject(new Player(Game.width/2+64,Game.height/2-32,ID.Player,handler));
				}
				else{
					handler.addObject(new Player(Game.width/2+64,Game.height/2-32,ID.Player2,handler));	
					handler.addObject(new Player(Game.width/2-32,Game.height/2-32,ID.Player,handler));
				}
				return;
			}
		}	
			if(Game.GameState==State.End && mouseOver(mx,my,370, 500, 300, 64)) {
				Game.GameState=State.Menu;
				hud.score(0);
			}
		}
	
	private boolean mouseOver(float mx,float my, float x,float y, float width, float height) {
		if(mx>x && mx<x+width) {
			if(my>y && my<y+height) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
}
