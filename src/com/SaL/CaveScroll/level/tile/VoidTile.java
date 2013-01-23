package com.SaL.CaveScroll.level.tile;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.graphics.Sprite;
	
	public class VoidTile extends Tile {

		public VoidTile(Sprite sprite) {

			super(sprite);

		}

		public void render(int x, int y, Screen screen) {

			screen.renderTile(x << 4, y << 4, this);

		}

	}

