
public class Manager extends Employee{

	public Manager(String name, String position) {
		super(name, position);
	}
	
	public void summary(Restaurant r) {
		System.out.println("Summary ... ");
		System.out.println("Total Revenue: " + r.getTotalRevenue());
		r.resetTables();
		System.out.println("Restting tables ...");
		System.out.println("Closed!");
	}
}
