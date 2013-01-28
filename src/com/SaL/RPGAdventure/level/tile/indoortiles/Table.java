package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;
import com.SaL.RPGAdventure.level.tile.Tile;


public class Table extends Tile {
	public Table(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}

	
	public void Regester(int x, int y) {
		loc[x][y] = IndoorTiles.table;
		floormask[x][y] = IndoorTiles.woodfloor;
		Level.world[x+1][y-1] = floormask[x][y];
		Level.world[x][y-1] = floormask[x][y];
		Level.OverTiles[x][y] = loc[x][y];
		Level.Solids[x][y] = true;
		Level.Solids[x+1][y] = true;
		Level.world[x][y] = loc[x][y];
		Level.world[x+1][y] = null;
		
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, Level.levelType);
		screen.renderTile(x+1 << 4, y << 4, Level.levelType);
		screen.renderTile(x << 4, y << 4, IndoorTiles.table2);
		screen.renderTile(x+1 << 4, y << 4, IndoorTiles.table3);

	}
	public void toprender(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y-1 << 4, IndoorTiles.table);
		screen.renderTile(x+1 << 4, y-1 << 4, IndoorTiles.table1);

	}
}
