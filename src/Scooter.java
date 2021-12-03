
public class Scooter extends Vehicle{
	
	private double displacement;
	
	public Scooter(String name, double price, double emission, double payLoad, double displacement) {
		super(name, price, displacement/4, payLoad, price/20000 + Param.fuelPrice);
		this.displacement = displacement;	
	}

	public double getDisplacement() {
		return displacement;
	}
		
	// Average speed of a scooter is always 30km/h
	public double getAvgSpeed(Employee e) {
		return 30;
	}

}
