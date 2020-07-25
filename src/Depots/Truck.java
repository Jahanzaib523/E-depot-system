package Depots;

public class Truck extends Vehicle {

	//Variable for the extra class for the truck extension of vehicle
	    private int cargoCapacity;
	
	
	////Instantiating the manager class which has been extending 
	//from the vehicle class to include all of its attributes 
	public Truck(String make, String model, int weight, String regNo, int cargoCapacity) {
		
		super(make, model, weight, regNo);
	
	    this.cargoCapacity = cargoCapacity;
	
	}
	
	//Set Method
	public void setCargoCapacity (int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
	
	//Get Method
	public int getCargoCapacity() {
		return cargoCapacity;
	}
	
	
}
