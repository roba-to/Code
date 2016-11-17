import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**	Ex1Tests.java
 * 	Personal tests for Exercise 1, Worksheet 4 for MSc Software Workshop.
 * 	Tests functionality for Invoice, Patient, and Statistic classes.
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-14
 *	@version	2016-11-14
 */
public class Ex1Tests {

	@Test
	public void Ex1Test1() {
		Invoice invoice = new Invoice("123456789", "11-22-33", 1234);
		
		double expected = 1234;
		double actual = invoice.getMeasure();
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test1, expected = ", expected, actual, tolerance);
		
		String expected2 = "123456789";
		String actual2 = invoice.getAccountNumber();
		
		assertEquals("Failure in Ex1Test1, expected = ", expected2, actual2);
		
		String expected3 = "11-22-33";
		String actual3 = invoice.getSortCode();
		
		assertEquals("Failure in Ex1Test1, expected = ", expected3, actual3);
		
		String expected4 = "Account Number: 123456789\nSort Code: 11-22-33\nAmount: 1234.0";
		String actual4 = invoice.toString();
		
		assertEquals("Failure in Ex1Test1, expected = ", expected4, actual4);
	}

	@Test
	public void Ex1Test2() {
		Patient patient = new Patient("Rebecca Snower", 26, 55.5);
		
		double expected = 55.5;
		double actual = patient.getMeasure();
		double tolerance = 1e-8;
		
		assertEquals(expected, actual, tolerance);
		
		String expected2 = "Rebecca Snower";
		String actual2 = patient.getName();
		
		assertEquals("Failure in Ex1Test2, expected = ", expected2, actual2);
		
		int expected3 = 26;
		int actual3 = patient.getAge();
		
		assertEquals("Failure in Ex1Test2, expected = ", expected3, actual3);
		
		String expected4 = "Name: Rebecca Snower\nAge: 26\nWeight: 55.5kg";
		String actual4 = patient.toString();
		
		assertEquals("Failure in Ex1Test1, expected = ", expected4, actual4);
	}
	
	@Test
	public void Ex1Test3() {
		
		ArrayList<Measurable> invoices = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			invoices.add(new Invoice("Rus N", "11-22-33", i*10));
		}
		
		double expected = 55;
		double actual = Statistics.mean(invoices);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test3, expected = ", expected, actual, tolerance);
	}
	
	@Test
	public void Ex1Test4() {
		
		ArrayList<Measurable> invoices = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			invoices.add(new Invoice("Rob C", "22-33-44", 100+i));
		}
		
		double expected = 105.5;
		double actual = Statistics.mean(invoices);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test4, expected = ", expected, actual, tolerance);
	}
	
	@Test
	public void Ex1Test5() {
		
		ArrayList<Measurable> patients = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			patients.add(new Patient("Rebecca S", 26, i*10));
		}
		
		double expected = 28.7228132326;
		double actual = Statistics.standardDeviation(patients);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test5, expected = ", expected, actual, tolerance);
	}
	
	@Test
	public void Ex1Test6() {
		
		ArrayList<Measurable> patients = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			patients.add(new Patient("Liam H", 28, i*30));
		}
		
		double expected = 86.1684396980;
		double actual = Statistics.standardDeviation(patients);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test6, expected = ", expected, actual, tolerance);
	}
	
	@Test
	public void Ex1Test7() {
		
		ArrayList<Measurable> patients = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			patients.add(new Patient("Liam H", 28, i*30));
		}
		
		double expected = 165.0;
		double actual = Statistics.mean(patients);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test7, expected = ", expected, actual, tolerance);
	}
	

	@Test
	public void Ex1Test8() {
		
		ArrayList<Measurable> invoices = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			invoices.add(new Invoice("00000000000", "00-00-00", 0));
		}
		
		double expected = 0.0;
		double actual = Statistics.standardDeviation(invoices);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test8, expected = ", expected, actual, tolerance);
	}
	

	@Test
	public void Ex1Test9() {
		
		ArrayList<Measurable> patients = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			patients.add(new Patient("Mister Zero", 0, 0));
		}
		
		double expected = 0.0;
		double actual = Statistics.standardDeviation(patients);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test9, expected = ", expected, actual, tolerance);
	}
	
	@Test
	public void Ex1Test10() {
		
		ArrayList<Measurable> invoices = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			invoices.add(new Invoice("Rob C", "22-33-44", 100+i));
		}
		
		double expected = 2.8722813232;
		double actual = Statistics.standardDeviation(invoices);
		double tolerance = 1e-8;
		
		assertEquals("Failure in Ex1Test10, expected = ", expected, actual, tolerance);
	}
	
}
