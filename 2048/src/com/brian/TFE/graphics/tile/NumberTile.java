package com.brian.TFE.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import com.brian.TFE.GameManager;
import com.brian.TFE.graphics.Colors;

public class NumberTile extends Tile{
	
	public static List<NumberTile> numberTiles = new ArrayList<NumberTile>();
	
	public int xPosition, yPosition, number;
	
	public NumberTile(int xGrid, int yGrid, int number) {
		super(GameManager.TILE_SIZE, GameManager.TILE_SIZE, xGrid * (GameManager.TILE_SIZE + GameManager.TILE_GAP) + GameManager.xOffset, xGrid * (GameManager.TILE_SIZE + GameManager.TILE_GAP) + GameManager.yOffset, Colors.getColor("TILE_" + Integer.toString(number)), "TILE_" + Integer.toString(number));
		numberTiles.add(this);
		this.xPosition = xGrid;
		this.yPosition = yGrid;
		this.number = number;
	}
}
