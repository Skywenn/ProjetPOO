
public class Employee {
	
	private String name;
	private double weight;
	private double salary;
	
	public Employee(String name, double weight, double salary) {
		this.name = name;
		this.weight = weight;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getSalary() {
		return salary;
	}
	
	public double getPayLoad() {
		return weight/8;
	}
}
