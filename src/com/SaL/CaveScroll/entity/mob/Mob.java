package com.SaL.CaveScroll.entity.mob;

import com.SaL.CaveScroll.entity.Entity;
import com.SaL.CaveScroll.graphics.Sprite;
import com.SaL.CaveScroll.level.Level;
import com.SaL.CaveScroll.level.tile.Tile;


public abstract class Mob extends Entity{
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	public int topL,topR,botL,botR;
	public void move(int xa, int ya) {

		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		botR = (((x+xa)>>4)+Level.xSpawn)+(((y+ya+14)>>4)+Level.ySpawn)*Level.width;
		botL = (((x+xa-30)>>4)+Level.xSpawn)+(((y+ya+14)>>4)+Level.ySpawn)*Level.width;
		topR = (((x+xa)>>4)+Level.xSpawn)+(((y+ya-14)>>4)+Level.ySpawn)*Level.width;
		topL = (((x+xa-30)>>4)+Level.xSpawn)+(((y+ya-14)>>4)+Level.ySpawn)*Level.width;

		if (!collision()) {
			x += xa;
			y += ya;
//			System.out.println("moved");
		}
	}

	public void update() {

	}

	private boolean collision() {
		if (Level.solids[botR]||Level.solids[botL]||Level.solids[topR]||Level.solids[topL]){
			System.out.println("solid");
			return true;
		} else {
			System.out.println("air");
		}
		return false;
//		
	}
//		System.out.println(((xa/16) + Level.xSpawn) + "xa, " + ((ya/16)+ Level.ySpawn) + " ya");
//		return false ;

	

	public void render() {

	}

}
