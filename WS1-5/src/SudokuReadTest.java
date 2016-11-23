
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

public class SudokuReadTest {
	
	@Test
	public void SudokuReadTest1() throws IOException {
		String filename = "sudoku-ex1.txt";
		int[][] expected = {{0, 0, 0, 9, 0, 2, 0, 8, 0},
							{0, 4, 2, 8, 0, 1, 7, 0, 0},
							{8, 0, 0, 0, 4, 0, 0, 0, 2},
							{4, 9, 0, 0, 0, 5, 0, 3, 8},
							{0, 1, 0, 7, 9, 0, 0, 6, 0},
							{3, 6, 0, 0, 0, 0, 0, 7, 9},
							{1, 0, 0, 0, 7, 0, 8, 0, 6},
							{0, 8, 6, 2, 0, 4, 3, 0, 0},
							{0, 0, 3, 5, 0, 6, 0, 0, 0}};
		assertArrayEquals("Failure in SudokuReadTest1, expected = ", expected, SudokuRead.readSudoku(filename).getArray());
	}
	
	@Test
	public void SudokuReadTest2() throws IOException {
		String filename = "sudoku-ex2.txt";
		int[][] expected = {{0, 0, 4, 0, 8, 5, 0, 1, 0},
							{0, 2, 0, 6, 0, 9, 8, 0, 3},
							{3, 0, 8, 0, 0, 0, 0, 0, 0},
							{0, 5, 0, 2, 6, 0, 0, 0, 9},
							{0, 7, 0, 0, 0, 0, 3, 2, 0},
							{9, 0, 0, 0, 4, 3, 0, 5, 0},
							{0, 3, 0, 0, 0, 0, 0, 0, 6},
							{8, 0, 9, 0, 0, 1, 0, 3, 0},
							{0, 4, 0, 9, 0, 0, 2, 7, 0}};
		assertArrayEquals("Failure in SudokuReadTest1, expected = ", expected, SudokuRead.readSudoku(filename).getArray());
	}
	
}
