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
	
	/**	intToString is a method which takes an integer and converts it to a String.
	 * 	If the integer value happens to be 0 then the method returns an empty space (" ").
	 * 
	 * @param value	an integer value
	 * @return	A String representation of that integer unless int == 0. If int == 0 then returns " ".
	 */
	public String intToString(int value) {
		if (value == 0) {
			return " ";
		} else {
			return Integer.toString(value);
		}
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
		String thickBorder 	= "++===+===+===++===+===+===++===+===+===++";
		String thinBorder 	= "++---+---+---++---+---+---++---+---+---++";
		String s = "";
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				s += thickBorder + "\n";
			} else {
				s += thinBorder + "\n";
			}
			for (int j = 0; j < 9; j++) {
				String element = intToString(getArray()[i][j]);
				if (j % 3 == 0) {
					s += "|| " + element + " ";
				} else if (j == 8) {
					s += "| " + element + " ||\n";
				} else {
					s += "| " + element + " ";
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
	}
}
