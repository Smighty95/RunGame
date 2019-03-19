package com.main;

import java.awt.image.BufferedImage;

public class PictureSheet {
	
	private BufferedImage picture;
	
	public PictureSheet(BufferedImage img) {
		this.picture=img;
	}
	
	public BufferedImage grabImage(int col,int row, int width, int height) {
		BufferedImage img=picture.getSubimage((row*40)-40, (col*40)-40, width, height);
		return img;
	}
}
