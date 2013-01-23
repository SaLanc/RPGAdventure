package com.SaL.CaveScroll.graphics;




public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite VoidSprite = new Sprite(16, 0x1B87E0);
	public static Sprite brick = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite sky = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite sky2 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite sky3 = new Sprite(16, 3, 0, SpriteSheet.tiles);
	
	public static Sprite PlayerStill_1= new Sprite(32,0,1,SpriteSheet.tiles);
	public static Sprite PlayerStill_2= new Sprite(32,0,2,SpriteSheet.tiles);


	public Sprite(int size, int x, int y, SpriteSheet sheet) {

		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {

		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);

	}

	private void setColor(int color) {

		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;

		}
	}

	private void load() {

		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}