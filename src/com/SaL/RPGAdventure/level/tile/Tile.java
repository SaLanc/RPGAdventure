package com.SaL.RPGAdventure.level.tile;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile VoidTile = new VoidTile(Sprite.VoidSprite);
	public static Tile brick = new BrickTile(Sprite.brick);
	public static Tile sky = new SkyTile(Sprite.sky);
	public static Tile sky2 = new SkyTile2(Sprite.sky2);
	public static Tile sky3 = new SkyTile3(Sprite.sky3);
	
	public Tile(Sprite sprite) {

		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

	public boolean Accessory() {
		return false;
	}
	public boolean Hanging(){
		return false;
	}
}
