import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import java.text.DecimalFormat;
import java.time.DayOfWeek;

public class Schedule {
	
	private ArrayList<ArrayList<TimeSpan>> schedule2D;
	private int workDays;
	private ArrayList<Integer> usedTimeSpanID;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public Schedule() {
		this.schedule2D = new ArrayList<ArrayList<TimeSpan>>();
		this.workDays = 7;	//Monday though Sunday
		this.usedTimeSpanID= new ArrayList<Integer>(); 
		
		for (int i = 0; i < workDays; i++) {
			ArrayList<TimeSpan> colume = new ArrayList<TimeSpan>();
			schedule2D.add(colume);
		}
	}
	
	public ArrayList<ArrayList<TimeSpan>> getSchedule(){
		return schedule2D;
	}
	
	//assisted add time span into schedule
	public int generateID() {
		Random random = new Random();
		int ID = random.nextInt(100);
		while(usedTimeSpanID.contains(ID)) {
			ID = random.nextInt(100);
		}
		usedTimeSpanID.add(ID);
		return ID;
	}
	
	private boolean employeeTimespanExist(String employeeName, ArrayList<TimeSpan> date) {
		for (TimeSpan t : date) {
			if (t.getEmployee().getEmpName() == employeeName) {
				return true;
			}
		}
		return false;
	}
	
	// Monday 1, Tuesday 2, ... , Saturday 6, Sunday 7
	// EX. addTimeSpan(employee, 10.00, 18.00, 1);
	// If time span overlap, return false;
	@SuppressWarnings("unchecked")
	public boolean addTimeSpan(Employee employee, double timeIn, double timeOut, String dayOfWeek) {
		
		int indexDayOfWeek;
		try {
			indexDayOfWeek = DayOfWeek.valueOf(dayOfWeek).ordinal();
        } catch (Exception e) {
            System.out.println("Invaild day of week");
            return false;
        }
		
		if(employee == null) {
			System.out.println("Invaild employee object");
			return false;
		}
		
		//add time span in order
		int id = generateID();
		TimeSpan timeSpan = new TimeSpan(employee, timeIn, timeOut, id);
		schedule2D.get(indexDayOfWeek).add(timeSpan);
		Collections.sort(schedule2D.get(indexDayOfWeek));
		
		// after add one time span check only contain one time span
		if (schedule2D.get(indexDayOfWeek).size() == 1){
			System.out.println(employee.getEmpName() + " schedule add Success");
			return true;
		}
		
		//if overlap, then merge
		for (int i = 1; i < schedule2D.get(indexDayOfWeek).size(); i++) {
			TimeSpan earlyTime = schedule2D.get(indexDayOfWeek).get(i - 1);
			TimeSpan currentTime = schedule2D.get(indexDayOfWeek).get(i);
			if ( currentTime.getTimeIn() <= earlyTime.getTimeOut()) { //time in overlap
				currentTime.setTimeIn(earlyTime.getTimeIn());
				if (currentTime.getTimeOut() <= earlyTime.getTimeOut()) { // time out overlap
					currentTime.setTimeOut(earlyTime.getTimeOut());
				}
				schedule2D.get(indexDayOfWeek).remove(i - 1);
			}
		}
		System.out.println(employee.getEmpName() + " schedule add Success");
		return true;
	}
	
	public boolean removeTimeSpan(String employeeName, double timeIn, double timeOut, String dayOfWeek) {
		
		int indexDayOfWeek;
		try {
			indexDayOfWeek = DayOfWeek.valueOf(dayOfWeek).ordinal();
        } catch (Exception e) {
            System.out.println("Invaild day of week");
            return false;
        }
		
		ArrayList<TimeSpan> t = schedule2D.get(indexDayOfWeek);
		for (int i = 0; i < t.size(); i++ ) {
			if (t.get(i).getEmployee().getEmpName().compareTo(employeeName) == 0) {
				Integer recycleID = t.get(i).getID();
				schedule2D.get(indexDayOfWeek).remove(i);
				usedTimeSpanID.remove(recycleID);
				return true;
			}
		}
		return false;
	}
	
	//Given employee name, display all his/her time span 
	public void displayEmployeeSchedule(String employeeName) {
		// for loop from MONDAY though SUNDAY
		for (int i = 0; i < schedule2D.size(); i++) {
			// if employee work on that day
			if (employeeTimespanExist(employeeName, schedule2D.get(i))) {
				// print all employee timespan
				for (TimeSpan t : schedule2D.get(i)) {
					if (t.getEmployee().getEmpName() == employeeName) {
						System.out.print(DayOfWeek.of(i+1).name() + ": ");
						System.out.print(t.getID() + " " + t.getEmployee().getEmpName()
								+ " (" + String.format("%.2f", t.getTimeIn()) + "-"
								+ String.format("%.2f", t.getTimeOut()) + "); ");
					}
				}
				System.out.println();
			}
		}
	}
	
	
	public void displaySchedule() {
		for (int i = 0; i < schedule2D.size(); i++) {
			System.out.print(DayOfWeek.of(i+1).name() + ": ");
			if (schedule2D.get(i).size() == 0) {
				System.out.print("NO EMPLOYEE WORK");
			}
			else {
				for (TimeSpan t : schedule2D.get(i)) {
					System.out.print(t.getID() + " " + t.getEmployee().getEmpName()
							+ " (" + String.format("%.2f", t.getTimeIn()) + "-"
							+ String.format("%.2f", t.getTimeOut()) + "); ");
				}
			}
			System.out.println();
		}
	}
}
