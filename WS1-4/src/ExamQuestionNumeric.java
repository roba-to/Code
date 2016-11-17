/** ExamQuestionNumeric.java
 * 	ExamQuestionNumeric is a class which extends ExamQuestion.
 * 	It facilitates the creation of simple numeric questions with only
 * 	a single possible correct answer.
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-06
 *	@version	2016-11-06
 */
public class ExamQuestionNumeric extends ExamQuestion{
	private int answer;
	
	/**	Constructor for ExamQuestionNumeric
	 * 
	 *	@param questionText	The text of the question itself.
	 *	@param maximalMark	The maximal mark allocated to the question.
	 *	@param answer		The answer to the question (int).
	 */
	public ExamQuestionNumeric(String questionText, int maximalMark, int answer){
		super(questionText, maximalMark);
		this.answer = answer;
	}
	
	/**	Gets the answer to the question
	 * 
	 *	@return	The answer to the question (int)
	 */
	public int getAnswer() {
		return this.answer;
	}
	
	/**	mark is a method which returns the maximal mark if the provided value
	 * 	is the correct answer to the question and 0 if not.
	 * 
	 *	@param value	Your answer to the question
	 *	@return	Returns Maximal Mark if value given is the correct answer, 0 if not.
	 */
	public int mark(int value) {
		if (value == getAnswer()) {
			return getMaximalMark();
		} else {
			return 0;
		}
	}
	
	@Override
	//String representation of the ExamQuestionNumeric object
	public String toString() {
		return "Numeric " + super.toString() + "\nAnswer: " + getAnswer();
	}
	
	public static void main(String[] args) {
		ExamQuestionNumeric e1 = new ExamQuestionNumeric("What is 5 + 5?", 10, 10);
		System.out.println(e1);
	}
	
}
