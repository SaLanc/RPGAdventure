package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.ThoseDangZombies;
import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;
import com.SaL.RPGAdventure.level.tile.Tile;

public class torchN extends Tile {

	public torchN(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void Regester(int x, int y) {

		loc[x][y] = IndoorTiles.torchn;
		floormask[x][y] = IndoorTiles.woodfloor;
		Level.world[x][y] = loc[x][y];
;
	}

	public void render(int x, int y, Screen screen) {
			screen.renderTile(x << 4, y << 4, Level.levelType);
			screen.renderTile(x << 4, y-1 << 4, IndoorTiles.brickwallnorth);
			if (ThoseDangZombies.qtick) {
				screen.renderTile(x << 4, y - 1 << 4, this);

			} else {
				screen.renderTile(x << 4, y - 1 << 4, IndoorTiles.torchn2);

			}
	}

}
