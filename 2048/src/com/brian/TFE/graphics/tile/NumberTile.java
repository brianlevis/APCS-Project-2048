package com.brian.TFE.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import com.brian.TFE.graphics.Colors;

public class NumberTile extends Tile{
	
	public static List<NumberTile> numberTiles = new ArrayList<NumberTile>();

	public NumberTile(int height, int width, int xPosition, int yPosition, int number) {
		super(height, width, xPosition, yPosition, Colors.getColor("TILE_" + Integer.toString(number)), "TILE_" + Integer.toString(number));
		numberTiles.add(this);
	}
}
