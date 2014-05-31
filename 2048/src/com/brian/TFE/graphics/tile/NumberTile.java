package com.brian.TFE.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import com.brian.TFE.GameManager;
import com.brian.TFE.graphics.Colors;

public class NumberTile extends Tile{
	
	public static List<NumberTile> numberTiles = new ArrayList<NumberTile>();
	
	public int xGrid, yGrid;
	
	public NumberTile(int xPosition, int yPosition, int xGrid, int yGrid, int number) {
		super(GameManager.TILE_SIZE, GameManager.TILE_SIZE, xPosition, yPosition, Colors.getColor("TILE_" + Integer.toString(number)), "TILE_" + Integer.toString(number));
		numberTiles.add(this);
		this.xGrid = xGrid;
		this.yGrid = yGrid;
	}
	
	public void setPosition(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
}
