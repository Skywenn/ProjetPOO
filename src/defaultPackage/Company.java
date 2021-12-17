package defaultPackage;
import java.util.ArrayList;

/**
 * Classe representant l'entreprise
 */
public class Company {
	private ArrayList<Employee> listEmployee;  // Liste des employes
	private ArrayList<Vehicle> listVehicle;    // Liste des vehicules
	private ArrayList<Delivery> listDelivery;  // Liste des livraisons
	private Delivery bestDelivery;             // Meilleur livraison
	private Delivery newDelivery;              // Livraison en cours de création
	
	/**
	 * Constructeur
	 */
	public Company() {
		this.listEmployee = new ArrayList<Employee>();
		this.listVehicle = new ArrayList<Vehicle>();
		this.listDelivery = new ArrayList<Delivery>();
		this.newDelivery = new Delivery(0,null,null);
		this.newDelivery.clearDelivery();
	}
	/**
	 * @return Liste d'employe de this
	 */
	public ArrayList<Employee> getListEmployee() {
		return listEmployee;
	}
	/**
	 * @return Liste de vehicule de this
	 */
	public ArrayList<Vehicle> getListVehicle() {
		return listVehicle;
	}
	/**
	 * @return Liste de livraison de this
	 */
	public ArrayList<Delivery> getListDelivery() {
		return listDelivery;
	}
	/**
	 * @return la meilleure livraison de this
	 */
	public Delivery getBestDelivery() {
		return bestDelivery;
	}
	/**
	 * Ajoute un employe a la liste des employes
	 * @param e employe a ajouter
	 */
	public void addEmployee(Employee e) {
		listEmployee.add(e);
	}
	/**
	 * Ajoute un vehicule a la liste des vehicules
	 * @param v vehicule a ajouter
	 */
	public void addVehicle(Vehicle v) {
		listVehicle.add(v);
	}
	/**
	 * Ajoute une livraison a la liste des livraisons
	 * @param d livraison a ajouter
	 */
	public void addDelivery(Delivery d) {
		listDelivery.add(d);
	}
	/**
	 * Donne la livraison en cours de création
	 * @retrun newDelivery 
	 */
	public Delivery getNewDelivery() {
		return newDelivery;
	}
	/**
	 * Redefini la livraison en cours de creation
	 * @param newDelivery livraison
	 */
	public void setNewDelivery(Delivery newDelivery) {
		this.newDelivery = newDelivery;
	}
	/**
	 * Supprime de la liste de livraison les livraison incorrectes.
	 * Utilise isPossible() de Delivery
	 */
	protected void deleteWrongDelivery() {
		for(Delivery d : this.getListDelivery()) {
			if (d.isPossible() == false) {
				listDelivery.remove(d);
			}
		}
	}
	
	/**
	 * Supprime les livraison incorrectes puis redefinis la meilleure livraison et 
	 * Utilise deleteWrongDelivery()
	 */
	public void bestDelivery() {
		// Delete all the not possible delivery
		this.deleteWrongDelivery();
		Delivery best = listDelivery.get(0);
		for(Delivery d : this.getListDelivery()) {
			if (d.isBetterThan(best)){
				best = d;
			}
		}
		this.bestDelivery = best;
	}
}


