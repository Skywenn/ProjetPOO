package defaultPackage;
/**
 * Classe abstraite des vehicules
 * les velos et scooters en herite
 */
public abstract class Vehicle {
	
	private String name;		// nom
	protected double price;		// prix
	protected double emission;	// emission
	private double payLoad;		// charge utile
	
	/**
	 * Constructeur
	 * @param name nom
	 * @param price prix
	 * @param emission emission au km
	 * @param payLoad charge utile
	 */
	public Vehicle(String name, double price, double emission, double payLoad) {
		this.name = name;
		this.price = price;
		this.emission = emission;
		this.payLoad = payLoad;
	}
	/**
	 * Donne le nom du vehicule
	 * @return le nom
	 */
	public String getName() {
		return name;
	}
	/**
	 * Donne le prix du vehicule
	 * @return le prix
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Donne l emission de co2 au km du vehicule
	 * @return l emission au km
	 */
	public double getEmission() {
		return emission;
	}
	/**
	 * Donnela charge utile du vehicule
	 * @return la charge utile
	 */
	public double getPayLoad() {
		return payLoad;
	}
	/**
	 * @abstract
	 * Donne le cout du vehicule
	 */
	public abstract double getCost();
	/**
	 * @abstract
	 * Donne la vitesse du vehicule
	 * @param e employee conduisant le vehicule
	 */
	public abstract double getAvgSpeed(Employee e);
	
}

	