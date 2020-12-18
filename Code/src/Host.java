import java.util.ArrayList;

import org.hamcrest.core.Is;

public class Host extends Employee{

	private ArrayList<Customer> Wait_List = new ArrayList<Customer>();
	private ArrayList<Customer> Reservation= new ArrayList<Customer>();
	public Host(String name) {
		super(name, "Host");
		// TODO Auto-generated constructor stub
	}
	
	
//functions for Wait_List
	public boolean findCustomer(Customer c){
		if(Wait_List != null) {
			for(Customer x: Wait_List)
			{
				if(x == c)
				{
					return true;
				}
			}
		}
		return false;
	}
	public Customer findCustomerByName(String name){
		if(Wait_List != null) {
			for(Customer x: Wait_List)
			{
				if(x.getName().equals(name))
				{
					return x;
				}
			}
		}
		return null;
	}
	
	public Customer findCustomerBySize(int size){
		if(Wait_List != null) {
			for(Customer x: Wait_List)
			{
				if(x.getPartysize() <= size) {
					return x;
				}
			}
		}
		return null;
	}
	
	public Customer findCustomerByPhone(String phone) {
		if(Wait_List != null) {
			for(Customer x: Wait_List) {
				if(x.getPhone().equals(phone)) {
					return x;
				}
			}
		}
		return null;
	}
	
	public ArrayList<Customer> getAllWaitList(){
		return Wait_List;
	}
	
	public Customer getWaitlist(int position) {
		return Wait_List.get(position);
	}
	
	public void printWaitlist() {
		for(Customer c: Wait_List) {
			System.out.println("Name: " + c.getName() +
								" Size: " + c.getPartysize() +
								" Phone: " + c.getPhone() +
								" Time:" + c.getTime());
		}
	}
	
	public String getAllWaitlist() {
		String tmp = "";
		int count = 1;
		for(Customer c: Wait_List) {
			tmp = tmp + ("Customer " + count + ": " +
					"  Name: " + c.getName() + 
								"   Size: " + c.getPartysize() +
								"   Phone: " + c.getPhone() +
								"   Time:" + c.getTime() + "\n");
			count ++;
		}
		return tmp;
	}
	public void addWaitlist(Customer c) {
		if(findCustomer(c) == false) {
			this.Wait_List.add(c);
			System.out.println("Customer " + c.getName() + " is added to the waitlist at position " + Wait_List.indexOf(c) );
		}
		else {
			System.out.println("Customer " + c.getName() + " is already in the waitlist.");
		}
	}
	
	public void deleteWaitlist(Customer c) {
		if(findCustomer(c) == true) {
			Wait_List.remove(c);
			System.out.println("Customer " + c.getName() + " is deleted from the waiting list");
		}else {
			System.out.println("Customer " + c.getName() + "is not in the waitlist");
		}
	}
	
	public Customer seatCustomer(int size) {
		Customer c = null;
		
		if(Wait_List == null)
		{
			System.out.println("No customer is in the waitlist");
			return null;
		}else {
			c = findCustomerBySize(size);
			if(c == null) {
				System.out.println("No party size " + size +" is found in waitlist");
				return null;
			}
			System.out.println("Seating down customer " + c.getName() +" right now...");
			deleteWaitlist(c);
		}
		return c;
	}
	
	//Bubble Sort
	public String sortBySize() {
		ArrayList<Customer> tmp = new ArrayList<Customer>();
		tmp.addAll(Wait_List);
		int max = 0;
		for(int i = 0; i< tmp.size()-1; i++) {
			for(int j=0; j<tmp.size()-i-1;j++) {
				if(tmp.get(j).getPartysize() > tmp.get(j+1).getPartysize()) {
					Customer c = tmp.get(j);
					Customer c2 = tmp.get(j+1);
					tmp.set(j, c2);
					tmp.set(j+1, c);
				}
			}
		}
		String result = "";
		int count = 1;
		for(Customer c: tmp) {
			result= result + ("Customer " + count + ": " +
					"  Name: " + c.getName() + 
								"   Size: " + c.getPartysize() +
								"   Phone: " + c.getPhone() +
								"   Time:" + c.getTime() + "\n");
			count ++;
		}
		return result;
	}
//functions for Reservation
	public boolean findCustomerR(Customer c){
		if(Reservation != null) {
			for(Customer x: Reservation)
			{
				if(x == c)
				{
					return true;
				}
			}
		}
		return false;
	}
	public Customer findCustomerByNameR(String name){
		if(Reservation != null) {
			System.out.println("not null");
			for(Customer x: Reservation)
			{
				System.out.println(x.getName());
				if(x.getName().equals(name))
				{
					return x;
				}
			}
		}else {
			System.out.println("null");
		}
		return null;
	}
	
	public Customer findCustomerBySizeR(int size){
		if(Reservation != null) {
			for(Customer x: Reservation)
			{
				if(x.getPartysize() <= size) {
					return x;
				}
			}
		}
		return null;
	}
	
	public Customer findCustomerByPhoneR(String phone) {
		if(Reservation != null) {
			for(Customer x: Reservation) {
				if(x.getPhone().equals(phone)) {
					return x;
				}
			}
		}
		return null;
	}
	
	public ArrayList<Customer> getAllReservation(){
		return Reservation;
	}
	
	public Customer getReservation(int position) {
		return Reservation.get(position);
	}
	
	public void printReservation() {
		for(Customer c: Reservation) {
			System.out.println("Name: " + c.getName() +
								" Size: " + c.getPartysize() +
								" Phone: " + c.getPhone() +
								" Time:" + c.getTime());
		}
	}
	
	public String getReservation() {
		String tmp = "";
		int count = 1;
		for(Customer c: Reservation) {
			tmp = tmp + ("Customer " + count + ": " +
					"  Name: " + c.getName() + 
								"   Size: " + c.getPartysize() +
								"   Phone: " + c.getPhone() +
								"   Time:" + c.getTime() + "\n");
			count ++;
		}
		return tmp;
	}
	public void addReservation(Customer c) {
		if(findCustomerR(c) == false) {
			this.Reservation.add(c);
			System.out.println("Customer " + c.getName() + " is added to the Reservation at position " + Wait_List.indexOf(c) );
		}
		else {
			System.out.println("Customer " + c.getName() + " is already in the Reservation.");
		}
	}
	
	public void deleteReservation(Customer c) {
		if(findCustomerR(c) == true) {
			Reservation.remove(c);
			System.out.println("Customer " + c.getName() + " is deleted from the Reservation");
		}else {
			System.out.println("Customer " + c.getName() + "is not in the Reservation");
		}
	}
	
	public Customer seatCustomerR(int size) {
		Customer c = null;
		
		if(Reservation == null)
		{
			System.out.println("No customer is in the Reservation");
			return null;
		}else {
			c = findCustomerBySizeR(size);
			if(c == null) {
				System.out.println("No party size " + size +" is found in Reservation");
				return null;
			}
			System.out.println("Seating down customer " + c.getName() +" right now...");
			deleteReservation(c);
		}
		return c;
	}
	
	//Bubble Sort
	public String sortBySizeR() {
		ArrayList<Customer> tmp = new ArrayList<Customer>();
		tmp.addAll(Reservation);
		for(int i = 0; i< tmp.size()-1; i++) {
			for(int j=0; j<tmp.size()-i-1;j++) {
				if(tmp.get(j).getPartysize() > tmp.get(j+1).getPartysize()) {
					Customer c = tmp.get(j);
					Customer c2 = tmp.get(j+1);
					tmp.set(j, c2);
					tmp.set(j+1, c);
				}
			}
		}
		String result = "";
		int count = 1;
		for(Customer c: tmp) {
			result= result + ("Customer " + count + ": " +
					"  Name: " + c.getName() + 
								"   Size: " + c.getPartysize() +
								"   Phone: " + c.getPhone() +
								"   Time:" + c.getTime() + "\n");
			count ++;
		}
		return result;
	}
	
	public String sortByTimeR() {
		ArrayList<Customer> tmp = new ArrayList<Customer>();
		tmp.addAll(Reservation);
		for(int i = 0; i< tmp.size()-1; i++) {
			for(int j=0; j<tmp.size()-i-1;j++) {
				if(tmp.get(j).getTime().after(tmp.get(j+1).getTime())) {
					Customer c = tmp.get(j);
					Customer c2 = tmp.get(j+1);
					tmp.set(j, c2);
					tmp.set(j+1, c);
				}
			}
		}
		String result = "";
		int count = 1;
		for(Customer c: tmp) {
			result= result + ("Customer " + count + ": " +
					"  Name: " + c.getName() + 
								"   Size: " + c.getPartysize() +
								"   Phone: " + c.getPhone() +
								"   Time:" + c.getTime() + "\n");
			count ++;
		}
		return result;
	}

}
