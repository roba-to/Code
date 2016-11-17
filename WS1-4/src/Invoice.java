/**	Invoice.java
 * 	Invoice is a class for Exercise 1 of Worksheet 4 for MSc Software Workshop.
 * 	It is a simple class implementing methods from the class Measurable.
 * 
 * 	@author 	Robert Campbell
 *	@created	2016-11-06
 */
public class Invoice implements Measurable{
	private String accountNumber;
	private String sortCode;
	private double amount;
	
	/**	Invoice is a constructor for the Invoice class.
	 * 
	 * @param accountNumber	The account number to which the invoice corresponds to.
	 * @param sortCode		The sort code of the account to which the invoice corresponds to.
	 * @param amount		The amount to be invoiced.
	 */
	public Invoice(String accountNumber, String sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}
	
	/** Getter method to fulfil contract with Measurable interface
	 * 
	 * @return	returns amount
	 */
	public double getMeasure(){
		return this.amount;
	}
	
	/** Getter method to retrieve account number
	 * 
	 *	@return	returns accountNumber
	 */
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	/** Getter method to retrieve sort code
	 * 
	 *	@return returns sortCode
	 */
	public String getSortCode() {
		return this.sortCode;
	}
	
	public String toString() {
		return "Account Number: " + this.accountNumber +
				"\nSort Code: " + this.sortCode +
				"\nAmount: " + this.amount;
	}
	
	public static void main(String[] args) {
		Invoice i1 = new Invoice("12345", "11-22-33", 100.00);
		System.out.println(i1);
	}
}