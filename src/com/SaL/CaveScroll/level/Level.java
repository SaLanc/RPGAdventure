package com.SaL.CaveScroll.level;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.level.tile.Tile;

public class Level {

	public static int[] tiles;
	public static Tile[][] world;
	public static int width, height;
	public static int xSpawn;
	public static int ySpawn;

	public Level(String path) {

		loadLevel(path);
		getTiles();

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
				if (x < 0 || y < 0 || x >= width || y >= height) {
					Tile.brick.render(x, y, screen);
				} else {
					world[x][y].render(x, y, screen);
				}
			}

		}

	}

	private void getTiles() {

		world = new Tile[width][height];

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					if (tiles[x+y*width] == 0xFFA0A0A0) world[x][y] = Tile.brick;
					if (tiles[x+y*width] == 0xFF00FFFF) world[x][y] = Tile.sky;
					if (tiles[x+y*width] == 0xFF007ED8) world[x][y] = Tile.sky2;
					if (tiles[x+y*width] == 0xFF4CFF00) world[x][y] = Tile.sky3;
				
			}
		}
	}

	
}
