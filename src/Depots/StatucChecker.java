package Depots;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class StatucChecker implements Runnable {
	public static final String DATE_FORMAT_NOW = "dd-MM-yyyy";
	WorkSchedule Temp;
	public StatucChecker(WorkSchedule l) {
		Temp = l;
		
	}
	@Override
	public void run() {
		while(Temp.getStatus().compareTo("Archive") != 0) {
			statusChanger(Temp);
			try {
				TimeUnit.MINUTES.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
		}
	public void statusChanger(WorkSchedule temp) {
		String getnow = now();
    	String[] arrOfStr3 = getnow.split("-");
    	int day = Integer.parseInt(arrOfStr3[0].trim());
		int mon = Integer.parseInt(arrOfStr3[1].trim());
		int year = Integer.parseInt(arrOfStr3[2].trim());
		Date Now = new Date(day,mon,year);
		if (datechecker(temp.getStartDate(), Now) == 1) {
			temp.setStatus("Active");
			this.Temp = temp;
		}
		else if (datechecker(temp.getStartDate(), Now) == 2) {
			temp.setStatus("Archive");
			this.Temp = temp;
			return;
		}
		
	
	}
	public static int datechecker(Date First, Date today) {
		
		
		if(First.Day == today.Day && First.month == today.month && First.Year == today.Year) {
			return 1;
		}
		else if(First.Day > today.Day && First.month == today.month && First.Year == today.Year) {
			return 2;
		}
		return 0;
	}

}
