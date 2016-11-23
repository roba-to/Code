/**	Sudoku.java
 * 	Sudoku is a class for Worksheet 5 for MSc Software Workshop
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-16
 *	@version	2016-11-16
 */
public class Sudoku {
	private int[][] array;
	
	/**	Constructor for Sudoku class.
	 * 	Constructs an 9x9 integer array (default int values of 0) 
	 */
	public Sudoku(int[][] array) {
		this.array = array;
	}
	
	/**	Getter for Sudoku array
	 * 
	 * @return the 9x9 integer array of a Sudoku object
	 */
	public int[][] getArray() {
		return this.array;
	}
	
	/**	isFilled checks if all elements of a Sudoku puzzle are filled.
	 * 
	 * @return true if all elements of the Sudoku are filled, false if not.
	 */
	public boolean isFilled() {
		for (int[] row : getArray()) {
			for (int column : row) {
				if (column == 0) return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String thickBorder 	= "++===+===+===++===+===+===++===+===+===++\n";
		String thinBorder 	= "++---+---+---++---+---+---++---+---+---++\n";
		String s = "";
		int n;
		for (int i = 0; i < getArray().length; i++) {
			s += (i % 3 == 0) ? thickBorder : thinBorder;
			for (int j = 0; j < getArray()[i].length; j++) {
				n = getArray()[i][j];
				String element = (n == 0) ? "   " : " " + Integer.toString(n) + " ";
				if (j % 3 == 0) {
					s += "||" + element;
				} else if (j == 8) {
					s += "|" + element + "||\n";
				} else {
					s += "|" + element;
				}
			}
		}
		s += thickBorder;
		return s;
	}
	
	
	public static void main(String[] args) {
		int[][] array = new int[9][9];
		Sudoku s1 = new Sudoku(array);
		
		System.out.println(s1);
		System.out.println(s1.isFilled());
		String testString = "0123456789";
		
		SudokuRead test = new SudokuRead();
	}
}
