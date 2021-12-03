
public abstract class Vehicle {
	
	private String name;
	private double price;
	private double emission;
	private double payLoad;
	private double cost;
	
	public Vehicle(String name, double price, double emission, double payLoad, double cost) {
		this.name = name;
		this.price = price;
		this.emission = emission;
		this.payLoad = payLoad;
		this.cost = cost;
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
	
	public double getCost() {
		return cost;
	}
	
	public abstract double getAvgSpeed(Employee e);
	
}

	