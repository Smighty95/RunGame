package com.main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.main.Game.State;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown=new boolean[4];
	private boolean[] keyDown2=new boolean[4];
	

	public KeyInput(Handler handler) {
		this.handler=handler;
		for(int i=0;i<keyDown.length;i++) {
			keyDown[i]=false;
		}
		for(int i=0;i<keyDown2.length;i++) {
			keyDown2[i]=false;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getID()==ID.Player) {
				if(key==KeyEvent.VK_NUMPAD8)
					{tempObject.setvelY(-4); keyDown[0]=true;}
				if(key==KeyEvent.VK_NUMPAD5)
					{tempObject.setvelY(4); keyDown[1]=true;}
				if(key==KeyEvent.VK_NUMPAD6)
					{tempObject.setvelX(4); keyDown[2]=true;}
				if(key==KeyEvent.VK_NUMPAD4)
					{tempObject.setvelX(-4); keyDown[3]=true;}
			}
			if(tempObject.getID()==ID.Player2) {
				if(key==KeyEvent.VK_W)
				{tempObject.setvelY(-4); keyDown2[0]=true;}
				if(key==KeyEvent.VK_S)
				{tempObject.setvelY(4); keyDown2[1]=true;}
				if(key==KeyEvent.VK_D)
				{tempObject.setvelX(4); keyDown2[2]=true;}
				if(key==KeyEvent.VK_A)
				{tempObject.setvelX(-4); keyDown2[3]=true;}
			}
		}
		if(key==KeyEvent.VK_ESCAPE) {
			Game.GameState=State.End;
			handler.clearObjects();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();	
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getID()==ID.Player) {
				if(key==KeyEvent.VK_NUMPAD8)
					keyDown[0]=false;
				if(key==KeyEvent.VK_NUMPAD5)
					keyDown[1]=false;
				if(key==KeyEvent.VK_NUMPAD6)
					keyDown[2]=false;
				if(key==KeyEvent.VK_NUMPAD4)
					keyDown[3]=false;
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setvelY(0);
				}
				if(!keyDown[2] && !keyDown[3]) {
					tempObject.setvelX(0);
				}
			}
			
			if(tempObject.getID()==ID.Player2) {
				if(key==KeyEvent.VK_W)
					keyDown2[0]=false;
				if(key==KeyEvent.VK_S)
					keyDown2[1]=false;
				if(key==KeyEvent.VK_D)
					keyDown2[2]=false;
				if(key==KeyEvent.VK_A)
					keyDown2[3]=false;
				if(!keyDown2[0] && !keyDown2[1]) {
					tempObject.setvelY(0);
				}
				if(!keyDown2[2] && !keyDown2[3]) {
					tempObject.setvelX(0);
				}
			}
		}	
	}
}
