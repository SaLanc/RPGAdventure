package com.SaL.CaveScroll.level.tile;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.graphics.Sprite;


public class SkyTile extends Tile {
	
	public SkyTile(Sprite sprite) {

		super(sprite);

	}

	public void render(int x, int y, Screen screen) {

		screen.renderTile(x << 4, y << 4, this);

	}
	public boolean solid() {
		return false;
	}
}
