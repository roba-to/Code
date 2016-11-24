import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**	SudokuSolve is a method that can solve "easy" Sudokus.
 * 
 * @author Robert Campbell
 * @created 2016-11-24
 */
public class SudokuSolve extends Sudoku{
	
	public SudokuSolve(int[][] array) {
		super(array);
	}
	
	
	public void solve() {
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(toString());
		int[][] row = new int[9][9];
		int[] column = new int[9];
		int boxRow, boxColumn, boxNumber, counter;
		ArrayList<Integer> possible = new ArrayList<Integer>();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				row[i][j] = getArray()[i][j];
			}
			System.out.println(Arrays.toString(row[i]));
		}
		
			
		
//		System.out.println("Rows");
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				if (getArray()[i][j] != 0) {
//					System.out.print(getArray()[i][j]);
//				}
//			}
//			System.out.print("\n");
//		}
//		System.out.println("\nColumns");
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				if (getArray()[j][i] != 0) {
//					System.out.print(getArray()[j][i]);
//				}
//			}
//			System.out.print("\n");
//		}

//		System.out.println("\nBoxes");
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				boxRow = i/3;
//				boxColumn = j/3;
//				boxNumber = 3*(i/3) + (j/3);
//				counter = (i*3) + j - (boxRow*9 + boxColumn*3);
//				if (boxNumber == 8 && getArray()[i][j] != 0) {
//					System.out.println("Box " + boxNumber + " ( " + getArray()[i][j] + ")");
//				}
//			}
//		}
	}
	
	
	
	public static void main(String[] args) {
		try {
			SudokuSolve test = new SudokuSolve(SudokuRead.readSudoku("sudoku-ex1.txt").getArray());
			
			test.solve();
		} catch (IOException e) {
			
		}
	}
}