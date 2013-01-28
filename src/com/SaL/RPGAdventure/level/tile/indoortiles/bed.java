package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;
import com.SaL.RPGAdventure.level.tile.Tile;


public class bed extends Tile{
	public bed(Sprite sprite) {

		super(sprite);

		// TODO Auto-generated constructor stub
	}
	
public void Regester(int x, int y){
	loc[x][y] = IndoorTiles.bed;
	floormask[x][y] = IndoorTiles.woodfloor;
	Level.world[x][y] = loc[x][y];
	Level.world[x][y-1] = floormask[x][y];
	Level.OverTiles[x][y] = loc[x][y];
	Level.Solids[x][y] = true;
	Level.Solids[x][y-1] = true;
	}
	public boolean OverPlayer(){
		return true;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, IndoorTiles.woodfloor);
		screen.renderTile(x << 4, y << 4, IndoorTiles.bed1);


	}
	public void toprender(int x, int y, Screen screen){
		screen.renderTile(x << 4, y-1 << 4, this);
	}
}
