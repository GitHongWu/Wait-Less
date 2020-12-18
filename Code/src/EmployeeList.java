import java.util.ArrayList;

public class EmployeeList {
	private ArrayList<Employee> Emp_List;
	private int Emp_Num;
	private int MaxID;
	
	//constructor
	public EmployeeList() {
		this.Emp_List = new ArrayList<Employee>();
		this.Emp_Num = 0;
		this.MaxID = 1;
	}
	
	public Employee employeeExist(String employeeName) {
		for(Employee e : Emp_List) {
			if(e.getEmpName().compareTo(employeeName) == 0) {
				return e;
			}
		}
		return null;
	}
	
	public void addEmp(Employee e) {
		e.setEmpID(MaxID);
		this.Emp_List.add(e);
		this.Emp_Num ++;
		this.MaxID ++;
		
	}
	
	public void deleteEmp(Employee e) {
		for(Employee x : Emp_List)
		{
			if(x == e)
			{
				this.Emp_List.remove(x);
				this.Emp_Num --;
				return;
			}
		}
	}
	

	public void printAllEmp() {
		for(Employee aEmp : this.Emp_List) {
			System.out.println("Name: " + aEmp.getEmpName() + 
								" Position: " + aEmp.getPosition() +
								" ID: " + aEmp.getEmpID());
		}
	}

	public ArrayList<Employee> getEmp_List() {
		return Emp_List;
	}

	public void setEmp_List(ArrayList<Employee> emp_List) {
		Emp_List = emp_List;
	}

	public int getEmp_Num() {
		return Emp_Num;
	}

	public void setEmp_Num(int emp_Num) {
		Emp_Num = emp_Num;
	}
	
	
	
}
