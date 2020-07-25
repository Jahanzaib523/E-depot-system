package Depots;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Transfer implements Runnable{
	String re;
	Depot To;
	Depot From;
	public Transfer(String Reg,Depot to, Depot from ){
		
		this.re = Reg;
		this.To = to;
		this.From = from;
		
	}
	public void run(){
		TransferVahicle(re,To,From);
	    }
	
public  void TransferVahicle(String Reg,Depot to, Depot from ) {
		
		List<Vehicle> temp = to.getVehicle();
		int searchListLength = temp.size();
		//System.out.println(searchListLength);
		Vehicle tempvahicle ;
		//System.out.println(searchListLength);
		for (int i = 0; i < searchListLength; i++) {
			if (temp.get(i).getRegNo().contains(Reg) && temp.get(i).isAvailable() ) {
				tempvahicle = temp.get(i);
				System.out.println("the Transfer Will Comlete in 1 Minute"); 
				
				temp.remove(i);
				try {
					TimeUnit.MINUTES.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				List<Vehicle> fromtemp =  from.getVehicle();
				fromtemp.add(tempvahicle);
				from.setVehicle(fromtemp);
				System.out.println("the Transfer of vehicle is complete"); 
				
				return;
			}
			
		}
		
			System.out.println("your Chosen Vahicle is not Avalible"); 
		
		
	}

}
