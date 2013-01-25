package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;


public class Torch extends Tile {
	public Torch(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public boolean Accessory(){
		return true;
	}
	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y << 4, this);

	}
}
