
public class Bike extends Vehicle{

	public Bike(String name, double price) {
		super(name, price, 0, 0, price/30000);
	}

	// Average Speed of a bike depends on the cyclist
	// A non cyclist employee can not ride a bike
	public double getAvgSpeed(Employee e) {
		if (e instanceof Cyclist) {
			Cyclist cyclist = (Cyclist) e;
			return cyclist.getCyclistSpeed();
		}
		// TODO throw exception 
		return 0;
	}

}
