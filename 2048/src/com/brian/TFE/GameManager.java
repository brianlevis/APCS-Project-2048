package com.brian.TFE;

import com.brian.TFE.graphics.tile.NumberTile;
import com.brian.TFE.graphics.tile.ScoreTile;
import com.brian.TFE.graphics.tile.Tile;

public class GameManager {
	
	Tile BACKGROUND_TILE = new Tile();
	Tile VOID_TILE = new Tile();
	Tile MENU_TILE = new Tile();
	
	ScoreTile SCORE_TILE = new ScoreTile();
	ScoreTile BEST_TILE = new ScoreTile();
	
	Tile TWO_TILE = new NumberTile();
	Tile FOUR_TILE = new NumberTile();
	Tile EIGHT_TILE = new NumberTile();
	Tile SIXTEEN_TILE = new NumberTile();
	Tile THIRTY_TWO_TILE = new NumberTile();
	Tile SIXTY_FOUR_TILE = new NumberTile();
	Tile ONE_HUNDRED_TWENTY_EIGHT_TILE = new NumberTile();
	Tile TWO_HUNDRED_FIFTY_SIX_TILE = new NumberTile();
	Tile FIVE_HUNDRED_TWELVE_TILE = new NumberTile();
	Tile ONE_THOUSAND_TWENTY_FOUR_TILE = new NumberTile();
	Tile TWO_THOUSAND_FORTY_EIGHT_TILE = new NumberTile();

	public GameManager() {
	}

}
