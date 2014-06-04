package com.brian.TFE.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import com.brian.TFE.GameManager;
import com.brian.TFE.graphics.Colors;

public class NumberTile extends Tile {

	public static List<NumberTile> numberTiles = new ArrayList<NumberTile>();

	public int xPosition, yPosition, number;

	public NumberTile(int xPosition, int yPosition, int number) {
		super(GameManager.TILE_SIZE, GameManager.TILE_SIZE, xPosition * (GameManager.TILE_SIZE + GameManager.TILE_GAP)
				+ GameManager.xOffset, yPosition * (GameManager.TILE_SIZE + GameManager.TILE_GAP) + GameManager.yOffset,
				Colors.getColor("TILE_" + Integer.toString(number)), "TILE_" + Integer.toString(number));
		int n = -1;
		if (numberTiles.isEmpty()) n = 0;
		else do
			n++;
		while (numberTiles.get(n).yPosition * 4 + numberTiles.get(n).xPosition > yPosition * 4 + xPosition
				&& n < numberTiles.size() - 1);

		numberTiles.add(n, this);
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.number = number;
	}
}
