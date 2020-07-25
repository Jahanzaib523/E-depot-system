package Depots;



public class WorkSchedule {

	//Variables for the work schedule class
	    private String client;
	    private Vehicle vehicles;
	    private Driver drivers;
	    private Date startDate;
	    private Date endDate;
	    private String Status ;
	
	//Instantiating the variables
	public WorkSchedule (String client, Vehicle vehicles, Driver drivers, Date startDate, Date endDate) {
		
	    this.client = client;
	    this.vehicles = vehicles;
	    this.drivers = drivers;
   	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.Status = "panding";
		
	}
	
	//Set Methods
	public void setClient(String client) {
	    this.client = client;	
					
				}
			
	public void setStartDate(Date startDate) {
	    this.startDate = startDate;	
				
			}
			
	public void setEndDate(Date endDate) {
	    this.endDate = endDate;	
				
			}
	public void setStatus(String status) {
		this.Status = status;
	}
			
		
	//Get Methods
	
	public String getStatus() {
	    return Status;	
			
			}
    public String getClient() {
	    return client;	
			
			}
			
    public Vehicle getVehicle() {
	    return vehicles;	
			
			}
			
	public Driver getDriver() {
	    return drivers;	
			
			}
    
	public Date getEndDate() {
	    return endDate;	
			
			}
		
	public Date getStartDate() {
	    return startDate;	
			
			}
	public void Display() {
		System.out.print(" "+this.client+ " "+" "+this.vehicles.getRegNo()+" "+
				" "+this.drivers.getUsername());
		System.out.print(" ");
		startDate.printDate();
		System.out.print(" ");
		startDate.printDate();
		System.out.print(" "+Status);
		
		
		
		
	}
			
	
}
