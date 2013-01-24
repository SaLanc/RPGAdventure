package com.SaL.RPGAdventure.level.tile;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;

public class WoodFloor extends Tile {
	public WoodFloor(Sprite sprite) {

		super(sprite);

	}

	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y << 4, this);

	}

}
