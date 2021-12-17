package defaultPackage;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe representant une livraison
 */

public class Delivery {
	
	private ArrayList<Point> trip;  // Liste de points, represenant l itineraire
	private double weight;          // Poids
	private Vehicle vehicle;        // Vehicule utilise
	private Employee employee;      // Employe en charge
	
	/**
	 * Constructeur
	 * @param poids de la livraison
	 * @param vehicle vehicule utilise
	 * @param employee employe en charge
	 */
	public Delivery(double weight, Vehicle vehicle, Employee employee) {
		this.trip = new ArrayList<Point>();
		this.weight = weight;
		this.vehicle = vehicle;
		this.employee = employee;
	}

	/**
	 * @return La liste de points representant l itineraire
	 */
	public ArrayList<Point> getTrip() {
		return trip;
	}
	/**
	 * @return Le poids de la livraison
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @return Le vehicule utiliser pour la livraison
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
	/**
	 * @return L employe en charge de la livraison
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * Redefinis le poids de la livraison
	 * @param weight poids de la livraison
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * Redefinis le vehicule
	 * @param vehicle vehicule que l on veut utilise
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * Redefinis l employe en charge de la livraison
	 * @param employee employe que l on veut mettre en charge
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * Redefinis l itineraire
	 * @param list liste de points representant le nouvel itineraire
	 */
	public void setTrip(ArrayList<Point> list) {
		this.trip = list;
	}
	/**
	 * Donne la distance totale du trajet de this en km 
	 * @return distance totale du trajet de this
	 */
	public double getTotalDistance() {
		double distance = 0;
		for (int i = 0; i < trip.size()-1; i++ ) {
			distance = trip.get(i).getDistance(trip.get(i+1));
		}
		// On multiplie par 2 car le trajet compte l'aller retour
		// On divise par 100 pour avoir des km (estimation 1px = 10m)
		return (Math.ceil(distance*2*100)/100)/100;
	}
	/**
	 * Donne la duree total du trajet
	 * @return duree du trajet en heure
	 */
	public double getDuration() {
		// Time = Distance / Speed
		return Math.ceil((this.getTotalDistance()/vehicle.getAvgSpeed(employee))*100)/100;
	}
	/**
	 * Donne la charge utile de this, c est le maximum entre celle du vehicule et du livreur
	 * @return la charge utile de la livraison
	 */
	public double getDeliveryPayLoad(){
		return Math.max(vehicle.getPayLoad(), employee.getPayLoad());
	}
	/**
	 * Donne les emission de co2 au km de this
	 * @return emission de co2 au km
	 */
	public double getDeliveryEmission() {
		// Emissions per kilometer * distance
		return Math.ceil((vehicle.getEmission()*(this.getTotalDistance())/1000)*100)/100;
	}
	/**
	 * Donne le cout a l heure de this
	 * @return cout a l heure
	 */
	public double getDeliveryCost() {
		// Time in hour * Salary per hour + Vehicle's cost per kilometer * total distance
		return Math.ceil((employee.getSalary()*this.getDuration() + vehicle.getCost()*this.getTotalDistance())*100)/100;
	}
	/**
	 * Ajoute un point en derniere position de l itineraire de this
	 * @param pt point a ajouter
	 */
	public void addPoint(Point pt) {
		trip.add(pt);
	}
	/**
	 * Ajoute un point en avant derniere position de l itineraire de this
	 * @param pt point a ajouter
	 */
	public void addAvPoint(Point pt) {
		trip.add((trip.size()-1) ,pt);
	}
	/**
	 * Redifinition de this.
	 * Utilise les classes CyclistType et Param pour mettre les attributs de this pas "defaut"
	 */
	public void clearDelivery() {
		this.setTrip(new ArrayList<>(Arrays.asList(Param.base, Param.destination)));
		this.employee = new Employee("vide", 0, 0, CyclistType.NONE);
		this.vehicle = new Bike("vide", 0);
		this.weight = 0;
	}
	/**
	 * Compare this à une autre livraison et retourne vrai si elle est meilleur, faux sinon.
	 * Utilise la formule ((c1 > c2) and (p1 > p2)) or ((c1 > c2) and (p1 = p2)) or ((c1 = c2) and (p1 > p2))
	 * @return true si this mieux que other
	 */ 
	public boolean isBetterThan(Delivery other) {
		double p1 = this.getDeliveryCost();
		double c1 = this.getDeliveryEmission();
		double p2 = other.getDeliveryCost();
		double c2 = other.getDeliveryEmission();
		if ( ((c1>c2) && (p1>p2)) || ((c1>c2) && (p1==p2)) || ((c1==c2) && (p1>p2)) ){
			return false;
		}
		return true;
 	}
	/**
	 * Verifie qu une livraison est possible. C est a dire qu elle a un poids positif,
	 * une charge utile superieur au poids de la livraison, que si le vehicule est un
	 * velo, l employe soit un cycliste et que les duree et distance maximale ne soit pas
	 * depassee.
	 * @return true si la livraison est possible
	 */ 
	public boolean isPossible() {
		// si le poids est incorrect
		if( (weight <= 0) ) {
			return false;
		}
		// si l employe ne peut pas faire de velo
		if( (employee.getCyclistType()== CyclistType.NONE) && (vehicle instanceof Bike) ) {
			return false;
		}
		// si la livraison est trop lourde
		if(this.getDeliveryPayLoad() < weight) {
			return false;
		}
		// si la livraison est trop longue
		if( (this.getDuration() > Param.maxDuration) || (this.getTotalDistance() > Param.maxDistance) ) {
			return false;
		}
		return true;
	}
	/**
	 * Un bel affichage de la distance, de l employe, du vehicule, du cout et de l emission de this
	 * @return une chaine de carateres
	 */ 
	public String PrettyPrint() {
		return "Distance :" + this.getTotalDistance() 
				+ "km / Employee :" + this.employee.getName()
				+ " / Véhicule :" + this.vehicle.getName()
				+ " / Cout /h :" + this.getDeliveryCost()
				+ " / Emission /km :" + this.getDeliveryEmission();			
	}
}




