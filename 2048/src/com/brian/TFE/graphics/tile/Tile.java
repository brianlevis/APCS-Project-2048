package com.brian.TFE.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import com.brian.TFE.graphics.Screen;

public class Tile {

	public static List<Tile> tiles = new ArrayList<Tile>();

	public int[] pixels; // Not a 2D array because yolo

	public String text;
	public int height, width, color, up, low, rw, rwt, arbnum, arbnumt;
	public int xPosition, yPosition;

	public Tile() {
	}

	public Tile(int height, int width, int color, String text) {
		tiles.add(this);
		this.height = height;
		this.width = width;
		this.color = color;
		this.text = text;
		pixels = new int[height * width];

		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0xFFFF00FF;

		for (int i = 0; i < pixels.length; i++)
			for (int j = 0; j < width; j++)
				if (i >= 7 + (width * j) && i <= 93 + (width * j)) pixels[i] = color;

		for (int i = 0; i < pixels.length; i++)
			for (int j = 0; j < height; j++)
				if (i <= width * 8 && i <= width * 92) pixels[i] = color;

		for (int i = width; i < pixels.length - width; i++)
			for (int j = 0; j < width; j++)
				if (i >= 5 + (width * j) && i <= 95 + (width * j)) pixels[i] = color;

		for (int i = width * 2; i < pixels.length - width * 2; i++)
			for (int j = 0; j < width; j++)
				if (i >= 3 + (width * j) && i <= 97 + (width * j)) pixels[i] = color;

		for (int i = width * 3; i < pixels.length - width * 3; i++)
			for (int j = 0; j < width; j++)
				if (i >= 2 + (width * j) && i <= 98 + (width * j)) pixels[i] = color;

		for (int i = width * 5; i < pixels.length - width * 5; i++)
			for (int j = 0; j < width; j++)
				if (i >= 1 + (width * j) && i <= 99 + (width * j)) pixels[i] = color;

	}

	public static void render(Screen screen) {
		for (Tile tile : tiles)
			screen.renderTile(tile.xPosition, tile.yPosition, tile);
	}
}
