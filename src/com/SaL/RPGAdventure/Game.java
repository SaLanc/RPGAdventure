package com.SaL.RPGAdventure;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.SaL.RPGAdventure.entity.mob.Player;
import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.input.KeyBoard;
import com.SaL.RPGAdventure.level.Level;
//import com.SaL.RPGAdventure.level.World1;
import com.SaL.RPGAdventure.level.map.SpawnHouse;

public class Game extends Canvas implements Runnable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = 168;
	public static int scale = 3;
	public static String title = "CaveScroll";

	private Thread thread;
	private JFrame frame;
	private KeyBoard key;
	private Level level;
	private Player player;
	//	private Entity entities;
	private boolean running = false;
	private Screen screen;
	public static boolean qtick = false;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {

		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new KeyBoard();
		level = new SpawnHouse("/textures/maps/spawnroom.png");
		player = new Player(key);
		//	entities = new Entity();

		addKeyListener(key);
	}

	public synchronized void start() {

		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 90.0;
		long ticktimenow = System.currentTimeMillis();
		long ticktimer =0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
		//	level.update(screen);
			frames++;
			ticktimenow = System.currentTimeMillis();
			if (ticktimenow - ticktimer  > 500) {
				ticktimer = System.currentTimeMillis();
			}
		qtick =ticktimenow - ticktimer > 250;


			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + "ups, " + +frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll = player.x - (screen.width / 2);
		int yScroll = player.y - (screen.height / 2);

		level.render(xScroll, yScroll, screen);
		player.render(screen);
		level.overrender(xScroll, yScroll, screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	private void update() {

		key.update();
		player.update();


	}

	public static void main(String[] args) {

		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();

	}

}
