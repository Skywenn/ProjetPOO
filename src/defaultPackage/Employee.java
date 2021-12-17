package defaultPackage;

/**
 * Classe representant un employe
 */
public class Employee {
	
	private String name;		// nom de l employe
	private double weight;		// poids de l employe
	private double salary; 		// salaire horaire de l employe
	private double payLoad;		// charge utile de l employee
	private CyclistType type;	// capacite a faire du velo de l employe
	
	/**
	 * Constructeur
	 * @param name nom 
	 * @param weight poids
	 * @param salary salaire horaire
	 * @param cyclistType type de cycliste (enum)
	 */
	public Employee(String name, double weight, double salary, CyclistType type) {
		this.name = name;
		this.weight = weight;
		this.salary = salary;
		this.payLoad = weight/8;
		this.type = type;
	}
	/**
	 * Donne le nom de l employe
	 * @return le nom
	 */
	public String getName() {
		return name;
	}
	/**
	 * Donne le poids de l employe
	 * @return le poids
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * Donne le salaire horaire de l employe
	 * @return le salaire 
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * Donne la charge utile de l employe
	 * @return la charge utile
	 */
	public double getPayLoad() {
		return payLoad;
	}
	/**
	 * Donne les capacites de l employee a faire du velo
	 * @return un type de cycliste
	 */
	public CyclistType getCyclistType() {
		return type;
	}
	/**
	 * Donne la vitesse de l employee sur un velo (0 si incapable de faire du velo)
	 * @return une vitesse
	 */
	public double getCyclistSpeed() {
		return type.getTypeSpeed();
	}
}
