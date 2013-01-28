package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;
import com.SaL.RPGAdventure.level.tile.Tile;

public class ArmorRack extends Tile {

	public ArmorRack(Sprite sprite) {

		super(sprite);
		System.out.println("solids check");
		// TODO Auto-generated constructor stub
	}
	public void Regester(int x, int y) {

		loc[x][y] = IndoorTiles.armorrack;
		Level.world[x][y] = loc[x][y];
		Level.OverTiles[x][y] = loc[x][y];
		Level.Solids[x][y] = true;
	}

	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y << 4, Level.levelType);
		screen.renderTile(x << 4, (y << 4) - 9, this);

	}

	public void toprender(int x, int y, Screen screen) {

		screen.renderTile(x << 4, (y - 1 << 4) - 9, IndoorTiles.armorrack1);
	}
}
