package com.SaL.RPGAdventure.level.tile;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;


public class BrickTile extends Tile {
	
	public BrickTile(Sprite sprite) {

		super(sprite);

	}

	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y << 4, this);

	}
	public boolean solid() {
		//System.out.println("solids check");
		return true;
	}

}
