package Depots;

public class Tanker extends Vehicle {

	//Variables for the extra classes for the tanker extension of vehicle
	    private int liquidCapacity;
	    private String liquidType;
	
	//Instantiating the manager class which has been extending 
	//from the vehicle class to include all of its attributes 
	public Tanker(String make, String model, int weight, String regNo, int liquidCapacity, String liquidType) {
		
		super(make, model, weight, regNo);
		
		this.liquidCapacity = liquidCapacity;
		this.liquidType = liquidType;
	
	}
	
	//Set Methods
		public void setLiquidCapacity (int liquidCapacity) {
			
			this.liquidCapacity = liquidCapacity;
		}
		
        public void setLiquidType (String liquidType) {
			
			this.liquidType = liquidType;
		}
		
	//Get Methods
		public int getLiquidCapacity() {
			return liquidCapacity;
		}
	
		public String getLiquidType() {
			return liquidType;
		}
	
	
	
	
}
