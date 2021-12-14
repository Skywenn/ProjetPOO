
public class Bike extends Vehicle{

	public Bike(String name, double price) {
		super(name, price, 0, 0);
	}

	// Average Speed of a bike depends on the cyclist
	// A non cyclist employee can not ride a bike
	public double getAvgSpeed(Employee e) {
		if (e.getCyclistType() != CyclistType.NONE) {
			return e.getCyclistSpeed();
		}
		// TODO throw exception 
		return 0;
	}

	public double getCost() {
		return price/30000;
	}
}
