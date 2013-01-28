package com.SaL.RPGAdventure.graphics;




public class Sprite {
	
	public final int SIZEY,SIZEX;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite VoidSprite = new Sprite(16, 0x000000);
	public static Sprite brick = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite sky = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite sky2 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite sky3 = new Sprite(16, 3, 0, SpriteSheet.tiles);
	
	public static Sprite PlayerNorth= new Sprite(16,18,0,0,SpriteSheet.tiles);
	public static Sprite PlayerNorth1= new Sprite(16,18,1,0,SpriteSheet.tiles);
	public static Sprite PlayerNorth2= new Sprite(16,18,2,0,SpriteSheet.tiles);
	public static Sprite PlayerEast= new Sprite(16,18,0,1,SpriteSheet.tiles);
	public static Sprite PlayerEast1= new Sprite(16,18,1,1,SpriteSheet.tiles);
	public static Sprite PlayerEast2= new Sprite(16,18,2,1,SpriteSheet.tiles);	
	public static Sprite PlayerSouth= new Sprite(16,18,0,2,SpriteSheet.tiles);
	public static Sprite PlayerSouth1= new Sprite(16,18,1,2,SpriteSheet.tiles);
	public static Sprite PlayerSouth2= new Sprite(16,18,2,2,SpriteSheet.tiles);
	public static Sprite PlayerWest= new Sprite(16,18,0,3,SpriteSheet.tiles);
	public static Sprite PlayerWest1= new Sprite(16,18,1,3,SpriteSheet.tiles);
	public static Sprite PlayerWest2= new Sprite(16,18,2,3,SpriteSheet.tiles);
	public static Sprite torch = new Sprite(16,3,5,SpriteSheet.indoortiles);
	public static Sprite torch1 = new Sprite(16,3,5,SpriteSheet.indoortiles);



	//indoor tiles
	
											// (size,x,y)
	public static Sprite woodfloor = new Sprite(16,6,0,SpriteSheet.indoortiles);
	public static Sprite chaireast1 = new Sprite(16,6,0,SpriteSheet.indoortiles);
	public static Sprite chaireast2 = new Sprite(16,6,0,SpriteSheet.indoortiles);
	public static Sprite chairwest1 = new Sprite(16,2,2,SpriteSheet.indoortiles);
	public static Sprite chairwest = new Sprite(16,2,3,SpriteSheet.indoortiles);
	public static Sprite chairnorth1 = new Sprite(16,6,0,SpriteSheet.indoortiles);
	public static Sprite chairnorth2 = new Sprite(16,6,0,SpriteSheet.indoortiles);
	public static Sprite chairsouth1 = new Sprite(16,1,2,SpriteSheet.indoortiles);
	public static Sprite chairsouth2 = new Sprite(16,1,3,SpriteSheet.indoortiles);
	public static Sprite brickwallnorth = new Sprite(16,1,4,SpriteSheet.indoortiles);
	public static Sprite brickwallsouth = new Sprite(16,1,6,SpriteSheet.indoortiles);
	public static Sprite brickwalleast = new Sprite(16,2,5,SpriteSheet.indoortiles);
	public static Sprite brickwallwest = new Sprite(16,0,5,SpriteSheet.indoortiles);
	public static Sprite southwestwall = new Sprite(16,0,6,SpriteSheet.indoortiles);
	public static Sprite southeastwall = new Sprite(16,2,6,SpriteSheet.indoortiles);
	public static Sprite bed = new Sprite(16,4,4,SpriteSheet.indoortiles);
	public static Sprite bed1 = new Sprite(16,4,5,SpriteSheet.indoortiles);
	public static Sprite table = new Sprite(16,4,2,SpriteSheet.indoortiles);
	public static Sprite table1 = new Sprite(16,5,2,SpriteSheet.indoortiles);
	public static Sprite table2 = new Sprite(16,4,3,SpriteSheet.indoortiles);
	public static Sprite table3 = new Sprite(16,5,3,SpriteSheet.indoortiles);
	public static Sprite armorrack1 = new Sprite(16,3,4,SpriteSheet.indoortiles);
	public static Sprite armorrack = new Sprite(16,3,5,SpriteSheet.indoortiles);
	public static Sprite torchn = new Sprite(16,6,5,SpriteSheet.indoortiles);
	public static Sprite torchn2 = new Sprite(16,6,6,SpriteSheet.indoortiles);
	public static Sprite rug1 = new Sprite(16,0,0,SpriteSheet.indoortiles);
	public static Sprite rug2 = new Sprite(16,1,0,SpriteSheet.indoortiles);
	public static Sprite rug3 = new Sprite(16,2,0,SpriteSheet.indoortiles);
	public static Sprite rug4 = new Sprite(16,0,1,SpriteSheet.indoortiles);
	public static Sprite rug5 = new Sprite(16,1,1,SpriteSheet.indoortiles);
	public static Sprite rug6 = new Sprite(16,2,1,SpriteSheet.indoortiles);




	public Sprite(int size, int x, int y, SpriteSheet sheet) {

		SIZEY = size;
		SIZEX = size;
		pixels = new int[SIZEY * SIZEY];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	public Sprite(int sizeX,int sizeY, int x, int y, SpriteSheet sheet) {

		SIZEY = sizeY;
		SIZEX = sizeX;
		pixels = new int[sizeX*sizeY];
		this.x = x * sizeX;
		this.y = y * sizeY;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {

		SIZEY = size;
		SIZEX = size;
		
		pixels = new int[SIZEY * SIZEY];
		setColor(color);

	}

	private void setColor(int color) {

		for (int i = 0; i < SIZEY * SIZEY; i++) {
			pixels[i] = color;

		}
	}

	private void load() {

		for (int y = 0; y < SIZEY; y++) {
			for (int x = 0; x < SIZEX; x++) {
				pixels[x + y * SIZEX] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
