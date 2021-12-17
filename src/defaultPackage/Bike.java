package defaultPackage;
/**
 * Classe des velos qui hérite de Vehicule
 */
public class Bike extends Vehicle{

	/**
	 * Constructeur
	 * @param name nom du velo
	 * @param price prix du velo
	 */
	public Bike(String name, double price) {
		super(name, price, 0, 0);
	}

	/**
	 * Donne la vitesse du velo en fonction du conducteur
	 * @override
	 * @param e employe conduisant le velo
	 * @return retourne la vitesse
	 */
	public double getAvgSpeed(Employee e) {
		if (e.getCyclistType() != CyclistType.NONE) {
			return e.getCyclistSpeed();
		}
		return 0;
	}

	/**
	 * Donne le cout du velo au km
	 * @override
	 * @return retourne le cout d utilisation
	 */
	public double getCost() {
		return price/30000;
	}
}
