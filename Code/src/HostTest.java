

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;



public class HostTest {
	
	Host host = new Host("host_test");//create host
	
	//get current time
	Date date = new Date();
	long time = date.getTime();
	Timestamp t = new Timestamp(time);
	Customer customer = new Customer("customer_test","123456", 4, t);//create customer
	Customer customer2 = new Customer("customer_test2","123456", 3, t);
	Customer customer3 = new Customer("customer_test3","123456", 2, t);
			
	@Test
	public void test() {
		
		//add a customer in waitList
		host.addWaitlist(customer);
		String ans1 = host.getWaitlist(0).getName();
		
		host.printWaitlist();
		Assert.assertEquals("customer_test", ans1);
		
		//delete customer from waitList
		System.out.println("");
		host.deleteWaitlist(customer);
		host.printWaitlist();
		int ans2 = host.getAllWaitList().size();
		Assert.assertEquals(0,ans2);
		
		//seat down customer
		System.out.println("");
		host.addWaitlist(customer);
		host.addWaitlist(customer2);
		host.addWaitlist(customer3);
		System.out.println("");
		host.printWaitlist();
		host.seatCustomer(2);
		System.out.println("");
		host.printWaitlist();
		
	}
	
	
	
	
}
