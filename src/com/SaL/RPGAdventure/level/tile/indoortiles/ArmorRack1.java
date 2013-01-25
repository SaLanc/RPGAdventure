package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;


public class ArmorRack1 extends Tile{
	public ArmorRack1(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public boolean Accessory(){
		return true;
	}
	public boolean solid() {
		//System.out.println("solids check");
		return true;
	}
	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, (y << 4)-9, this);
		screen.renderTile(x << 4, (y-1 << 4)-9, IndoorTiles.armorrack);
	}
	public boolean Hanging(){
		return true;
	}
}

