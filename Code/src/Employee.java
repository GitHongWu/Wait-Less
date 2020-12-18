import java.sql.Timestamp;
import java.util.Date;

public class Employee{	
	private int Emp_ID;
	private String Emp_Name;
	private String Position;
	
	private Timestamp In_Time;
	private long Total_Time;
	
	public Employee() {
		this.Emp_Name = "Unknown";
		this.Position = "Error position";
		this.Emp_ID = -1;
	}
	
	public Employee(String name, String p) {
		this.Emp_Name = name;
		this.Position = p;
		this.Emp_ID = 0;
	}
	
	//Getters for private class variables
	String getEmpName() {
		return this.Emp_Name;
	}
	String getPosition() {
		return this.Position;
	}
	int getEmpID() {
		return this.Emp_ID;
	}
	
	public void setEmpID(int id) {
		this.Emp_ID = id;
	}
	
	public void clockIn() {
		
		if(this.In_Time == null) {
			//employee has not clocked in yet
			
			//get current time
			Date date = new Date();
			long time = date.getTime();
			Timestamp t = new Timestamp(time);
			this.In_Time = t;
			
			System.out.println(this.Emp_Name +" clocked in at " + t);
			
		}else {
			//employee has already clocked in
			System.out.println(this.Emp_Name + " has already clocked in at " + this.In_Time);
		}
	}
	
	public void calculateTime(long msec)
	{
		int seconds = (int) msec /1000;
		
		int hours = seconds /3600;
		int minutes = (seconds % 3600)/60;
		seconds = (seconds % 3600) % 60;
		
		System.out.println( hours + " hr " + minutes + " min " + seconds + " sec");
	}
	
	public void clockOut() {
		if(this.In_Time != null) {
			//get current time
			Date date = new Date();
			long time = date.getTime();
			Timestamp t = new Timestamp(time);
			
			//calculate time difference in seconds
			long difference = t.getTime() - this.In_Time.getTime();
			
			//print out work summary
			System.out.println(this.Emp_Name + " clocked out ");
			System.out.println("Shift Summary: ");
			calculateTime(difference);
			
			
			//add time to total work time
			this.Total_Time += difference;
			System.out.print("Total work time: ");
			calculateTime(this.Total_Time);
			//System.out.println(difference);
			//System.out.println(In_Time);
			
			//reset the In_Time
			this.In_Time = null;
			//System.out.println(In_Time);
		}else {
			System.out.println(this.Emp_Name + " is not clocked in");
		}
	}
}
