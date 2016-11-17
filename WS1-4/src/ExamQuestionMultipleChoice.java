import java.util.ArrayList;

/**	ExamQuestionMultipleChoice.java
 * 		ExamQuestionMultipleChoice is a class that extends ExamQuestion.
 * 		It facilitates the creation of multiple choice questions with multiple correct
 * 		or incorrect choices available for the answers.
 *
 *	@author		Robert Campbell
 *	@created		2016-11-06
 *	@version		2016-11-06
 */
public class ExamQuestionMultipleChoice extends ExamQuestion{
	private ArrayList<String> possibleAnswers;
	private ArrayList<Integer> correctAnswers;

	/**	Constructor for ExamQuestionMultipleChoice
	 *
	 *	@param questionText		The text of the question itself
	 *	@param maximalMark		The maximal mark allocated to the question
	 *	@param possibleAnswers	The possible answers from which to choose from (ArrayList<String>)
	 *	@param correctAnswers	The positions of the correct answer(s) counting from 1 (ArrayList<Integer>)
	 */
	public ExamQuestionMultipleChoice(String questionText,
									int maximalMark,
									ArrayList<String> possibleAnswers,
									ArrayList<Integer> correctAnswers){
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswers = correctAnswers;
	}

	/**	Gets the possible answers
	 *
	 *	@return	Returns possible answers in an ArrayList<String>
	 */
	public ArrayList<String> getPossibleAnswers(){
		return this.possibleAnswers;
	}

	/**	Gets the correct answer(s)
	 *
	 *	@return	Returns correct answer(s) in an ArrayList<Integer>
	 */
	public ArrayList<Integer> getCorrectAnswers(){
		return this.correctAnswers;
	}

	/**	mark is a method which computes the points awarded by scaling the difference
	 * 	between the number of correct answers and the number of incorrect answers
	 * 	to the maximal point (not returning less than 0).
	 *
	 *	@param value	Your answer to the question
	 *	@return			Returns the number of points awarded based on correct and incorrect answers
	 */
	public int mark(ArrayList<Integer> answersProvided) {
		int correctTotal = 0;
		int difference;

		for (int answer : answersProvided) {
			for (int correct : getCorrectAnswers()) {
				if (answer == correct) {
					correctTotal += 1;
				}
			}
		}

		difference = correctTotal - (answersProvided.size() - correctTotal);
		if (difference > 0) {
			return (int)Math.round(getMaximalMark() * ((double)difference / getCorrectAnswers().size()));
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Multiple Choice " + super.toString() +
				"\nPossible Answers: " + getPossibleAnswers().toString() +
				"\nCorrect Answers:\n(option no.) " + getCorrectAnswers();
	}

	public static void main(String[] args) {
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("-2");
		answers.add("0");
		answers.add("2");
		answers.add("3");
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(1);
		correct.add(3);
		ExamQuestionMultipleChoice e1 = new ExamQuestionMultipleChoice("x*x = 4\nChoose all valid values of x?",
																		10,
																		answers,
																		correct);

		ArrayList<Integer> provided = new ArrayList<Integer>();
		provided.add(1);
//		provided.add(2);
//		provided.add(3);
//		provided.add(4);

		System.out.println(e1.mark(provided));
		System.out.println(e1);
	}
}
