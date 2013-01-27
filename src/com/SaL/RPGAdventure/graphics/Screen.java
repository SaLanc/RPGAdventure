package com.SaL.RPGAdventure.graphics;

import com.SaL.RPGAdventure.level.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;

	public int xOffset, yOffset;

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	public Screen(int width, int height) {

		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {

		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZEY; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZEY; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZEY || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = tile.sprite.pixels[x + y * tile.sprite.SIZEY];
				if (col!= 0xFFFF00FF &col!= 0x00FF00FF) pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZEY];
			}
		}
	}
	public void renderEntity(int xp, int yp, Sprite sprite) {

		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZEY; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZEY; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZEY || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZEY];
				if (col!= 0xFFFF00FF &col!= 0x00FF00FF) pixels[xa + ya * width] = sprite.pixels[x + y *sprite.SIZEY];
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite) {

		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 18; y++) {
			int ya = y + yp;
			for (int x = 0; x < 16; x++) {
			int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * 16];
				if (col!= 0xFFFEC5C5) pixels[xa + ya * width] = col;
			}
		}

	}

	public void setOffset(int xOffset, int yOffset) {

		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}

}
