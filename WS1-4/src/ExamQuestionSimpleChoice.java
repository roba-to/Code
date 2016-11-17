import java.util.ArrayList;
/**	ExamQuestionSimpleChoice.java
 * 	ExamQuestionSimpleChoice is a class which extends ExamQuestion.
 * 	It facilitates the creation of simple multiple choice questions where only
 * 	one of the potential choices can be the correct answer.
 * 
 *	@author		Robert Campbell
 *	@created		2016-11-06
 *	@version		2016-11-06
 */
public class ExamQuestionSimpleChoice extends ExamQuestion {
	private ArrayList<String> possibleAnswers;
	private int correctAnswer;
	
	/**	Constructor for ExamQuestionSimpleChoice
	 * 
	 *	@param questionText		The text of the question itself
	 *	@param maximalMark		The maximal mark allocated to the question
	 *	@param possibleAnswers	The possible answers from which to choose from (ArrayList<String>)
	 *	@param correctAnswer	The position in the ArrayList possibleAnswers of the correct answer (counting from 1)
	 */
	public ExamQuestionSimpleChoice(String questionText, 
									int maximalMark, 
									ArrayList<String> possibleAnswers,
									int correctAnswer) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}
	
	/**	mark is a method which returns the maximal mark if the provided value
	 * 	is the correct answer to the question and 0 if not.
	 * 
	 *	@param value	Your answer to the question
	 *	@return	Returns Maximal Mark if value given is the correct answer, 0 if not.
	 */
	public int mark(int value) {
		if (value == getCorrectAnswer()) {
			return 10;
		} else {
			return 0;
		}
	}
	
	/**	Gets the possible answers
	 * 
	 *	@return	Returns possible answers in an ArrayList<String>
	 */
	public ArrayList<String> getPossibleAnswers(){
		return this.possibleAnswers;
	}
	
	/** Gets the the position of the correct answer in the list (counting from 1)
	 * 
	 *	@return	The position in the ArrayList possibleAnswers of the correct answer (counting from 1)
	 */
	public int getCorrectAnswer() {
		return this.correctAnswer;
	}
	
	@Override
	//String representation of the ExamQuestionSimpleChoice object
	public String toString() {
		return "Simple Choice " + super.toString() + 
					"\nPossible Answers: " + getPossibleAnswers().toString() + 
					"\nCorrect Answer is at position " + getCorrectAnswer();
	}
	
	public static void main(String[] args) {
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("1");
		answers.add("2");
		answers.add("3");
		answers.add("4");
		answers.add("5");
		ExamQuestionSimpleChoice e1 = new ExamQuestionSimpleChoice("What is 1 + 4?", 10, answers, 5);
		
		System.out.println(e1);
		System.out.println("You scored " + e1.mark(5) + " points.");
	}
}
