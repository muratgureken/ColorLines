package database;

import java.awt.Color;
import java.util.LinkedList;

public class GameParameters {
	private int[][] boundaries5x5;
	private int[][] boundaries6x6;
	private LinkedList<Color> colors=new LinkedList<Color>();
	
	public int getBoundaries5x5(int i, int j) {
		return boundaries5x5[i][j];
	}

	public int getBoundaries6x6(int i, int j) {
		return boundaries6x6[i][j];
	}

	public LinkedList<Color> getColors() {
		return colors;
	}

	public void setColors(LinkedList<Color> colors) {
		this.colors = colors;
	}

	public GameParameters() {
		boundaries5x5 = new int[20][11];
		boundaries6x6 = new int[20][13];
                
		colors.add(Color.BLUE);
		colors.add(Color.RED);
		colors.add(Color.YELLOW);
		colors.add(Color.GREEN);
		colors.add(Color.CYAN);
		colors.add(Color.ORANGE);
                
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
		
		boundaries5x5[10][0] = 4;
		boundaries5x5[10][1] = 0;
		boundaries5x5[10][2] = 11;
		boundaries5x5[10][3] = 1;
		boundaries5x5[10][4] = 21;
		boundaries5x5[10][5] = 2;
		boundaries5x5[10][6] = 24;
		boundaries5x5[10][7] = 12;
		boundaries5x5[10][8] = 20;
		
		boundaries5x5[11][0] = 5;
		boundaries5x5[11][1] = 3;
		boundaries5x5[11][2] = 10;
		boundaries5x5[11][3] = 4;
		boundaries5x5[11][4] = 8;
		boundaries5x5[11][5] = 7;
		boundaries5x5[11][6] = 16;
		boundaries5x5[11][7] = 15;
		boundaries5x5[11][8] = 19;
		boundaries5x5[11][9] = 18;
		boundaries5x5[11][10] = 24;
		
		boundaries5x5[12][0] = 5;
		boundaries5x5[12][1] = 0;
		boundaries5x5[12][2] = 18;
		boundaries5x5[12][3] = 1;
		boundaries5x5[12][4] = 3;
		boundaries5x5[12][5] = 4;
		boundaries5x5[12][6] = 12;
		boundaries5x5[12][7] = 10;
		boundaries5x5[12][8] = 23;
		boundaries5x5[12][9] = 13;
		boundaries5x5[12][10] = 24;
		
		boundaries5x5[13][0] = 5;
		boundaries5x5[13][1] = 2;
		boundaries5x5[13][2] = 10;
		boundaries5x5[13][3] = 3;
		boundaries5x5[13][4] = 20;
		boundaries5x5[13][5] = 4;
		boundaries5x5[13][6] = 19;
		boundaries5x5[13][7] = 13;
		boundaries5x5[13][8] = 21;
		boundaries5x5[13][9] = 18;
		boundaries5x5[13][10] = 24;
		
		boundaries5x5[14][0] = 4;
		boundaries5x5[14][1] = 0;
		boundaries5x5[14][2] = 12;
		boundaries5x5[14][3] = 1;
		boundaries5x5[14][4] = 22;
		boundaries5x5[14][5] = 7;
		boundaries5x5[14][6] = 21;
		boundaries5x5[14][7] = 10;
		boundaries5x5[14][8] = 20;
		
		boundaries5x5[15][0] = 4;
		boundaries5x5[15][1] = 5;
		boundaries5x5[15][2] = 16;
		boundaries5x5[15][3] = 6;
		boundaries5x5[15][4] = 8;
		boundaries5x5[15][5] = 10;
		boundaries5x5[15][6] = 24;
		boundaries5x5[15][7] = 17;
		boundaries5x5[15][8] = 19;
		
		boundaries5x5[16][0] = 4;
		boundaries5x5[16][1] = 0;
		boundaries5x5[16][2] = 4;
		boundaries5x5[16][3] = 6;
		boundaries5x5[16][4] = 8;
		boundaries5x5[16][5] = 7;
		boundaries5x5[16][6] = 16;
		boundaries5x5[16][7] = 9;
		boundaries5x5[16][8] = 23;
		
		boundaries5x5[17][0] = 4;
		boundaries5x5[17][1] = 6;
		boundaries5x5[17][2] = 21;
		boundaries5x5[17][3] = 8;
		boundaries5x5[17][4] = 12;
		boundaries5x5[17][5] = 17;
		boundaries5x5[17][6] = 20;
		boundaries5x5[17][7] = 19;
		boundaries5x5[17][8] = 22;
		
		boundaries5x5[18][0] = 4;
		boundaries5x5[18][1] = 5;
		boundaries5x5[18][2] = 22;
		boundaries5x5[18][3] = 6;
		boundaries5x5[18][4] = 8;
		boundaries5x5[18][5] = 13;
		boundaries5x5[18][6] = 15;
		boundaries5x5[18][7] = 18;
		boundaries5x5[18][8] = 20;
		
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
