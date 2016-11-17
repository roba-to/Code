/**	Patient.java
 * 	Patient is a class for Exercise 1 of Worksheet 4 for MSc Software Workshop.
 * 	It is a simple class implementing methods from the class Measurable.
 * 
 * 	@author 	Robert Campbell
 *	@created	2016-11-06
 */
public class Patient implements Measurable {
	private String name;
	private int age;
	private double weight;
	
	/** Patient is a constructor for the class Patient.
	 * 	It takes three variables corresponding to basic patient details.
	 * 
	 * @param name		The name of the patient.
	 * @param age		The age of the patient (as an int)
	 * @param weight	The weight of the patient in kilograms (as a double)
	 */
	public Patient(String name, int age, double weight){
		this.name = name;
		if (age < 0) {
			throw new IllegalArgumentException("Age must not be less than 0");
		}
		this.age = age;
		this.weight = weight;
	}
	
	/**Gets the weight of a Patient.
	 * Getter method to fulfil contract with Measurable interface
	 * 
	 * @return	returns the weight of the patient.
	 */
	public double getMeasure() {
		return this.weight;
	}
	
	/** Gets the name of a Patient
	 * 
	 *	@return returns the name of a Patient
	 */
	public String getName() {
		return this.name;
	}
	
	/** Gets the age of a Patient
	 * 
	 *	@return returns the name of a patient
	 */
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return "Name: " + this.name + "\nAge: " + this.age + "\nWeight: " + this.weight + "kg";
	}
	
	public static void main(String[] args) {
		Patient p1 = new Patient("Robert Campbell", 31, 75.5);
		System.out.println(p1);
	}
}
