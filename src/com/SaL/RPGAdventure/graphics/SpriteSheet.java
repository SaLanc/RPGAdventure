package com.SaL.RPGAdventure.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;
	public SpriteSheet spritesheet;

	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	public static SpriteSheet indoortiles = new SpriteSheet("/textures/maptiles/indoortiles.png",112);

	public SpriteSheet(String path, int size) {

		this.path = path;
		SIZE = size;
		load();

	}
	public void load() {

		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			pixels = new int [w*h];
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
