
public abstract class Vehicle {
	
	private String name;
	protected double price;
	protected double emission;
	private double payLoad;
	
	public Vehicle(String name, double price, double emission, double payLoad) {
		this.name = name;
		this.price = price;
		this.emission = emission;
		this.payLoad = payLoad;
	}
	

	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	public double getEmission() {
		return emission;
	}
	
	public double getPayLoad() {
		return payLoad;
	}
	
	public abstract double getCost();
	
	public abstract double getAvgSpeed(Employee e);
	
}

	