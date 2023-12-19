class employee{
	int ID;
	String name;
	int salary;
	employee(int ID,String name,int salary){
		this.ID = ID;
		this.name = name;
		this.salary = salary;
	}
	Integer raiseSalary(int percent){
		salary += (salary * percent)/100;
		return salary;
	}
}
public class Employee {
	public static void main(String[] args) {
		employee e1 = new employee(123,"xyz",20000);
		System.out.println(e1.ID);
		System.out.println(e1.name);
		System.out.println(e1.salary);
		
		System.out.println(e1.raiseSalary(20));
	}

}
