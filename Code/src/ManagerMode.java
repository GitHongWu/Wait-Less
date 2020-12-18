import java.util.Arrays;

public class ManagerMode {
	
	private Manager manager;
	private Schedule schedule;
	
	public ManagerMode(String loginName, Restaurant _restaurant) {
		this.manager = new Manager(loginName, "Manager");
		this.schedule = _restaurant.getSchedule();
	}
	
	public void parseCommand(String command, EmployeeList employeeList) {
		String[] inputs = command.split("\\s+");
		System.out.println(Arrays.toString(inputs));
		char commandHeader = inputs[0].charAt(0);
		System.out.println("Command Header: " + commandHeader);
		
		// command: ? - to list the accepted commands
		if(commandHeader == '?' && inputs.length == 1) {
			displayCommands();
		}
		// command: a <Employee Name> <Starting Time> <Ending Time> <Day of the Week> - to add time span for employee
		else if(commandHeader == 'a' && inputs.length == 5) {
			Employee employee = employeeList.employeeExist(inputs[1]);
			double timeIn = Double.parseDouble(inputs[2]);
			double timeOut = Double.parseDouble(inputs[3]);
			String dayOfWeek = inputs[4];
			schedule.addTimeSpan(employee, timeIn, timeOut, dayOfWeek);
		}
		//command: r <Employee Name> <Starting Time> <Ending Time> <Day of the Week> - to remove time span for employee
		else if(commandHeader == 'r' && inputs.length == 5) {
			String employeeName = inputs[1];
			double timeIn = Double.parseDouble(inputs[2]);
			double timeOut = Double.parseDouble(inputs[3]);
			String dayOfWeek = inputs[4];
			schedule.removeTimeSpan(employeeName, timeIn, timeOut, dayOfWeek);
		}
		else {
			System.out.println("Command not recognizable");
		}
	}
	
	public void displayCommands() {
		System.out.println("The commands for Manager Mode are: ");
		System.out.println("? - to list the accepted commands");
		System.out.println("a <Employee Name> <Starting Time> <Ending Time> <Day of the Week> - to add time span for employee");
		System.out.println("r <Employee Name> <Starting Time> <Ending Time> <Day of the Week> - to remove time span for employee");
	}
	
	
}
