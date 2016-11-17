import static org.junit.Assert.*;
import org.junit.Test;
/**	
 * 	Ex2Tests.java
 * 	Personal tests for Exercise 2, Worksheet 4 for MSc Software Workshop.
 * 	Tests functionality of Vehicle and Car classes.	
 * 
 *	@author		Robert Campbell
 *	@created	2016-11-06
 *	@version	2016-11-14
 */
public class Ex2Tests {
	
	@Test
	public void Ex2Test1() {
		Vehicle v1 = new Vehicle(100, 0);
		double v1MaxSpeed = 100;
		double v1Passengers = 0;
		
		assertEquals("Failure in Ex2Test2, expected = ", 
				v1MaxSpeed, 
				v1.getMaxSpeed(), 
				0.0);
		assertEquals("Failure in Ex2Test1, expected = ", 
				v1Passengers, 
				v1.getMaxPassengers(), 
				0.0);
		assertEquals("Failure in Ex2Test1, expected String = ", 
				"The vehicle has a maximal speed of 100.0 km/h. It carries 0 passengers.", 
				v1.toString());
	}
		
	@Test
	public void Ex2Test2() {
		
		Vehicle v2 = new Vehicle(75.5, 1);
		double v2MaxSpeed = 75.5;
		double v2Passengers = 1;
		
		assertEquals("Failure in Ex2Test2, expected = ", 
				v2MaxSpeed, 
				v2.getMaxSpeed(), 
				0.0);
		assertEquals("Failure in Ex2Test1, expected = ", 
				v2Passengers, 
				v2.getMaxPassengers(), 
				0.0);
		assertEquals("Failure in Ex2Test1, expected String = ", 
				"The vehicle has a maximal speed of 75.5 km/h. It carries 1 passenger.", 
				v2.toString());
	}
	
	@Test
	public void Ex2Test3() {
		
		Vehicle v3 = new Vehicle(123.45, 11);
		double v3MaxSpeed = 123.45;
		double v3Passengers = 11;
		
		assertEquals("Failure in Ex2Test2, expected = ", 
				v3MaxSpeed, 
				v3.getMaxSpeed(), 
				0.0);
		assertEquals("Failure in Ex2Test1, expected = ", 
				v3Passengers, 
				v3.getMaxPassengers(), 
				0.0);
		assertEquals("Failure in Ex2Test1, expected String = ", 
				"The vehicle has a maximal speed of 123.45 km/h. It carries 11 passengers.", 
				v3.toString());
	}
		

	@Test
	public void Ex2Test4() {
		Car c1 = new Car(120, 0, 5.0);
		double c1MaxSpeed = 120;
		double c1MaxPassengers = 0;
		double c1FuelConsumption = 5.0;
		
		assertEquals("Failure in Ex2Test2, expected = ", 
					c1MaxSpeed, 
					c1.getMaxSpeed(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected = ", 
					c1MaxPassengers, 
					c1.getMaxPassengers(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected = ", 
					c1FuelConsumption, 
					c1.getFuelConsumption(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected String = ", 
					"The vehicle has a maximal speed of 120.0 km/h. It carries 0 passengers. Its fuel consumption is 5.0 l/100km.", 
					c1.toString());
	}
	
	@Test
	public void Ex2Test5() {
		
		Car c2 = new Car(210.5, 1, 7.25);
		double c2MaxSpeed = 210.5;
		double c2MaxPassengers = 1;
		double c2FuelConsumption = 7.25;
		
		assertEquals("Failure in Ex2Test2, expected = ", 
					c2MaxSpeed, 
					c2.getMaxSpeed(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected = ", 
					c2MaxPassengers, 
					c2.getMaxPassengers(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected = ", 
					c2FuelConsumption, 
					c2.getFuelConsumption(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected String = ", 
					"The vehicle has a maximal speed of 210.5 km/h. It carries 1 passenger. Its fuel consumption is 7.25 l/100km.", 
					c2.toString());
	}
	
	@Test
	public void Ex2Test6() {
		Car c3 = new Car(555.55, 55, 55.5);
		double c3MaxSpeed = 555.55;
		double c3MaxPassengers = 55;
		double c3FuelConsumption = 55.5;
		
		assertEquals("Failure in Ex2Test2, expected = ", 
					c3MaxSpeed, 
					c3.getMaxSpeed(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected = ", 
					c3MaxPassengers, 
					c3.getMaxPassengers(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected = ", 
					c3FuelConsumption, 
					c3.getFuelConsumption(), 
					0.0);
		assertEquals("Failure in Ex2Test2, expected String = ", 
					"The vehicle has a maximal speed of 555.55 km/h. It carries 55 passengers. Its fuel consumption is 55.5 l/100km.", 
					c3.toString());
		
	}

}
