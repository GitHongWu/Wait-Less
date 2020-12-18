import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class mainTest {
	
	private String loginType = "LoginType Unknown";
	

	@Test
	void test() {
		String name = "Group 20";
		int numOfTable = 10;
		
		Restaurant restaurant = new Restaurant(name, numOfTable);
		
		restaurant.open();
		
		//checking user name and password
		//return boolean, but also return loginType as reference
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		String loginName = in.nextLine();
		System.out.print("Please enter your password: ");
        String loginPassword = in.nextLine();
        
		while(!loginValidate(loginName)) {
			System.out.println("Invalidate");
			System.out.print("Please enter your name: ");
			loginName = in.nextLine();
			System.out.print("Please enter your password: ");
			loginPassword = in.nextLine();
			System.out.println(loginType);
		}
		
		//getting into different mode
		if (loginType == "manager") {
			System.out.println("You are loginning as Manager: " + loginName);
			managerMode(loginName, restaurant);
		}
		else if (loginType == "host") {
			System.out.println("You are loginning as Host: " + loginName);
			hostMode(loginName);
		}
		else if (loginType == "server") {
			System.out.println("You are loginning as Server: " + loginName);
			serverMode(loginName);
		}
		else {
			System.out.println("LoginType something wrong ...");
		}
		
		System.out.println("Exiting Application...");
		
	}

	private boolean loginValidate(String loginName) {
		if (loginName.equals("manager")) {
			loginType = "manager";
			return true;
		}
		else if (loginName == "host") {
			loginType = "host";
			return true;
		}
		else if (loginName == "server") {
			loginType = "server";
			return true;
		}
		return false;
	}
	
	private void managerMode(String loginName, Restaurant restaurant) {
		//Only can pass Manager into ManagerMode
		ManagerMode managerMode = new ManagerMode(loginName, restaurant);
		managerMode.displayCommands();
		System.out.print("Enter command: ");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		while (!command.equals("q")) {
			managerMode.parseCommand(command, restaurant.getEmployeeList());
			System.out.print("Enter command: ");
			command = in.nextLine();
		}
		System.out.println("Exiting manager mode");
	}
	
	private void serverMode(String loginName) {
		// TODO Auto-generated method stub
		
	}

	private void hostMode(String loginName) {
		// TODO Auto-generated method stub
		
	}

}
