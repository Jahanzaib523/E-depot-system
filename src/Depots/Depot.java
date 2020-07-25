package Depots;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Depot {
	
	    private static final Object[] Thread = null;
		//ArrayList for driver and vehicles
	    private String depot;
	    private List<Driver> drivers = new ArrayList<Driver>();
	    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	    private List<WorkSchedule> workSchedules = new ArrayList<WorkSchedule>();
	    public String Manager;
	
	    //Instantiating the depot class
		public Depot(String depot) {
		    this.depot = depot;
		    if(depot == "LPool") {
		    	this.Manager = "Glyn";
		    }
		    else if(depot == "MChester") {
		    	this.Manager = "Sorren";
		    }
		    else
		    {
		    	this.Manager = "Kirsty";
		    }
		    
		
	    }
    
		//Method for LogOn
		public int logOn(String userName, String passWord) {
			
			int searchListLength = this.drivers.size();
			//System.out.println(searchListLength);
			for (int i = 0; i < searchListLength; i++) {
			if (this.drivers.get(i).getUsername().contains(userName) && this.drivers.get(i).getPassword().contains(passWord)) {
				
				return i;
			}
			}
			return 0;
			
			
		}
 
		//Method for getDriver (List may not be needed and changed but wait till configured)
		public List<Driver> getDriver() {
			 
			return drivers;
			
		}
		public List<WorkSchedule> getWorkScheduale() {
			 
			return this.workSchedules;
			
		}

		//Method for getVehicle (List may not be needed and changed but wait till configured))
		public List<Vehicle> getVehicle() {
			return vehicles;	
				
			}
		
		//SetUpWorkSchedule (Potenital) 
		public void setUpWorkSchedules(List<WorkSchedule> l) {
		 this.workSchedules = l ;
				}
		
		//Method for getDepot
		public String getDepot() {
			return depot;
		}

		//Method for setDepot
		public void setDepot(String depot) {
			this.depot = depot;
		}
		public void setVehicle(List<Vehicle> l) {
			this.vehicles = l;
		}
		public void ReadDriver(String csvFile)
		{
			 	
		        BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";

		        try {

		            br = new BufferedReader(new FileReader(csvFile));
		            line = br.readLine();
		            while ((line = br.readLine()) != null) {

		                // use comma as separator
		                String[] country = line.split(cvsSplitBy);
		                Driver D = new Driver(country[0], country[1]);
		                this.drivers.add(D);

		                //System.out.println(country[0] +  country[1] );

		            }

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (br != null) {
		                try {
		                    br.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }

		    }
		
		public void ReadManager(String csvFile)
		{
			 	
		        BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";

		        try {

		            br = new BufferedReader(new FileReader(csvFile));
		            line = br.readLine();
		            while ((line = br.readLine()) != null) {

		                // use comma as separator
		                String[] country = line.split(cvsSplitBy);
		                Manager D= new Manager(country[0], country[1]);
		                this.drivers.add(D);


		            }

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (br != null) {
		                try {
		                    br.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }

		    }
		
		public void Readtruck(String csvFile, String csv2)
		{
			 	
		        BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";
		        BufferedReader br1 = null;
		        String line1 = "";

		        try {

		            br = new BufferedReader(new FileReader(csvFile));
		            br1 = new BufferedReader(new FileReader(csv2));
		            line = br.readLine();
		            line1 = br1.readLine();
		            while ((line = br.readLine()) != null  && (line1 = br1.readLine()) != null) {

		                // use comma as separator
		                String[] vahicle = line.split(cvsSplitBy);
		                String[] truck = line1.split(cvsSplitBy);
		                Truck newTruck = new Truck(vahicle[0],vahicle[1] ,Integer.parseInt(vahicle[2].trim()) , vahicle[3], Integer.parseInt(truck[0].trim()));
		               


		               
		                
		                if(Duplicatefinder(vahicle[3])!= true)
			            	  this.vehicles.add(newTruck);
		                

		                

		            }

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (br != null) {
		                try {
		                    br.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }

		    }
		public void Readtanker(String csvFile, String csv2)
		{
			 	
		        BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";
		        BufferedReader br1 = null;
		        String line1 = "";

		        try {

		            br = new BufferedReader(new FileReader(csvFile));
		            br1 = new BufferedReader(new FileReader(csv2));
		            for(int i = 0; i< 6;i++) {
		            	line = br.readLine();
		            }
		            
		            line1 = br1.readLine();
		            while ((line = br.readLine()) != null  && (line1 = br1.readLine()) != null) {

		                // use comma as separator
		                String[] vahicle = line.split(cvsSplitBy);
		                String[] truck = line1.split(cvsSplitBy);
		                Tanker newTruck = new Tanker(vahicle[0],vahicle[1] ,Integer.parseInt(vahicle[2].trim()) , vahicle[3], Integer.parseInt(truck[0].trim()),truck[1]);
		              
		              if(Duplicatefinder(vahicle[3])!= true)
		            	  this.vehicles.add(newTruck);
		              
		                

		                

		            }

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (br != null) {
		                try {
		                    br.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }

		    }
		//Set Method for Drivers
		public void setDrivers(List<Driver> drivers) {
			this.drivers = drivers;
		} 
		
		public void listDrivers() {
			int searchListLength = this.drivers.size();
			System.out.println("Here is the list of Drivers in this Depot "+depot+" :");
			for (int i = 0;   i < searchListLength; i++) {
			
					System.out.println(this.drivers.get(i).getUsername());
					
				
				
			}
			 
			
		}
	
		public void listTrucks() {
			int searchListLength = this.vehicles.size();
			System.out.println("Here is A list of Trucks :");
			for (int i = 0;   i < searchListLength; i++) {
				if(this.vehicles.get(i) instanceof Truck){
					// do something
					System.out.println(this.vehicles.get(i).getRegNo()+"   ");
					} else {
						
					}
				
			}
			 
			
		}
		public void listTankers() {
			int searchListLength = this.vehicles.size();
			System.out.println("	Here is A list of Tankers :");
			for (int i = 0;   i < searchListLength; i++) {
				if(this.vehicles.get(i) instanceof Tanker){
					// do something
					System.out.println("			"+this.vehicles.get(i).getRegNo( ));
					} else {
						
					}
				
			}
			 
			
		}
		public Vehicle SearchVehicles(String name) {
			int searchListLength = this.vehicles.size();
			for (int i = 0;   i < searchListLength; i++) {
				if (this.vehicles.get(i).regNo.contains(name) && this.vehicles.get(i).isAvailable()) {
					//System.out.println(" This  vahicle is Avalile" );
					return this.vehicles.get(i);
				}
			}
			return null;
		}
		public Driver SearchDriver(String name) {
			int searchListLength = this.vehicles.size();
			for (int i = 0;   i < searchListLength; i++) {
				if (this.drivers.get(i).getUsername().contains(name) && this.drivers.get(i).isAvailable()) {
					//System.out.println(" This  vahicle is Avalile" );
					return this.drivers.get(i);
				}
			}
			return null;
		}
		public boolean Duplicatefinder(String regno) {
			
			int searchListLength = this.vehicles.size();
			//System.out.println(searchListLength);
			for (int i = 0; i < searchListLength; i++) {
			if (this.vehicles.get(i).getRegNo().contains(regno)) {
				
				return true;
			}
			}
			return false;
			
		}
		@SuppressWarnings("null")
		public void checkStatus() {
			int searchListLength = this.workSchedules.size();
			List<Thread> thread = new ArrayList<Thread>();
			//System.out.println(searchListLength);
			for (int i = 0; i < searchListLength; i++) {
				/*Transfer Temp = new Transfer(reg,D,MC);
        		Thread thread = new Thread(Temp);
        		thread.start()*/
				StatucChecker temp = new StatucChecker(this.workSchedules.get(i));
				Thread th = new Thread(temp);
				thread.add(th);
				
        		
			}
			
			
		}
	
		
}











