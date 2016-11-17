/**	Vehicle.java
 * 	Vehicle is a class for Exercise 2 of Worksheet 4 for Msc Software Workshop
 * 	It is a class with field variables maxSpeed and maxPassengers.
 * 
 * 	@author 	Robert Campbell
 *	@created	2016-11-06
 */
public class Vehicle {
	private double maxSpeed;
	private int maxPassengers;
	
	/**	Vehicle is a constructor for the Vehicle class. 
	 * It takes the variables maxSpeed and maxPassengers.
	 * 
	 * 	@param maxSpeed		The maximum speed (km/h) that the vehicle can travel as a double
	 * 	@param maxPassengers	The maximum numbers of passengers the vehicle can carry as an integer.
	 */
	public Vehicle(double maxSpeed, int maxPassengers) {
		if (maxSpeed <= 0.0) {
			throw new IllegalArgumentException("Max Speed must be > 0");
		}
		this.maxSpeed 		= maxSpeed;
		
		if (maxPassengers < 0) {
			throw new IllegalArgumentException("Max Passengers cannot be < 0");
		}
		this.maxPassengers 	= maxPassengers;
	}
	
	/**	Gets the maximum speed at which a vehicle can travel in km/h.
	 * 
	 * 	@return	Returns the maximum speed (km/h) that the vehicle can travel as a double
	 */
	public double getMaxSpeed() {
		return this.maxSpeed;
	}
	
	/**	Gets the maximum number of passengers a vehicle can carry.
	 * 
	 * 	@return	Returns the maximum number of passengers the vehicle can carry.
	 */
	public int getMaxPassengers() {
		return this.maxPassengers;
	}
	
	/**	Sets the maximum speed at which a vehicle can travel in km/h.
	 * 
	 * 	@param newSpeed	The new maximum speed at which the vehicle can travel in km/h (double)
	 */
	public void setMaxSpeed(double newSpeed) {
		if (maxSpeed <= 0.0) {
			throw new IllegalArgumentException("Max Speed must be > 0");
		}
		this.maxSpeed = newSpeed;
	}
	
	/**	Sets the maximum number of passengers the vehicle can carry.
	 * 
	 * @param newAmountOfPassengers	The new maximum amount of passengers the vehicle can carry (int).
	 */
	public void setMaxPassengers(int newAmountOfPassengers) {
		if (maxPassengers < 0) {
			throw new IllegalArgumentException("Max Passengers cannot be < 0");
		}
		this.maxPassengers = newAmountOfPassengers;
	}
	
	//return String representation of Vehicle object
	public String toString() {
		String speed = "The vehicle has a maximal speed of " + getMaxSpeed() + " km/h. ";
		if (getMaxPassengers() == 1) {
			return speed + "It carries 1 passenger.";
		} else {
			return speed + "It carries " + getMaxPassengers() + " passengers.";
		}
	}
	
	public static void main(String[] args) {
		//Vehicle v1 = new Vehicle(180, 1);
		//Vehicle v2 = new Vehicle(120, 4);
		//Vehicle v3 = new Vehicle(220, 0);
		
		//System.out.println(v1);
		//System.out.println(v2);
		//System.out.println(v3);
	}
}
