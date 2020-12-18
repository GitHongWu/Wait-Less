import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RestaurantTest {
	
	private String name = "Group 20";
	private int numOfTable = 10;
	
	private Restaurant restaurant = new Restaurant(name, numOfTable);
	
	@Test
	void addEmployeeAtRestaurant() {
		restaurant.open();
		Employee e = new Employee("Spancer", "Host");
		Employee e2 = new Employee("Jiajie", "Server");
		
		//add employee to restaurant
		restaurant.getEmployeeList().addEmp(e);
		restaurant.getEmployeeList().addEmp(e2);
		
		EmployeeList empList = new EmployeeList();
		empList.addEmp(e);
		empList.addEmp(e2);
		String s = "Spancer";
		assertEquals("Add employee fail", "Spancer",
				restaurant.getEmployeeList().getEmp_List().get(0).getEmpName());
		assertEquals("Spancer",restaurant.getEmployeeList().getEmp_List().get(0).getEmpName());
		assertEquals(empList.getEmp_List().get(0).getEmpName(),
				restaurant.getEmployeeList().getEmp_List().get(0).getEmpName());
	}
	
	@Test
	void addCustomer() {
		restaurant.open();
		//add customer to table
		Customer c1 = new Customer();
		//add customer to given table id
		restaurant.getTable(1).addCustomer(c1);
	}
	
	
	@Test
	void schedule() {
		Schedule s = new Schedule();
//		s.getSchedule()
	}

}
