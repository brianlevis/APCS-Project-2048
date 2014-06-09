package com.brian.TFE.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import com.brian.TFE.graphics.Screen;

public class Tile {

	public static List<Tile> tiles = new ArrayList<Tile>();

	public int[] pixels; // Not a 2D array because yolo

	private final int radius = 5;

	public String name;
	public int height, width, color;
	public int xPosition, yPosition;

	protected int xTrail, yTrail;

	private double xVelocity, yVelocity;

	// for some reason this causes an ArrayIndexOutOfBoundsException if set to 5
	private final static double acceleration = 4.5;

	public Tile() {
	}

	@SuppressWarnings("unused")
	public Tile(int height, int width, int xPosition, int yPosition, int color, String name) {
		tiles.add(this);
		this.height = height;
		this.width = width;
		this.color = color;
		this.name = name;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.xTrail = xPosition;
		this.yTrail = yPosition;

		pixels = new int[height * width];

		for (int i = 0; i < pixels.length; i++)
			pixels[i] = color;

		if (true) // for some reason this only works with squares- not sure why 
		for (int i = 0; i < pixels.length; i++)
			if (Math.abs(i / height - height / 2) >= height / 2 - radius
					&& Math.abs(i % width - width / 2) >= width / 2 - radius
					&& Math.sqrt(Math.pow((Math.abs(height / 2 - i / height) - (height / 2 - radius)), 2)
							+ Math.pow((Math.abs(width / 2 - i % height) - (width / 2 - radius)), 2)) > radius) pixels[i] = 0xffff00ff;
			else pixels[i] = color;

		// still does not render rectangles but at least with this one failed renders are recognizable
		else {
			for (int i = 0; i < pixels.length; i++)
				pixels[i] = 0xFFFF00FF;

			for (int i = 0; i < pixels.length; i++)
				for (int j = 0; j < width; j++)
					if (i >= 9 + (width * j) && i <= (width - 10) + (width * j)) pixels[i] = color;

			for (int i = width * 9; i < pixels.length - (width * 4); i++)
				for (int j = 0; j < width - 8; j++)
					if (i <= width * j + 8 && i <= width * j - 1) pixels[i] = color;

			for (int i = width; i < pixels.length - width + 1; i++)
				for (int j = 0; j < width; j++)
					if (i >= 5 + (width * j) && i <= (width - 6) + (width * j)) pixels[i] = color;

			for (int i = width * 2; i < pixels.length - width * 2 + 1; i++)
				for (int j = 0; j < width; j++)
					if (i >= 3 + (width * j) && i <= (width - 4) + (width * j)) pixels[i] = color;

			for (int i = width * 3; i < pixels.length - width * 3 + 1; i++)
				for (int j = 0; j < width; j++)
					if (i >= 2 + (width * j) && i <= (width - 3) + (width * j)) pixels[i] = color;

			for (int i = width * 5; i < pixels.length - width * 5 + 1; i++)
				for (int j = 0; j < width; j++)
					if (i >= 1 + (width * j) && i <= (width - 2) + (width * j)) pixels[i] = color;
		} /*
		 * Debugger System.out.print(text + ":"); for(int y = 0; y < height;
		 * y++){ for(int x = 0; x < width; x++) System.out.print(pixels[width *
		 * y + x] + " "); System.out.println(""); } System.out.println("");
		 */
	}

	public static void update() {
		for (Tile tile : tiles) {
			if (tile.xTrail > tile.xPosition) {
				if (tile.xVelocity > 0) tile.xVelocity = 0;
				else tile.xVelocity -= acceleration;
			}
			if (tile.xTrail < tile.xPosition) {
				if (tile.xVelocity < 0) tile.xVelocity = 0;
				else tile.xVelocity += acceleration;
			}
			if (tile.yTrail > tile.yPosition) {
				if (tile.yVelocity > 0) tile.yVelocity = 0;
				else tile.yVelocity -= acceleration;
			}
			if (tile.yTrail < tile.yPosition) {
				if (tile.yVelocity < 0) tile.yVelocity = 0;
				else tile.yVelocity += acceleration;
			}
			if (tile.xVelocity == 0) tile.xTrail = tile.xPosition;
			else tile.xTrail += tile.xVelocity;

			if (tile.yVelocity == 0) tile.yTrail = tile.yPosition;
			else tile.yTrail += tile.yVelocity;
		}
	}

	public static void render(Screen screen) {
		for (Tile tile : tiles)
			screen.renderTile(tile.xTrail, tile.yTrail, tile);
	}

	public void setPosition(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

}