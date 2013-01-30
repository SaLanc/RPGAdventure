package com.SaL.RPGAdventure.level;

import java.util.ArrayList;
import java.util.List;

import com.SaL.RPGAdventure.Game;
import com.SaL.RPGAdventure.entity.Entity;
import com.SaL.RPGAdventure.entity.mob.*;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.level.tile.Tile;
import com.SaL.RPGAdventure.level.tile.indoortiles.IndoorTiles;

public class Level {

	public static int[] tiles;
	public static Tile[][] world;
	public static boolean[][] Solids;
	public static boolean[][] OverPlayer;
	public static Tile[][] walls;
	public static Tile[][] OverTiles;
	public static int width, height;
	public static int xSpawn, ySpawn;
	public static Tile levelType;
	public Player player;
	public List<Entity> entities = new ArrayList<Entity>();
	public List<Entity>[][] entityMap;

	public Level(String path) {

		player = Game.player;
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
					if (world[x][y] != null) {
						world[x][y].render(x, y, screen);

					}
				}
			}
		}
	}

	public void overrender(int xScroll, int yScroll, Screen screen) {

		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				if (x > 0 & y > 0 & x < width & y < height) {

					if (OverTiles[x][y] != null) {
						OverTiles[x][y].toprender(x, y, screen);
						{

						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void getTiles() {

		walls = new Tile[width][height];
		world = new Tile[width][height];
		OverTiles = new Tile[width][height];
		Solids = new boolean[width][height];
		Tile.loc = new Tile[width][height];
		Tile.floormask = new Tile[width][height];

		entityMap = new ArrayList[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				entityMap[x][y] = new ArrayList<Entity>();

				if (tiles[x + y * width] == 0xFFFF00FF) world[x][y] = Tile.VoidTile;
				if (tiles[x + y * width] == 0xFFFFFFFF) IndoorTiles.woodfloor.Regester(x, y);
				if (tiles[x + y * width] == 0xFF808077) IndoorTiles.brickwallnorth.Regester(x, y);
				if (tiles[x + y * width] == 0xFF808078) IndoorTiles.brickwallsouth.Regester(x, y);
				if (tiles[x + y * width] == 0xFF808079) IndoorTiles.brickwalleast.Regester(x, y);
				if (tiles[x + y * width] == 0xFF808080) IndoorTiles.brickwallwest.Regester(x, y);
				if (tiles[x + y * width] == 0xFF73410F) {
					IndoorTiles.chairsouth.Regester(x, y);

				}
				if (tiles[x + y * width] == 0xFF0094FF) {
					IndoorTiles.armorrack.Regester(x, y);
				}
				if (tiles[x + y * width] == 0xFF73411F) {
					IndoorTiles.chairwest.Regester(x, y);

				}
				if (tiles[x + y * width] == 0xFF808069) IndoorTiles.southwestwall.Regester(x, y);
				if (tiles[x + y * width] == 0xFF808068) IndoorTiles.southeastwall.Regester(x, y);
				if (tiles[x + y * width] == 0xFFFF0000) IndoorTiles.bed.Regester(x, y);
				if (tiles[x + y * width] == 0xFF73412F) {
					IndoorTiles.table.Regester(x, y);

				}
				if (tiles[x + y * width] == 0xFFFFD800) IndoorTiles.torchn.Regester(x, y);
				if (tiles[x + y * width] == 0xFFFF3700) {
					IndoorTiles.rug.Regester(x, y);

				}

			}
		}
		player = new Player(Game.key);
		add(player);
	}

	public void add(Entity e) {

		entities.add(e);
		e.init(this);

		e.centerX = ((e.x) >> 4);
		e.centerY = (e.y >> 4);
		if (e.centerX >= 0 && e.centerY >= 0 && e.centerX < width && e.centerY < height) {
			entityMap[e.centerX][e.centerY].add(e);
		}
	}

	public void update() {

		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			int xSlotOld = e.centerX;
			int ySlotOld = e.centerY;
			if (!e.removed) e.update();
			e.centerX = ((e.x) >> 4);
			e.centerY = (e.y >> 4);
			if (e.removed) {
				if (xSlotOld >= 0 && ySlotOld >= 0 && xSlotOld < width && ySlotOld < height) {
					entityMap[xSlotOld][ySlotOld].remove(e);
				}
				entities.remove(i--);
			} else {
				if (e.centerX != xSlotOld || e.centerY != ySlotOld) {
					if (xSlotOld >= 0 && ySlotOld >= 0 && xSlotOld < width && ySlotOld < height) {
						entityMap[xSlotOld][ySlotOld].remove(e);
					}
					if (e.centerX >= 0 && e.centerY >= 0 && e.centerX < width && e.centerY < height) {
						entityMap[e.centerX][e.centerY].add(e);
					} else {
						e.outOfBounds();
					}

				}
			}
		}
	}
}
