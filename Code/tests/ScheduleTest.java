import org.junit.jupiter.api.Test;

class ScheduleTest {
	
	Schedule schedule = new Schedule();
	Employee e1 = new Employee("Jiajie", "Server");
	Employee e2 = new Employee("Spancer", "Host");

	@Test
	void addTest() {
		schedule.addTimeSpan(e1, 8.00, 16.30, "MONDAY");
		schedule.displaySchedule();
		System.out.println();
	}
	
	@Test
	void addEarliestTimespan() {
		System.out.println("Test: addEarliestTimespan");
		schedule.addTimeSpan(e1, 12.00, 16.30, "MONDAY");
		schedule.addTimeSpan(e1, 8.00, 9.30, "MONDAY");
		schedule.displaySchedule();
		System.out.println();
	}
	
	@Test
	void addLatestTimespan() {
		System.out.println("Test: addLatestTimespan");
		schedule.addTimeSpan(e1, 12.00, 16.30, "MONDAY");
		schedule.addTimeSpan(e1, 8.00, 9.30, "MONDAY");
		schedule.addTimeSpan(e1, 17.00, 18.00, "MONDAY");
		schedule.displaySchedule();
		System.out.println();
	}
	
	@Test
	void addMiddle() {
		System.out.println("Test: addMiddle");
		schedule.addTimeSpan(e1, 8.00, 9.30, "MONDAY");
		schedule.addTimeSpan(e1, 12.00, 16.30, "MONDAY");
		schedule.addTimeSpan(e1, 10.00, 11.00, "MONDAY");
		schedule.addTimeSpan(e1, 17.00, 18.00, "MONDAY");
		schedule.displaySchedule();
		System.out.println();
	}
	
	@Test
	void addOverlapFront() {
		System.out.println("Test: addOverlapFront");
		schedule.addTimeSpan(e1, 8.00, 16.30, "TUESDAY");
		schedule.addTimeSpan(e1, 9.00, 17.30, "TUESDAY");
		schedule.displaySchedule();
		System.out.println();
	}
	
	@Test
	void displayEmployeeSchedule() {
		System.out.println("Test: print schedule for specific employee");
		schedule.addTimeSpan(e1, 8.00, 16.30, "MONDAY");
		schedule.addTimeSpan(e1, 8.00, 16.30, "TUESDAY");
		schedule.displayEmployeeSchedule("Jiajie");
		System.out.println();
	}
	
	@Test
	void remove() {
		System.out.println("Test: remove schedule");
		schedule.addTimeSpan(e1, 8.00, 9.30, "MONDAY");
		schedule.addTimeSpan(e1, 12.00, 16.30, "MONDAY");
		schedule.addTimeSpan(e1, 10.00, 11.00, "MONDAY");
		schedule.addTimeSpan(e1, 17.00, 18.00, "MONDAY");
		schedule.removeTimeSpan("Jiajie", 8.00, 9.30, "MONDAY");
		schedule.displaySchedule();
		System.out.println();
	}

}
