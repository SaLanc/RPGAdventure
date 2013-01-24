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
//	private boolean falling = false;
	private int xa = 0, ya = 0;
	private int jumpCooldown = 0;

	public Player(KeyBoard input) {

		this.input = input;
		sprite = Sprite.PlayerStill_1;
		this.x += Level.xSpawn << 4;
		this.y += Level.ySpawn << 4;
		move(xa, ya);

	}

	public void jump() {

		if (input.up) {
			V = 50;
		}

		if (V > 0) ya = 0;
		if (V > 30) {
			ya--;
		}

		if (V > 0) {
			ya--;
			V--;
			System.out.println(jumpCooldown + " " + V);
		}

	}

	public void update() {

		xa = 0;
		ya = 0;
		if (anim < 90) anim++;
		else anim = 0;
		if (falling()){
			y++;
//			falling = true;
		}
		if (!falling()) jump();

//		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
//			falling = false;
		}
	}

	public void render(Screen screen) {

		sprite = Sprite.PlayerStill_1;
		if (!walking) {
			if (anim > 45) {
				sprite = Sprite.PlayerStill_1;
			} else {
				sprite = Sprite.PlayerStill_2;
			}
		}
		screen.renderPlayer(x - 32, y - 16, sprite);
	}
}
