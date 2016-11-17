import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

/**	Ex4Tests.java
 * 	Public tests for Exercise 4, Worksheet 4 for MSc Software Workshop.
 * 	Tests functionality for ExamQuestion super class and 
 * 	ExamQuestionNumeric, ExamQuestionSimpleChoice and ExamQuestionMultipleChoice
 * 	subclasses.
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-14
 *	@version	2016-11-14
 */
public class Ex4Tests {

	@Test
	public void Ex4Test1() {
		ExamQuestion e1 	= new ExamQuestion("What is 2 times 3?", 10);
		String e1Question 	= "What is 2 times 3?";
		int e1MaximalMark 	= 10;
		
		assertEquals("Failure in Ex4Test1, expected String =", 
					e1Question, 
					e1.getQuestionText());
		assertEquals("Failure in Ex4Test1, expected int = ", 
					e1MaximalMark, 
					e1.getMaximalMark());
	}

	@Test
	public void Ex4Test2() {
		ExamQuestionNumeric e1	= new ExamQuestionNumeric("2+3 = ?", 10, 5);
		String e1Question		= "2+3 = ?";
		int e1MaximalMark		= 10;
		int e1Answer			= 5;
		
		assertEquals("Failure in Ex4Test2, expected String =", 
					e1Question, 
					e1.getQuestionText());
		assertEquals("Failure in Ex4Test2, expected int = ", 
					e1MaximalMark, 
					e1.getMaximalMark());
		assertEquals("Failure in Ex4Test2, expected int = ",
					e1Answer,
					e1.getAnswer());
		assertEquals("Failure in Ex4Test2, expected int = ",
					e1.getMaximalMark(), //correct answer so should be full marks
					e1.mark(5));
		assertEquals("Failure in Ex4Test2, expected int = ",
					0, //incorrect answer so should be zero marks!
					e1.mark(4));
		assertEquals("Failure in Ex4Test2, expected String = ",
					"Numeric Question: 2+3 = ?\n(maximal mark: 10)\nAnswer: 5", 
					e1.toString());
	}
	
	@Test
	public void Ex4Test3() {
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("1");
		answers.add("2");
		answers.add("3");
		answers.add("4");
		answers.add("5");
		String e1Question		= "What is 1 + 4?";
		int e1MaximalMark		= 10;
		int e1CorrectAnswer		= 5;
		ExamQuestionSimpleChoice e1 = new ExamQuestionSimpleChoice("What is 1 + 4?", 10, answers, 5);
		
		assertEquals("Failure in Ex4Test3, expected String =", 
					e1Question, 
					e1.getQuestionText());
		assertEquals("Failure in Ex4Test3, expected int = ", 
					e1MaximalMark, 
					e1.getMaximalMark());
		assertEquals("Failure in Ex4Test3, expected int = ", 
					e1CorrectAnswer, 
					e1.getCorrectAnswer());
		assertEquals("Failure in Ex4Test3, expected ArrayList<String>", 
					answers.toString(), 
					e1.getPossibleAnswers().toString());
		assertEquals("Failure in Ex4Test3, expected int = ",
					e1MaximalMark,
					e1.mark(5));
		assertEquals("Failure in Ex4Test3, expected int = ", 
					0, 
					e1.mark(4));	
		assertEquals("Failure in Ex4Test3, expected String = ",
					"Simple Choice Question: What is 1 + 4?\n(maximal mark: 10)\nPossible Answers: [1, 2, 3, 4, 5]\nCorrect Answer is at position 5",
					e1.toString());
	}
	
	@Test
	public void Ex4Test4() {
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("Moose");
		answers.add("Pob");
		answers.add("Campbell");
		answers.add("Bobby");
		answers.add("Keith");
		answers.add("Robbie");
		answers.add("Campers");
		answers.add("Banana");
		answers.add("Bert");
		answers.add("Trebor");
		String e1question = "What are Robert Campbell's nicknames?";
		int maximalMark = 20;
		ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
		correctAnswers.add(1);
		correctAnswers.add(2);
		
		ExamQuestionMultipleChoice e1 = new ExamQuestionMultipleChoice("What are Robert Campbell's nicknames?", 
																20, 
																answers, 
																correctAnswers);
		
		ArrayList<Integer> e1ProvidedAnswers = new ArrayList<Integer>();
		e1ProvidedAnswers.add(1); 
				
		assertEquals("Failure in Ex4Test4, expected String = ", e1question, e1.getQuestionText());
		
		assertEquals("Failure in Ex4Test4, expceted int = ", maximalMark, e1.getMaximalMark());
		
		assertEquals("Failure in Ex4Test4, expected = ", answers, e1.getPossibleAnswers());
		
		assertEquals("Failure in Ex4Test4, expected = ", 10, e1.mark(e1ProvidedAnswers)); // A single (correct) answers given
		
		e1ProvidedAnswers.add(2);
		
		assertEquals("Failure in Ex4Test4, expected = ", 20, e1.mark(e1ProvidedAnswers)); // 2 (correct) answers given
		
		e1ProvidedAnswers.add(3);
		
		assertEquals("Failure in Ex4Test4, expected = ", 10, e1.mark(e1ProvidedAnswers)); // 2 correct and 1 incorrect given
		
		e1ProvidedAnswers.add(4);
		
		assertEquals("Failure in Ex4Test4, expected = ", 0, e1.mark(e1ProvidedAnswers)); // 2 correct and 2 incorrect given
		
		e1ProvidedAnswers.add(5);
		e1ProvidedAnswers.add(6);
		e1ProvidedAnswers.add(7);
		e1ProvidedAnswers.add(8);
		e1ProvidedAnswers.add(9);
		e1ProvidedAnswers.add(10);
		
		assertEquals("Failure in Ex4Test4, expected = ", 0, e1.mark(e1ProvidedAnswers)); // Every possible answer chosen
	}
	
	@Test
	public void Ex4Test5() {
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("Red");
		answers.add("White");
		answers.add("Blue");
		answers.add("Yellow");

		String e1Question = "What colours make up the Union Jack flag?";
		int maximalMark = 100;
		ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
		correctAnswers.add(1);
		correctAnswers.add(2);
		correctAnswers.add(3);
		
		ExamQuestionMultipleChoice e1 = new ExamQuestionMultipleChoice(e1Question, 
																maximalMark, 
																answers, 
																correctAnswers);
		
		assertEquals("Failure in Ex4Test5, expected String = ", 
					"What colours make up the Union Jack flag?", 
					e1.getQuestionText());
		
		assertEquals("Failre in Ex4Test5, expected = ", 100, e1.getMaximalMark());
		
		ArrayList<Integer> providedAnswers = new ArrayList<Integer>();
		providedAnswers.add(1);
		
		assertEquals("Failure in Ex4Test5, expected int = ", 33, e1.mark(providedAnswers)); // 1 correct, 0 incorrect
		
		providedAnswers.add(2);
		
		assertEquals("Failure in Ex4Test5, expected int = ", 67, e1.mark(providedAnswers)); // 2 correct, 0 incorrect
		
		providedAnswers.add(3);
		
		assertEquals("Failure in Ex4Test5, expected int = ", 100, e1.mark(providedAnswers)); // 3 correct, 0 incorrect
		
		providedAnswers.add(4);
		
		assertEquals("Failure in Ex4Test5, expected int = ", 67, e1.mark(providedAnswers)); // 3 correct, 1 incorrect
		
		providedAnswers.add(5);
		providedAnswers.add(6);
		
		assertEquals("Failure in Ex4Test5, expected int = ", 0, e1.mark(providedAnswers)); // 3 correct, 3 incorrect - 0 marks!
		
	}
}
