package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;


public class rug extends Tile {

	public rug(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public boolean Accessory(){
		return false;
	}
	public boolean onFloor(){
		return true;
	}
	public boolean solid() {
		//System.out.println("solids check");
		return false;
	}
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, IndoorTiles.woodfloor);
	//	screen.renderTile(x+1 << 4, y << 4, IndoorTiles.woodfloor);
	//	screen.renderTile(x+2 << 4, y << 4, IndoorTiles.woodfloor);
	//	screen.renderTile(x << 4, y+1 << 4, IndoorTiles.woodfloor);
	//	screen.renderTile(x+1 << 4, y+1<< 4, IndoorTiles.woodfloor);
	//	screen.renderTile(x+2 << 4, y+1 << 4, IndoorTiles.woodfloor);
		screen.renderTile(x << 4, y << 4, this);
	//	screen.renderTile(x+1 << 4, y << 4, IndoorTiles.rug2);
	//	screen.renderTile(x+2 << 4, y << 4, IndoorTiles.rug3);
	//	screen.renderTile(x << 4, y+1 << 4, IndoorTiles.rug4);
	//	screen.renderTile(x+1 << 4, y+1 << 4, IndoorTiles.rug5);
	//	screen.renderTile(x+2 << 4, y+1 << 4, IndoorTiles.rug6);
	}

}
