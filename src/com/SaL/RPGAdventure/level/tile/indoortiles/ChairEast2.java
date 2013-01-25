package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;


public class ChairEast2 extends Tile {

	public ChairEast2(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public boolean Accessory(){
		return true;
	}
	public boolean solid() {
		//System.out.println("solids check");
		return true;
	}
}
