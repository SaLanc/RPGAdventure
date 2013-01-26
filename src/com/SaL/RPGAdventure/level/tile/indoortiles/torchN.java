package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.Game;
import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;

public class torchN extends Tile {


	public torchN(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public boolean Accessory() {

		return false;
	}

	public boolean solid() {

		//System.out.println("solids check");
		return false;
	}

	public void render(int x, int y, Screen screen) {


	



		screen.renderTile(x << 4, y << 4, IndoorTiles.woodfloor);
		if (Game.qtick) {
			screen.renderTile(x << 4, y - 1 << 4, this);

		} else {
			screen.renderTile(x << 4, y - 1 << 4, IndoorTiles.torchn2);

		}
	}
}
