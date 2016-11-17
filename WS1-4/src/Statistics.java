import java.util.ArrayList;

/**	Statistics.java
 * 	Statics is a class for Exercise 1 of Worksheet 4 for MSc Software Workshop.
 * 	The class contains two static methods mean and standardDeviation that compute
 * 	the mean and standard deviation respectively of a non-empty ArrayList of elements.
 * 
 * 	@author 	Robert Campbell
 *	@created	2016-11-06
 */
public class Statistics {

	/**	mean is a method which computes the mean value of a non-empty 
	 * 	ArrayList of elements.
	 * 
	 * @param list	An ArrayList of type Measurable 
	 * @return		The mean value of the given ArrayList
	 */
	public static double mean(ArrayList<Measurable> list) {
		double mean = 0;
//		for (int i = 0; i < list.size(); i++) {
//			mean += list.get(i).getMeasure();
//		}
		for (Measurable i : list) {
			mean += i.getMeasure();
		}
		mean = mean / list.size();
		System.out.println("Number of items in ArrayList<Measurable> = " + list.size());
		return mean;
	}
	
	/** standardDeviation is a method which computes the standard
	 * 	deviation of a non-empty ArrayList of elements.
	 * 
	 * @param list	An ArrayList of type Measurable
	 * @return		The standard deviation of the given ArrayList
	 */
	public static double standardDeviation(ArrayList<Measurable> list) {
		double mean = mean(list);
		double sumOfSquareDistance = 0;
		double standardDeviation;
		
//		for (int i = 0; i < list.size(); i++) {
//			double distance = list.get(i).getMeasure() - mean;
//			//System.out.println("Distance = " + distance);
//			//System.out.println("Square Distance = " + Math.pow(distance, 2));
//			sumOfSquareDistance += Math.pow(distance, 2);
//		}
		
		for (Measurable stat : list) {
			double distance = stat.getMeasure() - mean;
			//System.out.println("Distance = " + distance);
			//System.out.println("Square Distance = " + Math.pow(distance, 2));
			sumOfSquareDistance += Math.pow(distance, 2);
		}
		
		//System.out.println("Sum of Square Distance = " + sumOfSquareDistance);
		standardDeviation = Math.sqrt((sumOfSquareDistance / list.size()));
		return standardDeviation;
	}
	
	public static void main(String[] args) {
		Invoice i1 = new Invoice("12345", "11-22-33", 6.00);
		Invoice i2 = new Invoice("23456", "22-33-44", 3.00);
		Invoice i3 = new Invoice("34567", "33-44-55", 2.00);
		Invoice i4 = new Invoice("45678", "44-55-66", 1.00);
		
		Patient p1 = new Patient("Robert Campbell", 1, 4.0);
		Patient p2 = new Patient("Russell Newcombe", 1, 8.0);
		Patient p3 = new Patient("John Auerbach", 1, 5.0);
		Patient p4 = new Patient("Nolah Bean", 1, 2.0);
		Patient p5 = new Patient("Liam Huxter", 1, 6.0);
		
		ArrayList<Measurable> invoiceTest = new ArrayList<Measurable>();
		ArrayList<Measurable> patientTest = new ArrayList<Measurable>();
		
		invoiceTest.add(i1);
		invoiceTest.add(i2);
		invoiceTest.add(i3);
		invoiceTest.add(i4);
		
		patientTest.add(p1);
		patientTest.add(p2);
		patientTest.add(p3);
		patientTest.add(p4);
		patientTest.add(p5);
		
//		System.out.println("Mean is " + mean(invoiceTest));
//		System.out.println("");
//		System.out.println("Mean is " + mean(patientTest));
//		
//		System.out.println("SD is " + standardDeviation(invoiceTest));
//		System.out.println("SD is " + standardDeviation(patientTest));
	}
}
