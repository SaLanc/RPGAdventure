package com.SaL.RPGAdventure.level.tile.indoortiles;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.tile.Tile;


public class IndoorTiles extends Tile{
	
	public static Tile woodfloor = new WoodFloor(Sprite.woodfloor);
	public static Tile chaireast1 = new ChairEast1(Sprite.chaireast1);
	public static Tile chaireast2 = new ChairEast2(Sprite.chaireast2);
	public static Tile chairwest1 = new ChairWest1(Sprite.chairwest1);
	public static Tile chairwest2 = new ChairWest2(Sprite.chairwest2);
	public static Tile chairnorth1 = new ChairNorth1(Sprite.chairnorth1);
	public static Tile chairnorth2 = new ChairNorth2(Sprite.chairnorth2);
	public static Tile chairsouth1 = new ChairSouth1(Sprite.chairsouth1);
	public static Tile chairsouth2 = new ChairSouth2(Sprite.chairsouth2);
	public static Tile brickwallnorth = new BrickWallNorth(Sprite.brickwallnorth);
	public static Tile brickwallsouth = new BrickWallSouth(Sprite.brickwallsouth);
	public static Tile brickwalleast = new BrickWallEast(Sprite.brickwalleast);
	public static Tile brickwallwest = new BrickWallWest(Sprite.brickwallwest);
	public static Tile southwestwall = new SouthEastWall(Sprite.southwestwall);
	public static Tile southeastwall = new SouthWestwall(Sprite.southeastwall);
	public static Tile bed = new bed(Sprite.bed);
	public static Tile bed1 = new bed1(Sprite.bed1);
	public static Tile table = new Table(Sprite.table);
	public static Tile table1 = new Table1(Sprite.table1);
	public static Tile table2 = new Table2(Sprite.table2);
	public static Tile table3 = new Table3(Sprite.table3);
	public static Tile armorrack = new ArmorRack(Sprite.armorrack);
	public static Tile armorrack1 = new ArmorRack1(Sprite.armorrack1);

	
	
	public IndoorTiles(Sprite sprite) {

		super(sprite);
		// TODO Auto-generated constructor stub
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
		return true;
	}

}
