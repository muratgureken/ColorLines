package database;

import java.awt.Color;

public class GameParameters {
	private int[][] boundaries5x5;
	private int[][] boundaries6x6;
	Color[] colors = new Color[6];
	
	public GameParameters() {
		boundaries5x5 = new int[20][11];
		boundaries6x6 = new int[20][13];

		colors[0] = Color.BLUE;
		colors[1] = Color.RED;
		colors[2] = Color.YELLOW;
		colors[3] = Color.GREEN;
		colors[4] = Color.CYAN;
		colors[5] = Color.ORANGE;

		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[1][0] = 4;
		boundaries5x5[1][1] = 0;
		boundaries5x5[1][2] = 19;
		boundaries5x5[1][3] = 12;
		boundaries5x5[1][4] = 16;
		boundaries5x5[1][5] = 15;
		boundaries5x5[1][6] = 24;
		boundaries5x5[1][7] = 17;
		boundaries5x5[1][8] = 20;
		
		boundaries5x5[2][0] = 5;
		boundaries5x5[2][1] = 1;
		boundaries5x5[2][2] = 15;
		boundaries5x5[2][3] = 2;
		boundaries5x5[2][4] = 20;
		boundaries5x5[2][5] = 3;
		boundaries5x5[2][6] = 23;
		boundaries5x5[2][7] = 8;
		boundaries5x5[2][8] = 12;
		boundaries5x5[2][9] = 18;
		boundaries5x5[2][10] = 22;

		boundaries5x5[3][0] = 4;
		boundaries5x5[3][1] = 3;
		boundaries5x5[3][2] = 5;
		boundaries5x5[3][3] = 4;
		boundaries5x5[3][4] = 20;
		boundaries5x5[3][5] = 12;
		boundaries5x5[3][6] = 22;
		boundaries5x5[3][7] = 18;
		boundaries5x5[3][8] = 21;
		
		boundaries5x5[4][0] = 4;
		boundaries5x5[4][1] = 3;
		boundaries5x5[4][2] = 22;
		boundaries5x5[4][3] = 4;
		boundaries5x5[4][4] = 8;
		boundaries5x5[4][5] = 6;
		boundaries5x5[4][6] = 24;
		boundaries5x5[4][7] = 7;
		boundaries5x5[4][8] = 19;
		
		boundaries5x5[5][0] = 4;
		boundaries5x5[5][1] = 0;
		boundaries5x5[5][2] = 24;
		boundaries5x5[5][3] = 2;
		boundaries5x5[5][4] = 16;
		boundaries5x5[5][5] = 3;
		boundaries5x5[5][6] = 19;
		boundaries5x5[5][7] = 4;
		boundaries5x5[5][8] = 13;
		
		boundaries5x5[6][0] = 4;
		boundaries5x5[6][1] = 0;
		boundaries5x5[6][2] = 13;
		boundaries5x5[6][3] = 3;
		boundaries5x5[6][4] = 10;
		boundaries5x5[6][5] = 5;
		boundaries5x5[6][6] = 12;
		boundaries5x5[6][7] = 16;
		boundaries5x5[6][8] = 18;
		
		boundaries5x5[7][0] = 5;
		boundaries5x5[7][1] = 0;
		boundaries5x5[7][2] = 21;
		boundaries5x5[7][3] = 3;
		boundaries5x5[7][4] = 16;
		boundaries5x5[7][5] = 4;
		boundaries5x5[7][6] = 17;
		boundaries5x5[7][7] = 8;
		boundaries5x5[7][8] = 12;
		boundaries5x5[7][9] = 19;
		boundaries5x5[7][10] = 22;
		
		boundaries5x5[8][0] = 4;
		boundaries5x5[8][1] = 3;
		boundaries5x5[8][2] = 22;
		boundaries5x5[8][3] = 6;
		boundaries5x5[8][4] = 12;
		boundaries5x5[8][5] = 7;
		boundaries5x5[8][6] = 20;
		boundaries5x5[8][7] = 8;
		boundaries5x5[8][8] = 21;
		
		boundaries5x5[9][0] = 4;
		boundaries5x5[9][1] = 5;
		boundaries5x5[9][2] = 24;
		boundaries5x5[9][3] = 8;
		boundaries5x5[9][4] = 11;
		boundaries5x5[9][5] = 10;
		boundaries5x5[9][6] = 12;
		boundaries5x5[9][7] = 13;
		boundaries5x5[9][8] = 20;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[0][0] = 5;
		boundaries5x5[0][1] = 0;
		boundaries5x5[0][2] = 21;
		boundaries5x5[0][3] = 2;
		boundaries5x5[0][4] = 16;
		boundaries5x5[0][5] = 4;
		boundaries5x5[0][6] = 18;
		boundaries5x5[0][7] = 7;
		boundaries5x5[0][8] = 22;
		boundaries5x5[0][9] = 9;
		boundaries5x5[0][10] = 23;
		
		boundaries5x5[19][0] = 4;
		boundaries5x5[19][1] = 0;
		boundaries5x5[19][2] = 17;
		boundaries5x5[19][3] = 2;
		boundaries5x5[19][4] = 12;
		boundaries5x5[19][5] = 3;
		boundaries5x5[19][6] = 18;
		boundaries5x5[19][7] = 4;
		boundaries5x5[19][8] = 5;

	}
}
