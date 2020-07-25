

package Depots;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	//Variables for the driver
	    protected String userName;
	    protected String passWord;
	
	//ArrayList for workSchedule
	    protected List<WorkSchedule> workSchedules = new ArrayList<WorkSchedule>();
	    
	
	//Instantiating the variables
	public Driver (String userName, String passWord) {
		
	    this.userName = userName;
	    this.passWord = passWord;
		
	}
	
	//CheckPassword method to see if password is correct
	public boolean checkPassword(String userName, String passWord) {
			
		return false;
	}
			
	//isAvailable to check if details are there
	public boolean isAvailable() {
		if(this.workSchedules.size() != 0) {
			return false;
		}
			
		return true;
			
	    }
	    
	//Set schedule method to create the schedule for the driver
    public void setSchedule(WorkSchedule userName) {
	    	workSchedules.add(userName);
	    	
	    	
	    }
	    
    //Set Methods
	public void setUsername(String userName) {
		this.userName = userName;	
				
			}
		
	public void setPassword(String passWord) {
		this.passWord = passWord;	
			
		}

	//Get Methods 
    public String getUsername() {
		return userName;	
	
	}
	
	public String getPassword() {
		return passWord;	
	
	}
	
	public void DisplayScheduale() {
		System.out.println("Client  Driver  Vehicle  Start Date  End Date");
		int searchListLength = this.workSchedules.size();
		for (int i = 0; i < searchListLength; i++) {
			this.workSchedules.get(i).Display();
		
		}
	}
   
}
