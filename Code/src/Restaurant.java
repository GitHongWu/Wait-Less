import java.util.ArrayList;

public class Restaurant {
	private boolean availability;
	private String name;
	private int numOfTable;
	private ArrayList<Table> tables;
	private int totalRevenue;
	private EmployeeList employeeList;
	private Schedule schedule;
	
	//Constructor
	public Restaurant(String _name, int _numOfTable) {
		this.availability = false;
		this.name = _name;
		this.numOfTable = _numOfTable;
		this.tables = new ArrayList<Table>();
		this.totalRevenue = 0;
		this.employeeList = new EmployeeList();
		this.schedule = new Schedule();
	}

	//open restaurant
	public void open() {
		availability = true;
		resetTables();
		System.out.println("Restaurant: " + name + " is opening!");
	}
	
	public void displayInfo() {
		System.out.println("Restaurant: " + name);
		System.out.println("Table: ");
		for(int i = 0; i < numOfTable - 1; i++) {
			System.out.println("Table id: " + tables.get(i).getid() + " Table size: " + tables.get(i).getSize());
			
		}
	}
	
	public void resetTables() {
		//clear all tables
		tables.clear();
		//re-create all tables
		for(int i = 1; i < numOfTable; i++) {
			tables.add(new Table(i));
		}
	}
	
	//given table id, return Table. Otherwise return NULL
	public Table getTable(int tableID){
		for(int i = 0; i < numOfTable; i++) {
			if(tables.get(i).getid() == tableID) {
				return tables.get(i);
			}
		}
		return null;
	}
	
	public EmployeeList getEmployeeList() {
		return employeeList;
	}
	
	public void setEmployeeList(EmployeeList employeeList) {
		this.employeeList = employeeList;
	}

	public Schedule getSchedule() {
		return schedule;
	}
	
	public int getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
}
