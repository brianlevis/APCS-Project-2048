package com.brian.TFE.graphics;

public class Colors {

	private String[] names = { "BACKGROUND", "GRID", "GRID_CELL", "SCORE", "NEW_GAME", "TRY_AGAIN", "DARK_FONT",
			"MEDIUM_FONT", "LIGHT_FONT", "TILE_2", "TILE_4", "TILE_8", "TILE_16", "TILE_32", "TILE_64", "TILE_128",
			"TILE_256", "TILE_512", "TILE_1024", "TILE_2048" };
	private int[] colors = { 0, 0xff776e65, 0xffbbada0, 0, 0xff8f7a66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public Colors() {
	}

	//    WARNING:  SEARCH ALGORITHM   
	// --------------------------------
	// TO BE CALLED IN CONSTRUCTOR ONLY
	// --------------------------------
	// ELSEWHERE ACCESS STRING DIRECTLY

	public int getColor(String object) {
		for (int i = 0; i < names.length; i++)
			if (names[i].equals(object)) return colors[i];
		return 0xffff00ff;
	}
	
	public int getColor(int index){
		return colors[index];
	}

}
