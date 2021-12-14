
public class Employee {
	
	private String name;
	private double weight;
	private double salary;
	private double payLoad;
	private CyclistType type;
	
	public Employee(String name, double weight, double salary, CyclistType type) {
		this.name = name;
		this.weight = weight;
		this.salary = salary;
		this.payLoad = weight/8;
		this.type = type;
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
		return payLoad;
	}
	
	public CyclistType getCyclistType() {
		return type;
	}
	
	public double getCyclistSpeed() {
		return type.getTypeSpeed();
	}
}
