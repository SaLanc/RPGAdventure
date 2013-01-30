package com.SaL.RPGAdventure.entity.mob;

import com.SaL.RPGAdventure.entity.Entity;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	public int centerXa, centerYa,footCheck,XfootLeft,XfootRight;

	public void move(int xa, int ya) {

		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		centerX = ((x) >> 4);
		centerXa = ((x + (xa*7) ) >> 4);
		centerYa = ((y + (ya*6)) >> 4);
		centerY = (y >> 4);
		footCheck = ((y+3)>>4);
		XfootLeft = ((x+3)>>4);
		XfootRight= ((x-3)>>4);
		collisioncheck(xa, ya);
System.out.println(centerX +" "+ centerY);
	}

	public void update() {

	}

	public void collisioncheck(int xa, int ya) {

		// X check
		if (!Level.Solids[centerXa][centerY] & !Level.Solids[centerXa][footCheck]) {
			x += xa;
		}
		// Y check
		if (!Level.Solids[centerX][centerYa]& !Level.Solids[XfootRight][centerY]& !Level.Solids[XfootRight][centerY]) {
			y += ya;
		}
	}

	public void render() {

	}

}
