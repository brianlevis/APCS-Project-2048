package com.brian.TFE.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import com.brian.TFE.graphics.Screen;

public class Tile {

	public static List<Tile> tiles = new ArrayList<Tile>();

	public int[] pixels; // Not a 2D array because yolo

	public String name;
	public int height, width, color;
	public int xPosition, yPosition;

	public Tile() {
	}

	public Tile(int height, int width, int xPosition, int yPosition, int color, String name) {
		tiles.add(this);
		this.height = height;
		this.width = width;
		this.color = color;
		this.name = name;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		
		pixels = new int[height * width];

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
		
		/*   Debugger
		System.out.print(text + ":");
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++)
				System.out.print(pixels[width * y + x] + " ");
			System.out.println("");
		}
		System.out.println("");
		*/
	}
	
	public void setPosition(int xPosition, int yPosition){
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public static void render(Screen screen) {
		for (Tile tile : tiles)
			screen.renderTile(tile.xPosition, tile.yPosition, tile);
	}
}
