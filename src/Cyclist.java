
public class Cyclist extends Employee{

	private CyclistType type;
	
	public Cyclist(String name, double weight, double salary, CyclistType type) {
		super(name, weight, salary);
		this.type = type;
	}

	public double getCyclistSpeed() {
		return type.getCyclistSpeed();
	}
}

