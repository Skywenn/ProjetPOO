package defaultPackage;
/**
 * Classe des scooters qui hérite de Vehicule
 */
public class Scooter extends Vehicle{
	
	private double displacement;  	// cylindree du scooter
	private double consumption;		// consommation du scooter
	
	/**
	 * Constructeur
	 * @param name nom
	 * @param price prix
	 * @param dispalcement cylindree
	 * @param payLoad charge utile
	 * @param consumption consommation
	 */
	public Scooter(String name, double price, double displacement, double payLoad, double consumption ) {
		super(name, price, displacement/4, payLoad);
		this.displacement = displacement;	
		this.consumption = consumption;
	}
	/**
	 * Donne la cylindree du vehicule
	 * @return la cylindree
	 */
	public double getDisplacement() {
		return displacement;
	}
	/**
	 * Donne la consommation au km du scooter
	 * @return la consommation
	 */
	public double getConsumption() {
		return consumption;
	}
	/**
	 * Donne la vitesse du scooter
	 * @override
	 * @param e employe conduisant le scooter
	 * @return la vitesse
	 */
	public double getAvgSpeed(Employee e) {
		return 30;
	}
	/**
	 * Donne le cout au km du scooter.
	 * C est a dire le prix du scooter divise par 20000 plus le prix de la consommation d essence
	 * @override
	 * @return le cout d utilisation
	 */
	public double getCost() {
		return this.price/20000 + Param.fuelPrice * (consumption/100);
	}


}
