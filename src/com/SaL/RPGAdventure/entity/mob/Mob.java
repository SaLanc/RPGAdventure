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
		centerYa = ((y + (ya*7)) >> 4);
		centerY = (y >> 4);
		footCheck = ((y+5)>>4);
		XfootLeft = ((x+5)>>4);
		XfootRight= ((x-5)>>4);
		collisioncheck(xa, ya);

	}

	public void update() {

	}

	public void collisioncheck(int xa, int ya) {

		// X check
		if (!Level.world[centerXa][centerY].solid()& !Level.world[centerXa][footCheck].solid()) {
			x += xa;
		}
		// Y check
		if (!Level.world[centerX][centerYa].solid()& !Level.world[XfootRight][centerY].solid()& !Level.world[XfootRight][centerY].solid()) {
			y += ya;
		}
	}

	public void render() {

	}

}
