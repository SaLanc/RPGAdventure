package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;
import com.SaL.RPGAdventure.level.tile.Tile;


public class BrickWallNorth extends Tile {

	public BrickWallNorth(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
public void Regester(int x, int y){
	loc[x][y] =  IndoorTiles.brickwallnorth;
	Level.world[x][y] = loc[x][y];
	Level.Solids[x][y] = true;
	Level.walls[x][y] = loc[x][y];
}

	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y << 4, this);

	}
}
