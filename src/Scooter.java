
public class Scooter extends Vehicle{
	
	private double displacement;
	private double consumption;
	
	public Scooter(String name, double price, double displacement, double payLoad, double consumption ) {
		super(name, price, displacement/4, payLoad);
		this.displacement = displacement;	
		this.consumption = consumption;
	}

	public double getDisplacement() {
		return displacement;
	}
	
	public double getConsumption() {
		return consumption;
	}
		
	// Average speed of a scooter is always 30km/h
	public double getAvgSpeed(Employee e) {
		return 30;
	}
	
	// Cost per kilometer
	// Price/200000 + FuelPrice for 1 kilometer/Consumption per kilometer
	public double getCost() {
		return this.price/20000 + Param.fuelPrice * (consumption/100);
	}


}
