
public class TimeSpan implements Comparable{
	private Employee employee;
	private double timeIn;
	private double timeOut;
	private int ID;
	
	public TimeSpan(Employee _employee, double _timeIn, double _timeOut, int _ID) {
		this.employee = _employee;
		this.timeIn = _timeIn;
		this.timeOut = _timeOut;
		this.ID = _ID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(double timeIn) {
		this.timeIn = timeIn;
	}

	public double getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(double timeOut) {
		this.timeOut = timeOut;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	@Override
	public int compareTo(Object other) {
		return (this.getTimeIn() < ((TimeSpan) other).getTimeIn() ? -1 : 
		    (this.getTimeIn() == ((TimeSpan) other).getTimeIn() ? 0 : 1)); 
    }
}
