package defaultPackage;
/**
 * Classe enum representant les diff�rents types de cyclistes et leur vitesse associ�e
 */
public enum CyclistType {
	BEGINNER(10), ATHLETIC(15), EXPERT(20), NONE(0); 
	
	private double speed; // vitesse du type de cycliste
	
	/**
	 * Constructeur
	 * @param speed vitesse associee
	 */
	private CyclistType(double speed) {
		this.speed = speed;
	}
	
	/**
	 * @return la vitesse du type de cycliste
	 */
	public double getTypeSpeed() {
		return this.speed;
	}
}
