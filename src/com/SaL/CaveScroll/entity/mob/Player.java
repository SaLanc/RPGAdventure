package com.SaL.CaveScroll.entity.mob;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.graphics.Sprite;
import com.SaL.CaveScroll.input.KeyBoard;
//import com.SaL.CaveScroll.level.tile.Tile;
import com.SaL.CaveScroll.level.Level;

public class Player extends Mob {

	private KeyBoard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	public Player(KeyBoard input) {

		this.input = input;
		sprite = Sprite.PlayerStill_1;
		this.x += Level.xSpawn<<4;
		this.y += Level.ySpawn<<4;

	}

	public void update() {

		int xa = 0, ya = 0;
		if (anim < 60) anim++;
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa++;
		if (input.right) xa--;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	public void render(Screen screen) {
		sprite = Sprite.PlayerStill_1;
		if (!walking) {
			if (anim > 30) {
				sprite = Sprite.PlayerStill_1;
			} else {
				sprite = Sprite.PlayerStill_2;
			}
		}
		screen.renderPlayer(x-32, y-16, sprite);
	}
}
