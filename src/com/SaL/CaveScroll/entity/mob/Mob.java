package com.SaL.CaveScroll.entity.mob;

import com.SaL.CaveScroll.entity.Entity;
import com.SaL.CaveScroll.graphics.Sprite;
import com.SaL.CaveScroll.level.Level;
import com.SaL.CaveScroll.level.tile.Tile;


public abstract class Mob extends Entity{
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean hit = false;

	public void move(int xa, int ya) {

		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		xp = x+xa;
		yp = y+ya;

		if (!collision(xp,xp)) {
			x += xa;
			y += ya;
			System.out.println("moved");
		}
	}

	public void update() {

	}

	private boolean collision(int xa,int ya) {
		if (Level.tiles[((xa/16) + Level.xSpawn)+ ((ya/16)+ Level.ySpawn)*64] == 0xFFA0A0A0){
			System.out.println("true " + ((xa/16) + Level.xSpawn)+ ((ya/16)+ Level.ySpawn)*16);
			return true;
		} else {
			return false;
		}
	}
//		System.out.println(((xa/16) + Level.xSpawn) + "xa, " + ((ya/16)+ Level.ySpawn) + " ya");
//		return false ;

	

	public void render() {

	}

}
