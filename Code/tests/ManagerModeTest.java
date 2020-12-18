import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerModeTest {
	
	private Restaurant restaurant = new Restaurant("Test Restaurant", 10);
	private ManagerMode managerMode = new ManagerMode("Mr.M", restaurant);

	@Test
	void testSplitCommands() {
		restaurant.open();
		String s = "a 12 @ asd";
		managerMode.parseCommand(s, restaurant.getEmployeeList());
	}
	
	@Test
	void testAddSchedule() {
		restaurant.open();
		String s = "a jiajie 12.30 2.45 FRIDAY";
		Employee e = new Employee("jiajie", "Server");
		EmployeeList employeeList = new EmployeeList();
		employeeList.addEmp(e);
		restaurant.setEmployeeList(employeeList);
		assertEquals(e, restaurant.getEmployeeList().employeeExist("jiajie"));
		
		managerMode.parseCommand(s, restaurant.getEmployeeList());
		restaurant.getSchedule().displaySchedule();
	}
	
	@Test
	void testRemoveSchedule() {
		restaurant.open();
		Employee e = new Employee("jiajie", "Server");
		EmployeeList employeeList = new EmployeeList();
		employeeList.addEmp(e);
		restaurant.setEmployeeList(employeeList);
		
		String s = "a jiajie 12.30 2.45 FRIDAY";
		assertEquals(e, restaurant.getEmployeeList().employeeExist("jiajie"));
		managerMode.parseCommand(s, restaurant.getEmployeeList());
		
		String s2 = "r jiajie 12.30 2.45 FRIDAY";
		managerMode.parseCommand(s2, restaurant.getEmployeeList());
		
		restaurant.getSchedule().displaySchedule();
	}
}
