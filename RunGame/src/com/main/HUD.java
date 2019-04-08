package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	private int score=9900;

	public void tick() {
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Score: "+score,20,20);
		
	}
	
	public void score(int score) {
		this.score=score;
	}
	
	public int getScore() {
		return score;
	}
	
}
