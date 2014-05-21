package com.brian.TFE.graphics;

import com.brian.TFE.graphics.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	//private Tile NUMBER_TILE;

	public Screen(int width, int height) { 
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		clear();
		/*
		 * for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) { tiles[i] =
		 * random.nextInt(0xffffff); tiles[0] = 0; }
		 */

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0xff000000;

	}

	public void renderTile(int xPosition, int yPosition, Tile tile) {
		int height = tile.height;
		int width = tile.width;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int col = tile.pixels[width * y + x];
				if (col != 0xffff00ff) pixels[this.width * (yPosition + y) + xPosition + x] = col;
			}
		}
	}

}
