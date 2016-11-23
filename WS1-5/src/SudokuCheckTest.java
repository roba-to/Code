import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class SudokuCheckTest {

	@Test
	public void SudokuCheckTest1() {
		int[][] array =  {{1, 2, 3, 4, 5, 6, 7, 8, 9},
						  {4, 5, 6, 7, 8, 9, 1, 2, 3},
						  {7, 8, 9, 1, 2, 3, 4, 5, 6},
						  {2, 3, 4, 5, 6, 7, 8, 9, 1},
						  {5, 6, 7, 8, 9, 1, 2, 3, 4},
						  {8, 9, 1, 2, 3, 4, 5, 6, 7},
						  {3, 4, 5, 6, 7, 8, 9, 1, 2},
						  {6, 7, 8, 9, 1, 2, 3, 4, 5},
						  {9, 1, 2, 3, 4, 5, 6, 7, 8}};
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{true, true, true, true, true, true, true, true, true},
								{true, true, true, true, true, true, true, true, true},
								{true, true, true, true, true, true, true, true, true}};
		assertArrayEquals("Failure in SudokuTestCheck1, expected ", expected, SudokuCheck.check(test));
	}
	
	@Test
	public void SudokuCheckTest2() {
		int[][] array =  {{1, 2, 3, 4, 5, 6, 7, 8, 9},
						  {4, 5, 6, 7, 8, 9, 1, 2, 3},
						  {7, 8, 9, 1, 2, 3, 4, 5, 6},
						  {2, 3, 4, 5, 6, 7, 8, 9, 1},
						  {5, 6, 7, 8, 9, 1, 2, 3, 4}, 
						  {8, 9, 1, 2, 3, 4, 5, 6, 7},
						  {3, 4, 5, 6, 7, 8, 9, 1, 2},
						  {6, 7, 8, 9, 1, 2, 3, 4, 5},
						  {9, 1, 2, 3, 4, 5, 6, 7, 9}}; //2nd 9 should be an 8!
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{true, true, true, true, true, true, true, true, false},
								{true, true, true, true, true, true, true, true, false},
								{true, true, true, true, true, true, true, true, false}};
		assertArrayEquals("Failure in SudokuTestCheck2, expected ", expected, SudokuCheck.check(test));
	}
	
	@Test
	public void SudokuCheckTest3() {
		int[][] array =  {{0, 2, 3, 4, 5, 6, 7, 8, 9}, //0 should be 1
						  {4, 5, 6, 7, 8, 9, 1, 2, 3},
						  {7, 8, 9, 1, 2, 3, 4, 5, 6},
						  {2, 3, 4, 5, 6, 7, 8, 9, 1},
						  {5, 6, 7, 8, 9, 1, 2, 3, 4}, 
						  {8, 9, 1, 2, 3, 4, 5, 6, 7},
						  {3, 4, 5, 6, 7, 8, 9, 1, 2},
						  {6, 7, 8, 9, 1, 2, 3, 4, 5},
						  {9, 1, 2, 3, 4, 5, 6, 7, 0}}; //2nd 9 should be an 8!
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{false, true, true, true, true, true, true, true, false},
								{false, true, true, true, true, true, true, true, false},
								{false, true, true, true, true, true, true, true, false}};
		assertArrayEquals("Failure in SudokuTestCheck3, expected ", expected, SudokuCheck.check(test));
	}
	
	@Test
	public void SudokuCheckTest4() {
		int[][] array =  {{0, 2, 3, 4, 5, 6, 7, 8, 9}, // 0 should be 1
						  {4, 5, 6, 7, 8, 9, 1, 2, 3},
						  {7, 8, 9, 1, 2, 3, 4, 5, 6},
						  {2, 3, 4, 5, 6, 7, 8, 9, 1},
						  {5, 6, 7, 8, 0, 1, 2, 3, 4}, //0 should be 9
						  {8, 9, 1, 2, 3, 4, 5, 6, 7},
						  {3, 4, 5, 6, 7, 8, 9, 1, 2},
						  {6, 7, 8, 9, 1, 2, 3, 4, 5},
						  {9, 1, 2, 3, 4, 5, 6, 7, 9}}; //2nd 9 should be an 8!
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{false, true, true, true, false, true, true, true, false},
								{false, true, true, true, false, true, true, true, false},
								{false, true, true, true, false, true, true, true, false}};
		assertArrayEquals("Failure in SudokuTestCheck4, expected ", expected, SudokuCheck.check(test));
	}
	
	@Test
	public void SudokuCheckTest5() {
		int[][] array =  {{0, 2, 3, 4, 5, 6, 7, 8, 9}, //0 should be 1
						  {4, 1, 6, 7, 8, 9, 1, 2, 3}, //1st 1 should be 5
						  {7, 8, 2, 1, 2, 3, 4, 5, 6}, //1st 2 should be 9
						  {2, 3, 4, 3, 6, 7, 8, 9, 1}, //2nd 3 should be 5
						  {5, 6, 7, 8, 4, 1, 2, 3, 4}, //1st 4 should be 9
						  {8, 9, 1, 2, 3, 5, 5, 6, 7}, //1st 5 should be 5
						  {3, 4, 5, 6, 7, 8, 6, 1, 2}, //2nd 6 should be 9
						  {6, 7, 8, 9, 1, 2, 3, 7, 5}, //2nd 7 should be 4
						  {9, 1, 2, 3, 4, 5, 6, 7, 9}}; //2nd 9 should be 8!
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{false, false, false, false, false, false, false, false, false},
								{false, false, false, false, false, false, false, false, false},
								{false, true, true, true, false, true, true, true, false}};
		assertArrayEquals("Failure in SudokuTestCheck5, expected ", expected, SudokuCheck.check(test));
	}
	
	@Test
	public void SudokuCheckTest6() {
		//Shouldn't contain any zeroes so all sections should fail
		int[][] array =  {{0, 2, 3, 4, 0, 6, 7, 8, 9}, 
						  {4, 0, 6, 7, 8, 0, 1, 2, 3}, 
						  {7, 8, 0, 1, 2, 3, 0, 5, 6}, 
						  {2, 3, 4, 0, 6, 7, 8, 0, 1}, 
						  {0, 6, 7, 8, 0, 1, 2, 3, 0}, 
						  {8, 0, 1, 2, 3, 0, 5, 6, 7}, 
						  {3, 4, 0, 6, 7, 8, 0, 1, 2}, 
						  {6, 7, 8, 0, 1, 2, 3, 0, 5}, 
						  {9, 1, 2, 3, 0, 5, 6, 7, 0}}; 
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{false, false, false, false, false, false, false, false, false},
								{false, false, false, false, false, false, false, false, false},
								{false, false, false, false, false, false, false, false, false}};
		assertArrayEquals("Failure in SudokuTestCheck6, expected ", expected, SudokuCheck.check(test));
	}
	
	@Test
	public void SudokuCheckTest7() {
		//Although each row, column, and box == 45 it should fail!
		int[][] array =    {{5, 5, 5, 5, 5, 5, 5, 5, 5}, 
							{5, 5, 5, 5, 5, 5, 5, 5, 5},
							{5, 5, 5, 5, 5, 5, 5, 5, 5},
							{5, 5, 5, 5, 5, 5, 5, 5, 5},
							{5, 5, 5, 5, 5, 5, 5, 5, 5},
							{5, 5, 5, 5, 5, 5, 5, 5, 5},
							{5, 5, 5, 5, 5, 5, 5, 5, 5},
							{5, 5, 5, 5, 5, 5, 5, 5, 5},
							{5, 5, 5, 5, 5, 5, 5, 5, 5}}; 
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{false, false, false, false, false, false, false, false, false},
								{false, false, false, false, false, false, false, false, false},
								{false, false, false, false, false, false, false, false, false}};
		assertArrayEquals("Failure in SudokuTestCheck7, expected ", expected, SudokuCheck.check(test));
	}
	
	@Test
	public void SudokuCheckTest8() {
		int[][] array =  {{5, 5, 5, 4, 5, 6, 7, 8, 9}, //box 0 contains all 5s
						  {5, 5, 5, 7, 8, 9, 1, 2, 3},
						  {5, 5, 5, 1, 2, 3, 4, 5, 6},
						  {2, 3, 4, 5, 6, 7, 8, 9, 1},
						  {5, 6, 7, 8, 9, 1, 2, 3, 4},
						  {8, 9, 1, 2, 3, 4, 5, 6, 7},
						  {3, 4, 5, 6, 7, 8, 9, 1, 2},
						  {6, 7, 8, 9, 1, 2, 3, 4, 5},
						  {9, 1, 2, 3, 4, 5, 6, 7, 8}};
		Sudoku test = new Sudoku(array);
		boolean[][] expected = {{false, false, false, true, true, true, true, true, true},
								{false, false, false, true, true, true, true, true, true},
								{false, true, true, true, true, true, true, true, true}};
		assertArrayEquals("Failure in SudokuTestCheck8, expected ", expected, SudokuCheck.check(test));
	}
	

}
