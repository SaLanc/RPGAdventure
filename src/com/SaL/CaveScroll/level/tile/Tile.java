package com.SaL.CaveScroll.level.tile;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.graphics.Sprite;
	
	public class Tile {

		public int x, y;
		public Sprite sprite;

		public static Tile VoidTile = new VoidTile(Sprite.VoidSprite);
		public static Tile brick = new BrickTile(Sprite.brick);
		public static Tile sky = new SkyTile(Sprite.sky);



		public Tile(Sprite sprite) {

			this.sprite = sprite;
		}

		public void render(int x, int y, Screen screen) {

		}

	}


