package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;


public class ChairWest1 extends Tile {

	public ChairWest1(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public boolean OverPlayer(){
		return true;
	}
	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y << 4, this);

	}

}
