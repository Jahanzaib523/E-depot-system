package Depots;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	//Vehicles protected variables
	    protected String make;
	    protected String model;
	    protected int weight;
	    protected String regNo;
	
	//ArrayList for workSchedule
	    protected List<WorkSchedule> workSchedules = new ArrayList<WorkSchedule>();
	    
	//Instantiating the variables
	public Vehicle (String make, String model, int weight, String regNo) {
		this.make = make;
		this.model = model;
		this.weight = weight;
		this.regNo = regNo;
		
	}
	//isAvailable method to check if the car is 
	public boolean isAvailable() {
		if(this.workSchedules.size() != 0) {
			return false;
		}
			
		return true;
	}
	
	//Set schedule method to create the schedule for the vehicle - This may be in the wrong spot also and might need changed to suit vehicle
    public void setScheduleA(WorkSchedule client, WorkSchedule  startDate, WorkSchedule endDate) {
    	workSchedules.add(client);
    	workSchedules.add(startDate);
	    workSchedules.add(endDate);
    	
    }
    
  //Set schedule method to create the schedule for the vehicle - Either this or the top and the top may not be needed 
    public void setScheduleB(WorkSchedule make, WorkSchedule  model, WorkSchedule weight, WorkSchedule regNo) {
    	workSchedules.add(make);
    	workSchedules.add(model);
	    workSchedules.add(weight);
	    workSchedules.add(regNo);
    }	
    
	//Set Methods
	public void setMake(String make) {
		this.make = make;	
				
			}
		
	public void setModel(String model) {
		this.model = model;	
			
		}
		
	public void setWeight(int weight) {
		this.weight = weight;	
			
		}
	
	public void setRegNo(String regNo) {
		this.regNo = regNo;	
			
		}
	
	//Get Methods
	public String getMake() {
	    return make;	
	
	}
	
	public String getModel() {
		return model;	
	
	}

	public int getWeight() {
		return weight;	
	
	}
	
	public String getRegNo() {
		return regNo;	
	
	}
	
}



/*this.make = make;
this.model = model;
this.weight = weight;
this.regNo = regNo;*/





