package defaultPackage;
import java.text.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;




import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import Depots.*;
public class system {
	public static final String DATE_FORMAT_NOW = "dd-MM-yyyy";
	
	

	public static void main(String[] args) throws FileNotFoundException, ParseException 
	{
		
		 Depot leeds = new Depot("Leeds");
		 Depot Lpool = new Depot("LPool");
		 Depot MChester = new Depot("MChester");
		Lpool.Readtruck("C:\\Users\\inoce\\eclipse-workspace\\eDepot\\Vehicle.csv", "C:\\Users\\inoce\\eclipse-workspace\\eDepot\\Truck.csv");
		Lpool.Readtanker("C:\\Users\\inoce\\eclipse-workspace\\eDepot\\Vehicle.csv", "C:\\Users\\inoce\\eclipse-workspace\\eDepot\\Tanker.csv");
		Lpool.ReadDriver("C:\\Users\\inoce\\eclipse-workspace\\eDepot\\Driver.csv");
		
		
		for(;;)
		{
			//taking input for logon
			Scanner input1 = new Scanner(System.in);
			
			System.out.println("Please Enter your Name : ");
			String user = input1.nextLine();
			
			System.out.println("Please Enter your password : ");
			String pass = input1.nextLine();
			System.out.println(user+pass);
			int d  = Lpool.logOn(user, pass);
			if(Lpool.logOn(user, pass) != 0) {
				System.out.println("Login Successful");
				DriverMenu(d,Lpool);
			}
			if(user.compareTo(Lpool.Manager) == 0  && pass.compareTo("_Glyn") == 0) {
					MenagerMenu(Lpool,leeds,MChester);
			}
			else if(user.compareTo(leeds.Manager) == 0 && pass.compareTo("_Kirsty") == 0) {
					MenagerMenu(leeds,Lpool,MChester);
			}
			else if(user.compareTo(MChester.Manager) == 0 && pass.compareTo("_Sorren") == 0) {
					MenagerMenu(MChester,leeds,Lpool);
			}
			else 
			{
					System.out.println("Login unSuccessful");
			}
				
			
			
			
		}
			
			
		
		
		
	}		
	// if Driver logon then this menu will open
	public static void DriverMenu(int index,Depot D) throws ParseException {
		
		for(;;) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter A to View the Schaduale ");
        System.out.println("Enter S to Set the Schaduale ");
        System.out.println("Enter Q to Sign out");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
       
        
        System.out.print("Please Enter your choice : ");
       
        char c = input.next().charAt(0);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        
        if (c == 'q' || c == 'Q' )
        {
        	System.out.println("You Have Been loggong out");
        	return;
        	
        }
        else if(c == 'A' || c == 'a') {
        	
        	List<Driver> temp = D.getDriver();
        	Driver tempdriver = temp.get(index);
        	System.out.println("Client  Driver  Vehicle  Start Date  End Date  Status");
        	tempdriver.DisplayScheduale();
        
        	
        }
        else if(c == 'S' || c == 's') {
        	
        	Scanner myObj = new Scanner(System.in);
        	System.out.println("Please Write the Client's name :");
        	String name = myObj.nextLine();
        	
        	System.out.println("Please Write the Start Date format(dd-mm-yyyy ) :");
        	String startDate = myObj.nextLine();
        	String[] arrOfStr1 = startDate.split("-");
        	Date start = new Date(Integer.parseInt(arrOfStr1[0].trim()),Integer.parseInt(arrOfStr1[1].trim()),Integer.parseInt(arrOfStr1[2].trim()));
        	System.out.println("Please Write the End Date format(dd-mm-yyyy):");
        	String endDate = myObj.nextLine();
        	String[] arrOfStr2 = endDate.split("-");
        	Date end = new Date(Integer.parseInt(arrOfStr2[0].trim()),Integer.parseInt(arrOfStr2[1].trim()),Integer.parseInt(arrOfStr2[2].trim()));
        	
        	
        	
        	
        	D.listTrucks();
        	D.listTankers();
        	
        	System.out.println("Please Select Your Vahicle:");
        	String Truck = myObj.nextLine();
        	Driver tempDriver= D.getDriver().get(index); 
        	Vehicle tempvehicle = D.SearchVehicles(Truck);
        	
        	String getnow = now();
        	String[] arrOfStr3 = getnow.split("-");
        	
        	if(datechecker(arrOfStr1,arrOfStr3) == true) {
        		WorkSchedule Temp = new WorkSchedule(name, tempvehicle, tempDriver, start, end);
        		List<WorkSchedule> temp = D.getWorkScheduale();
        		temp.add(Temp);
        		tempDriver.setSchedule(Temp);
        		D.setUpWorkSchedules(temp);
        		D.checkStatus();
        	}
        	
        	else {
        		System.out.println("A work schedule initially exists in a pending state with the job start date and time being no less than 48 hours in\r\n" + 
        				"advance and with a maximum duration of 72 hours");
        	}
        
        	
        }
        
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
		}
		
		
	}
	//if Manager logon then this menu will open
	public static void MenagerMenu(Depot D,Depot Leeds,Depot MC) {
		
		for(;;) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter V to View the Schaduale ");
        System.out.println("Enter S to Set the Schedulale  ");
        System.out.println("Enter L to list the Vehicles  ");
        System.out.println("Enter T Change Transfer the Vahicle to Another Depot ");
        System.out.println("Enter A add A new Driver ");
        System.out.println("Enter B to Add a new Vehicle ");
        
        
        System.out.println("Enter Q to Sign out");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
       
        
        System.out.print("Please Enter your choice : ");
       
        char c = input.next().charAt(0);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        
        if (c == 'l' || c == 'L' )
        {
        	System.out.println("You Have Been loggong out");
        	
        	return;
        }
        
        else if (c == 'q' || c == 'Q' )
        {
        	System.out.println("You Have Been loggong out");
        	
        	return;
        }
        else if(c == 'A' || c == 'a') {
        	Scanner myObj = new Scanner(System.in);
        	System.out.println("Please Enter the Name OF the Driver ");
        	String userName = myObj.nextLine();
        	
        	
        	System.out.println("Please Enter the Password ");
        	String userpassword = myObj.nextLine();
        	Driver tempdriver = new Driver(userName, userpassword);
        	List<Driver> Temp = D.getDriver();
        	Temp.add(tempdriver);
        	//D.setDrivers(Temp);
        	
        	
        }
        else if(c == 'B' || c == 'b') {
        	Scanner myObj = new Scanner(System.in);
        	System.out.println("Please the Maker Of the Vehicle :");
        	String make = myObj.nextLine();
        	
        	
        	System.out.println("Please Enter the Model ");
        	String model = myObj.nextLine();
        	
        	System.out.println("Please Enter the Waight ");
        	String waight = myObj.nextLine();
        	
        	System.out.println("Please Enter the Rergister NO : ");
        	String regno = myObj.nextLine();
        	
        	System.out.println("Please Spacify the Type of Vahicle  ");
        	System.out.println("1 : Truck  ");
        	System.out.println("2 : Tanker");
        	String type = myObj.nextLine();
        	
        	if( type.compareTo("1") == 0) {
        		System.out.println("Please Enter the Capacity : ");
            	String capacity = myObj.nextLine();
            	Truck Temptruck = new Truck(make, model, Integer.parseInt(waight.trim()), regno, Integer.parseInt(capacity.trim())); 
            	List<Vehicle> Temp = D.getVehicle();
            	if(D.Duplicatefinder(regno) != true)
            		Temp.add(Temptruck);
            	else
            		System.out.println("Vehicle of this Registration numer is alredy present in this Depot ");
        	}
        	else if( type.compareTo("2") == 0) {
        		System.out.println("Please Enter the LiQuid Capacity : ");
            	String capacity = myObj.nextLine();
            	System.out.println("Please Enter the LiQuid Type : ");
            	String LiquidType = myObj.nextLine();
            	
            	Tanker Temptruck = new Tanker(make, model, Integer.parseInt(waight.trim()), regno, Integer.parseInt(capacity.trim()),LiquidType); 
            	List<Vehicle> Temp = D.getVehicle();
            	if(D.Duplicatefinder(regno) != true)
            		Temp.add(Temptruck);
            	else
            		System.out.println("Vehicle of this Registration numer is alredy present in this Depot ");
        	}
        	
        	
        }
        else if(c == 'T' || c == 't') {
        	Scanner myObj = new Scanner(System.in);
        	System.out.println("Where to Transfer  :");
        	String Depo = myObj.nextLine();
        	System.out.println("Give the Reg No :");
        	D.listTrucks();
        	D.listTankers();
        	String reg = myObj.nextLine();
        	if(Depo.compareTo(Leeds.getDepot()) == 0) {
        		Transfer Temp = new Transfer(reg,D,Leeds);
        		Thread thread = new Thread(Temp);
        		thread.start();
        	}
        	else if(Depo.compareTo(MC.getDepot()) == 0){
        		Transfer Temp = new Transfer(reg,D,MC);
        		Thread thread = new Thread(Temp);
        		thread.start();
        	}
        	
        	else {
        		System.out.println(" Depot name is Not Correct ");
        	}
        	
        	
        	
        	
        	
        	
        	
        }
        else if(c == 's' || c == 'S') {
        	Scanner myObj = new Scanner(System.in);
        	System.out.println("Please Write the Client's name :");
        	String name = myObj.nextLine();
        	
        	System.out.println("Please Write the Start Date format(dd-mm-yyyy ) :");
        	String startDate = myObj.nextLine();
        	String[] arrOfStr1 = startDate.split("-");
        	Date start = new Date(Integer.parseInt(arrOfStr1[0].trim()),Integer.parseInt(arrOfStr1[1].trim()),Integer.parseInt(arrOfStr1[2].trim()));
        	System.out.println("Please Write the End Date format(dd-mm-yyyy):");
        	String endDate = myObj.nextLine();
        	String[] arrOfStr2 = endDate.split("-");
        	Date end = new Date(Integer.parseInt(arrOfStr2[0].trim()),Integer.parseInt(arrOfStr2[1].trim()),Integer.parseInt(arrOfStr2[2].trim()));
        	
        	
        	
        	
        	D.listDrivers();
        	System.out.println("Please Select Your Driver:");
        	String driver = myObj.nextLine();
        	D.listTrucks();
        	D.listTankers();
        	
        	System.out.println("Please Select Your Vahicle:");
        	String Truck = myObj.nextLine();
        	Driver tempDriver= D.SearchDriver(driver); 
        	Vehicle tempvehicle = D.SearchVehicles(Truck);
        	
        	String getnow = now();
        	String[] arrOfStr3 = getnow.split("-");
        	
        	if(datechecker(arrOfStr1,arrOfStr3) == true) {
        		WorkSchedule Temp = new WorkSchedule(name, tempvehicle, tempDriver, start, end);
        		List<WorkSchedule> temp = D.getWorkScheduale();
        		temp.add(Temp);
        		tempDriver.setSchedule(Temp);
        		D.setUpWorkSchedules(temp);
        		D.checkStatus();
        	}
        	
        	else {
        		System.out.println("A work schedule initially exists in a pending state with the job start date and time being no less than 48 hours in\r\n" + 
        				"advance and with a maximum duration of 72 hours");
        	}
        	
        	
        	
        	
        	
        	
        	
        	
        	
        }
        else if(c == 'V' || c == 'v') {
        	int searchListLength = D.getWorkScheduale().size();
			System.out.println("Client  Driver  Vehicle  Start Date  End Date  Status");
        	
			for (int i = 0; i < searchListLength; i++) {
				D.getWorkScheduale().get(i).Display();
			}        	
        	
        }
        
       
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
		}
		
	}
	//taking todays date
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
		}
	//check date is not away from 72 hours and before 48 hours
	public static boolean datechecker(String [] arr1, String [] arr2) {
		
		int day1 = Integer.parseInt(arr1[0].trim());
		int day2 = Integer.parseInt(arr2[0].trim());
		int mon1 = Integer.parseInt(arr1[1].trim());
		int mon2 = Integer.parseInt(arr2[1].trim());
		if((day1 > day2 && mon1 == mon2) && day1< day2+3) {
			return true;
		}
		return false;
		
		
		
	}
	
	}
	


