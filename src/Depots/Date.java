package Depots;

public class Date {
	public int Day;
	public int month;
	public int Year;
	public Date(int d,int m, int y) {
		if((d > 0 && d <= 31 ) && (m > 3 && m< 12 ) && (y > 2019 && y < 2021 )) {
			this.Day =d;
			this.month = m;
			this.Year = y;
		}
		else {
			System.out.println("invalid Date");
			
		}
		
	}
	public void printDate() {
		System.out.print(" "+this.Day+" "+this.month+" "+this.Year);
		
	}
}
