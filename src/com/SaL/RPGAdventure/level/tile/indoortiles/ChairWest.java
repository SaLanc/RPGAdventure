package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;
import com.SaL.RPGAdventure.level.tile.Tile;


public class ChairWest extends Tile {

	public ChairWest(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public void Regester(int x, int y) {

		loc[x][y] = IndoorTiles.chairwest;
		floormask[x][y] = IndoorTiles.woodfloor;
		Level.world[x][y] = loc[x][y];
		Level.world[x][y-1] = floormask[x][y];
		Level.OverTiles[x][y-1] = loc[x][y];
		Level.Solids[x][y] = true;
	}
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, IndoorTiles.woodfloor);
		screen.renderTile(x << 4, y << 4, IndoorTiles.chairwest1);

	}
	public void toprender(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, IndoorTiles.chairwest);
	}

}
