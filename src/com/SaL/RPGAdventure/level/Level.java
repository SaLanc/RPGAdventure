package com.SaL.RPGAdventure.level;

import java.util.ArrayList;
import java.util.List;

import com.SaL.RPGAdventure.entity.Entity;
import com.SaL.RPGAdventure.entity.mob.*;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.level.tile.Tile;
import com.SaL.RPGAdventure.level.tile.indoortiles.IndoorTiles;

public class Level {

	public static int[] tiles;
	public static Tile[][] world;
	public static int width, height;
	public static int xSpawn, ySpawn;
	public static Tile levelType;
	public Player player;
	public List<Entity> entities = new ArrayList<Entity>();
	public List<Entity>[] entityMap;

	public Level(String path) {

		loadLevel(path);
		getTiles();

	}

	protected void loadLevel(String Path) {

	}

	public void render(int xScroll, int yScroll, Screen screen) {

		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				if (x < 0 || y < 0 || x >= width || y >= height) {
					Tile.VoidTile.render(x, y, screen);
				} else {
					if (!world[x][y].Accessory()) {
						world[x][y].render(x, y, screen);
					} else {
						//						if (!world[x][y].Hanging()){

						levelType.render(x, y, screen);
						//						}
						if (world[x][y].solid()) {
							world[x][y].render(x, y, screen);
						}
					}

				}
			}

		}
	}

	public void renderAcc(int xScroll, int yScroll, Screen screen) {

		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				if (x > 0 & y > 0 & x < width & y < height) {
					if (world[x][y].Accessory() & !world[x][y].solid()) world[x][y].render(x, y, screen);
				}
			}
		}
	}


	@SuppressWarnings("unchecked")
	private void getTiles() {

		world = new Tile[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				world[x][y] = levelType;
			}
		}
		entityMap = new ArrayList[width * height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				if (tiles[x + y * width] == 0xFFFF00FF) world[x][y] = Tile.VoidTile;
				if (tiles[x + y * width] == 0xFF00FFFF) world[x][y] = Tile.sky;
				if (tiles[x + y * width] == 0xFF007ED8) world[x][y] = Tile.sky2;
				if (tiles[x + y * width] == 0xFF4CFF00) world[x][y] = Tile.sky3;
				if (tiles[x + y * width] == 0xFF808077) world[x][y] = IndoorTiles.brickwallnorth;
				if (tiles[x + y * width] == 0xFF808078) world[x][y] = IndoorTiles.brickwallsouth;
				if (tiles[x + y * width] == 0xFF808079) world[x][y] = IndoorTiles.brickwalleast;
				if (tiles[x + y * width] == 0xFF808080) world[x][y] = IndoorTiles.brickwallwest;
				if (tiles[x + y * width] == 0xFF73410F) {
					world[x][y] = IndoorTiles.chairsouth1;
					world[x][y + 1] = IndoorTiles.chairsouth2;
				}
				if (tiles[x + y * width] == 0xFF0094FF) {
					world[x][y] = IndoorTiles.armorrack1;
				}
				if (tiles[x + y * width] == 0xFF73411F) {
					world[x][y] = IndoorTiles.chairwest1;
					world[x][y + 1] = IndoorTiles.chairwest2;
				}
				if (tiles[x + y * width] == 0xFF808069) world[x][y] = IndoorTiles.southwestwall;
				if (tiles[x + y * width] == 0xFF808068) world[x][y] = IndoorTiles.southeastwall;
				if (tiles[x + y * width] == 0xFFFF0000) world[x][y] = IndoorTiles.bed;
				if (tiles[x + y * width] == 0xFFFF0001) world[x][y] = IndoorTiles.bed1;
				if (tiles[x + y * width] == 0xFF73412F) {
					world[x][y] = IndoorTiles.table;
					world[x + 1][y] = IndoorTiles.table1;
					world[x][y + 1] = IndoorTiles.table2;
					world[x + 1][y + 1] = IndoorTiles.table3;
				}
				if (tiles[x + y * width] == 0xFFFFD800) world[x][y] = IndoorTiles.torchn;
				if (tiles[x + y * width] == 0xFFFF3700) {
					world[x][y] = IndoorTiles.rug1;

				}

			}
		}
	}

}
