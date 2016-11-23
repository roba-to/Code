import java.util.Arrays;

public class SudokuCheck {
	
	/**	check is a method which takes a Sudoku Puzzle (of type Sudoku) and checks
	 * 	if the rows, columns, and box sectors adhere to the rules of sudoku.
	 * 	Each row, column, or 3x3 box sector must include the values between 1 through 9
	 * 	exactly once and these results are contained in their respective one-dimensional arrays.
	 * 	Results are returned in the form on a two-dimensional boolean array. 
	 * 	result[0] states this for the rows of the Sudoku.
	 * 	result[1] states this for the columns of the Sudoku.
	 * 	result[2] states this for each of the nine 3x3 box sectors of the Sudoku.
	 * 
	 * @param sudoku	A 9x9 Sudoku puzzle (of type Sudoku)
	 * @return 	A two-dimensional array of boolean values containing the results of the check.
	 * 			
	 * 
	 */
	public static boolean[][] check(Sudoku sudoku) {
		int[] 	expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[][] rowsToBeChecked = new int[9][9];
		int[][] columnsToBeChecked = new int[9][9];
		int[][] boxesToBeChecked = scanBoxes(sudoku); //Nine 3x3 sections of the Sudoku
		boolean[][] result = new boolean[3][9];

		//Checks the rows and columns.
		for (int i = 0; i < sudoku.getArray().length; i++) {
			for (int j = 0; j < sudoku.getArray()[i].length; j++) {
				rowsToBeChecked[i][j] = sudoku.getArray()[i][j];
				columnsToBeChecked[i][j] = sudoku.getArray()[j][i];
			}
			//Sort each of the row, column, and box arrays to be checked.
			Arrays.sort(rowsToBeChecked[i]);
			Arrays.sort(columnsToBeChecked[i]);
			Arrays.sort(boxesToBeChecked[i]);
			//Compare the values with the expected values
			result[0][i] = (Arrays.equals(rowsToBeChecked[i], expected)) ? true : false;
			result[1][i] = (Arrays.equals(columnsToBeChecked[i], expected)) ? true : false;
			result[2][i] = (Arrays.equals(boxesToBeChecked[i], expected)) ? true : false;			
		}
		return result;
	}
	
	public static boolean simpleCheck(Sudoku sudoku) {
		for (boolean[] array : check(sudoku)) {
			for (boolean result : array) {
				if (result == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	/** scanBoxes is a method which takes a 9x9 Sudoku Puzzle and populates a two-dimensional 
	 * 	integer array with the values contained in each of the 3x3 sectors.
	 *  
	 *	++===+===+===++
	 *	|| 0 | 1 | 2 || 
	 *	++---+---+---++
	 *	|| 3 | 4 | 5 ||
	 *	++---+---+---++
	 *	|| 6 | 7 | 8 ||
	 *	++===+===+===++
	 *
	 *	array[0] holds the values contained within box 0, array[1] for box 1, 
	 *	and so on through to array[8].
	 *
	 * @param sudoku	A 9x9 Sudoku puzzle (of type Sudoku)
	 * @return A two-dimensional Integer array with each row corresponding 
	 * 			to a box sector of the given Sudoku.
	 */
	public static int[][] scanBoxes(Sudoku sudoku) {
		int[][] array = new int[9][9];
		int boxRow, boxColumn, boxNumber, counter;
		for (int i = 0; i < sudoku.getArray().length; i++) {
			for (int j = 0; j < sudoku.getArray()[i].length; j++) {
				boxRow = i/3;
				boxColumn = j/3;
				boxNumber = 3*(i/3) + (j/3);
				counter = (i*3) + j - (boxRow*9 + boxColumn*3); //Position 0 through 8 of value within 3x3 sector
				if (boxRow == 0) {
					if (boxColumn == 0) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 0
					} else if (boxColumn == 1) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 1
					} else if (boxColumn == 2) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 2
					}
				} else if (boxRow == 1) {
					if (boxColumn == 0) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 3
					} else if (boxColumn == 1) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 4
					} else if (boxColumn == 2) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 5		
					} 
				} else {
					if (boxColumn == 0) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 6
					} else if (boxColumn == 1) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 7
					} else if (boxColumn == 2) {
						array[boxNumber][counter] = sudoku.getArray()[i][j]; //box 8
					}
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[][] correctSudoku  = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
								  {4, 5, 6, 7, 8, 9, 1, 2, 3},
								  {7, 8, 9, 1, 2, 3, 4, 5, 6},
								  {2, 3, 4, 5, 6, 7, 8, 9, 1},
								  {5, 6, 7, 8, 9, 1, 2, 3, 4},
								  {8, 9, 1, 2, 3, 4, 5, 6, 7},
								  {3, 4, 5, 6, 7, 8, 9, 1, 2},
								  {6, 7, 8, 9, 1, 2, 3, 4, 5},
								  {9, 1, 2, 3, 4, 5, 6, 7, 8}};
		
		int[][] incorrectSudoku= {{1, 2, 3, 4, 5, 6, 7, 8, 9},
								  {4, 5, 5, 7, 8, 9, 1, 2, 3}, //2nd 5 should be 6
								  {7, 8, 9, 1, 2, 3, 4, 5, 6},
								  {2, 3, 4, 5, 6, 7, 8, 9, 1},
								  {5, 6, 7, 8, 0, 1, 2, 3, 4}, //0 should be a 9
								  {8, 9, 1, 2, 3, 4, 5, 6, 7},
								  {3, 4, 5, 6, 7, 8, 9, 1, 2},
								  {6, 7, 8, 9, 1, 2, 3, 4, 5},
								  {9, 1, 2, 3, 4, 5, 6, 7, 9}}; //2nd 9 should be an 8!
		
		int[][] boxes = {{1, 1, 1, 2, 2, 2, 3, 3, 3},
						 {1, 1, 1, 2, 2, 2, 3, 3, 3},
						 {1, 1, 1, 2, 2, 2, 3, 3, 3},
						 {4 ,4 ,4, 5, 5, 5, 6, 6, 6},
						 {4 ,4 ,4, 5, 5, 5, 6, 6, 6},
						 {4 ,4 ,4, 5, 5, 5, 6, 6, 6},
						 {7, 7, 7, 8, 8, 8, 9, 9, 9},
						 {7, 7, 7, 8, 8, 8, 9, 9, 9},
						 {7, 7, 7, 8, 8, 8, 9, 9, 9}};
		
		Sudoku s1 = new Sudoku(correctSudoku);
		Sudoku s2 = new Sudoku(incorrectSudoku);
		Sudoku s3 = new Sudoku(boxes);
		
		check(s1);
		check(s2);
		check(s3);
		
	}
}
