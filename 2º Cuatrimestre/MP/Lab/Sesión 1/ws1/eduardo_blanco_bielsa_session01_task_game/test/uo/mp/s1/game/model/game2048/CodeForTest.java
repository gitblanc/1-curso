package uo.mp.s1.game.model.game2048;

public class CodeForTest {
	
	public static int[][] SEMIFULL11 = {{0,2,0},{0,2,0},{0,2,0}};
	public static int[][] SEMIFULL12 = {{2,0,0},{2,0,0},{2,0,0}};
	public static int[][] SEMIFULL13 = {{0,0,2},{0,0,2},{0,0,2}};
	public static int[][] SEMIFULL1_RIGHTCOMPACTED = {{0,0,2},{0,0,2},{0,0,2}};
	public static int[][] SEMIFULL1_LEFTCOMPACTED = {{2,0,0},{2,0,0},{2,0,0}};
	
	public static int[][] SEMIFULL21 = {{0,2,2},{0,2,2},{0,2,2}};
	public static int[][] SEMIFULL22 = {{2,2,0},{2,2,0},{2,2,0}};
	public static int[][] SEMIFULL23 = {{2,0,2},{2,0,2},{2,0,2}};
	public static int[][] SEMIFULL2_RIGHTCOMPACTED = {{0,2,2},{0,2,2},{0,2,2}};
	public static int[][] SEMIFULL2_LEFTCOMPACTED = {{2,2,0},{2,2,0},{2,2,0}};
	
	public static int[][] FULL = {{2,2,2},{2,2,2},{2,2,2}};
	public static int[][] EMPTY = {{0,0,0},{0,0,0},{0,0,0}};
		
	public static int[][] SEMIFULL31 = {{0,0,0},{0,0,0},{2,2,2}};
	public static int[][] SEMIFULL32 = {{0,0,0},{2,2,2},{0,0,0}};
	public static int[][] SEMIFULL33 = {{2,2,2},{0,0,0},{0,0,0}};
	public static int[][] SEMIFULL3_UPCOMPACTED = {{2,2,2},{0,0,0},{0,0,0}};
	public static int[][] SEMIFULL3_DOWNCOMPACTED = {{0,0,0},{0,0,0},{2,2,2}};
	
	public static int[][] SEMIFULL41 = {{0,0,0},{2,2,2},{2,2,2}};
	public static int[][] SEMIFULL42 = {{2,2,2},{0,0,0},{2,2,2}};
	public static int[][] SEMIFULL43 = {{2,2,2},{2,2,2},{0,0,0}};
	public static int[][] SEMIFULL4_UPCOMPACTED = {{2,2,2},{2,2,2},{0,0,0}};
	public static int[][] SEMIFULL4_DOWNCOMPACTED = {{0,0,0},{2,2,2},{2,2,2}};
	
	public static int getSum(int[][] matrix) {
		int cont = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				cont = cont + matrix[i][j];
		return cont;
	}

}
