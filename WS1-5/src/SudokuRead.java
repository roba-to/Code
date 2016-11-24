import java.io.*;
import java.util.Arrays;

public class SudokuRead {	
	
	public static Sudoku readSudoku(String filename) throws IllegalArgumentException, IOException {
		int[][] array = new int[9][9];
		BufferedReader in = new BufferedReader(new FileReader(filename));
		try {
			for (int i = 0; i < 9; i++) {
				String s = in.readLine();
				if (countLines(filename) < 9 | s.length() < 9) {
					throw new IllegalArgumentException();
				}
				for (int j = 0; j < 9; j++) {
					if (0 <= Character.getNumericValue(s.charAt(j)) && Character.getNumericValue(s.charAt(j)) <= 9) {
						array[i][j] = Character.getNumericValue(s.charAt(j));
					} else if (Character.isWhitespace(s.charAt(j))) {
						array[i][j] = 0;
					} else {
						throw new IllegalArgumentException();
					}
				}
			}
		} finally {
			in.close(); //close BufferedReader
		}
		return new Sudoku(array);
	}
	
	public static int countLines(String filename) throws IOException {
		int counter = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while (in.readLine() != null) {
				counter++;
			}
			in.close();
		}
		catch (IOException error) {
			System.out.println("Filename " + filename + "not found");
		}
		return counter;
	}
	
	public static void main(String[] args) throws IOException {
		
		String test_1 = "sudoku-ex1.txt";
		readSudoku(test_1);
		
		String test_2 = "sudoku-ex2.txt";
		readSudoku(test_2);
		
		String test_3 = "sudoku-ex3.txt";
		readSudoku(test_3);
		
		String test_4 = "sudoku-ex4.txt";
		readSudoku(test_4);
		
		String test_5 = "sudoku-ex5.txt";
		readSudoku(test_5);
		
		String test_6 = "sudoku-ex6.txt";
		readSudoku(test_6);
		
		String test_extra = "sudoku-extra.txt";
		readSudoku(test_extra);
		
		String difficult = "sudoku-difficult.txt";
		readSudoku(difficult);
		
		String test_full = "sudoku-full.txt";
		readSudoku(test_full);
		
		String test_part = "sudoku-part.txt";
		readSudoku(test_part);
		
		String one_missing = "sudoku-one-missing.txt";
		readSudoku(one_missing);
//		
//		String illegal_1 = "sudoku-illegal1.txt";
//		tester.readSudoku(illegal_1);
//		
//		String illegal_2 = "sudoku-illegal2.txt";
//		System.out.println(countLines(illegal_2));
//		tester.readSudoku(illegal_2);
//		
//		String illegal_3 = "sudoku-illegal3.txt";
//		tester.readSudoku(illegal_3);
//		
















	}
}
