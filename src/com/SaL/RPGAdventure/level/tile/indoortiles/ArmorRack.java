package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;


public class ArmorRack extends Tile{
	public ArmorRack(Sprite sprite) {

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

		screen.renderTile(x << 4, y << 4, this);

	}

}


