import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SudokuInteractive extends Sudoku{
	private static int[][] playerArray;
	private static int[][] originalState;
	private static String  message = "";
	
	public SudokuInteractive(int[][] array) {
		super(array);
	}
	
	public static void play(String file) {
		int column, row, value;
		boolean gameOver 	= false;
		Scanner reader 		= new Scanner(System.in);
		String 	userInput 	= "";
		Pattern command 	= Pattern.compile("[a-i][1-9]:[1-9]");
		String[] messages 	= {"Board has been reset", //0
								"That cell can't be changed!", //1
								"Uh-oh, there's a mistake somewhere!", //2
								"CONGRATULATIONS!!!\nYou must be a genius :)", //3
								"Invalid command!\n(Format is a1:value, a2:value, .. i9:value)", //4
								"Please enter your move: "}; //5
		
		try {
			SudokuInteractive board = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
			originalState = copyBoard(board.getArray());
			while (gameOver == false) {
				System.out.println(board);
				System.out.print(messages[5]);
				userInput = reader.nextLine();
				Matcher m = command.matcher(userInput);
				if (userInput.equals("reset")) {
					message = messages[0];
					board = new SudokuInteractive(originalState);
				} else if (userInput.equals("exit")) {
					System.out.println("****** BYE BYE ******");
					gameOver = true;
					
				} else if (m.matches()) {
					row 	= (Character.getNumericValue(userInput.charAt(0)) - 10);
					column 	= (Character.getNumericValue(userInput.charAt(1)) - 1);
					value 	= (Character.getNumericValue(userInput.charAt(3)));
					if (originalState[row][column] != 0) {
						message = messages[1]; //Invalid move
					} else if (originalState[row][column] == 0) {
						String cell = (board.getArray()[row][column] == 0) ? " " : Integer.toString(board.getArray()[row][column]);
						message = "[" + userInput.charAt(0) + userInput.charAt(3) + "] " + cell + " changed to " + value; //Valid move
						board.getArray()[row][column] = value;
					}
					if (board.isFilled()) {
						if (SudokuCheck.simpleCheck(board) == false) {
							message += "\n" + messages[2]; //Not correct
						} else {
							message = "\n" + messages[3]; //Win
							gameOver = true;
						}
					}
				} else {
					message = messages[4];
				}
			}
		} catch (IOException e) {
			System.out.println("Error: File Not Found!");
			e.printStackTrace();
		}
	}
	
	public static int[][] copyBoard(int[][] array) {
		int[][] copy = new int[9][9];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}
	
	@Override
	public String toString() {
		String element;
		String thickBorder 	= "    ++===+===+===++===+===+===++===+===+===++\n";
		String thinBorder 	= "    ++---+---+---++---+---+---++---+---+---++\n";
		String[] alphaRow = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
		String s = "\n       1   2   3    4   5   6    7   8   9   \n";
		int n;

		for (int i = 0; i < getArray().length; i++) {
			s += (i % 3 == 0) ? thickBorder : thinBorder;
			for (int j = 0; j < getArray()[i].length; j++) {
				n = getArray()[i][j];
				if (originalState[i][j] != 0) {
					element = (n == 0) ? "   " : "." + Integer.toString(n) + ".";
				} else {
					element = (n == 0) ? "   " : " " + Integer.toString(n) + " ";
				}
				if (j == 0) {
					s += " " + alphaRow[i] + "  ||" + element;
				} else if (j % 3 == 0 && j != 0) {
					s += "||" + element;
				} else if (j == 8) {
					s += "|" + element + "|| \n";
				} else {
					s += "|" + element;
				}
			}
		}
		s += thickBorder + "\n" + message;
		return s;
	}
	
	public static void main(String[] args) {
//		String input = "d5:a";
//		Scanner userInput = new Scanner(System.in).useDelimiter("\\s*:\\s*");
//		System.out.println(userInput.next());
//		System.out.println(userInput.next());
		String testFile = "sudoku-almost.txt";
		play(testFile);
	}
}
