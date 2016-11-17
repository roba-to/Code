import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SudokuTest {
	private int[][] intArray;
	
	@Before
	public void setUp() {
		intArray = new int[9][9];
	}
	

	@Test
	public void sudokuTest1() {
		Sudoku test = new Sudoku(intArray);
		int[][] expected = new int[9][9];
		
		assertArrayEquals("Failure in sudokuTest1, expected = ", expected, test.getArray());
	}
	
	@Test
	public void sudokuTest2() {
		Sudoku test = new Sudoku(intArray);
		
		assertFalse(test.isFilled());
	}
	
	@Test
	public void sudokuTest3() {
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = 2;
			}
		}
		
		Sudoku test = new Sudoku(intArray);
		assertTrue(test.isFilled());
	}
	
	@Test
	public void sudokuTest4() {
		intArray[5][8] = 4;
		Sudoku test = new Sudoku(intArray);
		
		assertArrayEquals("Failure in sudokuTest4, expected = ", intArray, test.getArray());
		assertFalse(test.isFilled());
	}
	
	@Test
	public void sudokuTest5() {
		String expected = 	"++===+===+===++===+===+===++===+===+===++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++===+===+===++===+===+===++===+===+===++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++===+===+===++===+===+===++===+===+===++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++===+===+===++===+===+===++===+===+===++";
		
		
		
		Sudoku test = new Sudoku(intArray);
//		System.out.println(expected);
//		System.out.println(test);
		
		assertEquals("Failure in sudokuTest5, expected = ", expected, test.toString());
	}
	
	@Test
	public void sudokuTest6() {
		String expected = 	"++===+===+===++===+===+===++===+===+===++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++===+===+===++===+===+===++===+===+===++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   | 5 |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++===+===+===++===+===+===++===+===+===++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"||   |   |   ||   |   |   ||   |   |   ||\n"+
							"++===+===+===++===+===+===++===+===+===++";
		
		intArray[4][4] = 5;
		
		Sudoku test = new Sudoku(intArray);
//		System.out.println(expected);
//		System.out.println(test);
		
		assertArrayEquals("Failure in sudokuTest6, expected Array = ", intArray, test.getArray());
		assertEquals("Failure in sudokuTest6, expected String = ", expected, test.toString());
		assertFalse(test.isFilled());
	
	}
	
	@Test
	public void sudokuTest7() {
		String expected = 	"++===+===+===++===+===+===++===+===+===++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++===+===+===++===+===+===++===+===+===++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++===+===+===++===+===+===++===+===+===++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++---+---+---++---+---+---++---+---+---++\n"+
							"|| 1 | 1 | 1 || 1 | 1 | 1 || 1 | 1 | 1 ||\n"+
							"++===+===+===++===+===+===++===+===+===++";
		
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = 1;
			}
		}
		
		Sudoku test = new Sudoku(intArray);
		
		assertArrayEquals("Failure in sudokuTest7, expected Array = ", intArray, test.getArray());
		assertTrue(test.isFilled());
		assertEquals("Failure in sudokuTest7, expected String =", expected, test.toString());
	}

}
