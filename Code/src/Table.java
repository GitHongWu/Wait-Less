import java.util.ArrayList;
import java.text.DecimalFormat; 

public class Table {
	private int id;
	private boolean availability;
	private int tableSize = 4;
	private ArrayList<Customer> customers;
	private Employee responseWaiter;
	private MenuList menulist;
	private double myOrderCost = 0; 
	private String myOrdername = "";
//	private Menu check;	//check contains all dishes and price belong to the table
	
	//construct
	public Table(int _id) {
		this.menulist = new MenuList();
		this.id = _id;
		this.availability = true;
		this.tableSize = 4;
		//this.customers = new ArrayList<Customer>();
		//this.responseWaiter = new Employee();
	}
	
	public int getid() {
		return id;
	}
	
	public int getSize() {
		return tableSize;
	}
	
	public void addCustomer(Customer c) {
		if(customers.size() < tableSize) {
			customers.add(c);
		}
		else {
			System.out.println("Table too small, Table size: " + tableSize);
		}
	}
	
	public void setWaiterToTable(Employee e) {
		this.responseWaiter = e;
	}
	
	public MenuList getMeunlist() {
		return this.menulist;
	}
	
	public void OrderItem(int i) {
		myOrderCost+= getMeunlist().getItem(i).returnItemPrice();
		myOrdername+= getMeunlist().getItem(i).returnItemName()+ "\n";
	}
	
	public String getOrdercost() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		return  df.format(myOrderCost);
	}
	
	public String getOrderName() {
		return myOrdername;
	}
	//display all dishes and prices belong to the table
	public void checkout() {
		// set availability to table being open
	}
}
