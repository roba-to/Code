/** ExamQuestion.java
 * 	ExamQuestion is a class for Exercise 4, Worksheet 4 for MSc Software Workshop.
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-06
 *	@version	2016-11-06
 */
public class ExamQuestion {
	private String questionText;
	private int maximalMark;
	
	/**	Constructor for ExamQuestion class consisting of the question
	 * 	text and the maximal mark for that question.
	 * 
	 *	@param questionText	The text of the question itself.
	 *	@param maximalMark	The maximal mark allocated to the question
	 */
	public ExamQuestion(String questionText, int maximalMark) {
		this.questionText = questionText;
		if (maximalMark < 0) {
			throw new IllegalArgumentException("Maximal Mark can't be less than 0");
		}
		this.maximalMark = maximalMark;
	}
	
	/**	Gets the question text
	 * 
	 *	@return	The text of the question itself.
	 */
	public String getQuestionText() {
		return this.questionText;
	}
	
	/**	Gets the maximal mark allocated to the question
	 * 
	 *	@return	The maximal mark allocated to the question
	 */
	public int getMaximalMark() {
		return this.maximalMark;
	}
	
	/**	Sets new question text
	 * 
	 *	@param newQuestionText	The new question text
	 */
	public void setQuestionText(String newQuestionText) {
		this.questionText = newQuestionText;
	}
	
	/** Sets the new maximal mark for a question
	 * 
	 *	@param newMaximalMark	The new maximal mark for the question
	 */
	public void setMaximalMark(int newMaximalMark) {
		if (maximalMark < 0) {
			throw new IllegalArgumentException("Maximal Mark can't be less than 0");
		}
		this.maximalMark = newMaximalMark;
	}
	
	/**
	 * @return 	A String representation of the ExamQuestion object
	 */
	public String toString() {
		return "Question: " + getQuestionText() + "\n(maximal mark: "+ getMaximalMark() + ")" ;
	}
	
	public static void main(String[] args){
		ExamQuestion e1 = new ExamQuestion("What is 2 times 3?", 10);
		
		System.out.println(e1);
	}
}
