/**	Car.java
 * 	Car is a class for Exercise 2, Worksheet 4 for MSc Software Workshop.
 * 	Car concrete class extends class Vehicle.
 * 	Each Car must be assigned a fuel consumption rate.
 * 
 * 	@author 	Robert Campbell
 *	@created	2016-11-06
 */
public class Car extends Vehicle{
	private double fuelConsumption;
	
	/** Constructor for Car class.
	 * 
	 * @param maxSpeed			The maximal speed of the car in km/h (double)
	 * @param maxPassengers		The maximum number of passengers the car can carry (int)
	 * @param fuelConsumption	The car's fuel consumption rate.
	 */
	public Car(double maxSpeed, int maxPassengers, double fuelConsumption){
		super(maxSpeed, maxPassengers);
		
		if (fuelConsumption <= 0.0) {
			throw new IllegalArgumentException(
					"Fuel Consumption rate must be >= 0");
		}
		
		this.fuelConsumption = fuelConsumption;
	}
	
	/**	Gets the fuel consumption rate of the car.
	 * 
	 * @return	The fuel consumption rate of the car (double).
	 */
	public double getFuelConsumption() {
		return this.fuelConsumption;
	}
	
	/**	Sets the fuel consumption rate of the car.
	 * 
	 * @param newRate	The new fuel consumption rate of the car (double).
	 */
	public void setFuelConsumption(double newRate) {
		if (fuelConsumption <= 0.0) {
			throw new IllegalArgumentException(
					"Fuel Consumption rate must be > 0");
		}
		this.fuelConsumption = newRate;
	}
	
	@Override
	//return String representation of Car object
	public String toString() {
		return super.toString() + " Its fuel consumption is " + getFuelConsumption() + " l/100km.";
	}
	
	public static void main(String[] args) {
		Car c1 = new Car(180, 1, 6.1);
		Car c2 = new Car(120, 4, 5.7);
		Car c3 = new Car(220, 0, 10.0);
				
		System.out.println(c1 + "\n");
		System.out.println(c2 + "\n");
		System.out.println(c3 + "\n");
	}
	
}
