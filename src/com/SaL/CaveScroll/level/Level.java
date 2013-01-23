package com.SaL.CaveScroll.level;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.level.tile.Tile;

public class Level {

	public static int[] tiles;
	public int width, height;
	public static int xSpawn;
	public static int ySpawn;

	public Level(String path) {

		loadLevel(path);
		
	}

	protected void loadLevel(String path) {

	}

	public void render(int xScroll, int yScroll, Screen screen) {

		screen.setSpawn(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x+xSpawn, y+ySpawn).render(x, y, screen);

			}

		}

	}

	public Tile getTile(int x, int y) {

		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.VoidTile;

		if (tiles[x + y * width] == 0xFFA0A0A0) return Tile.brick;
		if (tiles[x + y * width] == 0xFF00FFFF) return Tile.sky;
		if (tiles[x + y * width] == 0xFF007ED8) return Tile.sky2;
		if (tiles[x + y * width] == 0xFF4CFF00) return Tile.sky3;

		return Tile.VoidTile;
	}
}
