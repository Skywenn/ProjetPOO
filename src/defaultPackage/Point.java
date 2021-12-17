package defaultPackage;

/**
 * Classe representant un pixel pour l affichage des itineraires
 */
public class Point {
	private int x;
	private int y;
	
	/**
	 * Constructeur
	 * @param x coordonee x
	 * @param y coordonee y
	 */
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * Donne la coordonee verticale du point
	 * @return coordonée x du point
	 */
	public int getX() {
		return x;
	}
	/**
	 * Donne la coordonee horizontale du point
	 * @return coordonée y du point
	 */
	public int getY() {
		return y;
	}
	/**
	 * Definis la coordonee verticale du point
	 * @param coordonée verticale
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Definis la coordonee horizontale du point
	 * @param coordonée horizontale
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Donne la distance en pixel entre this et un autre point
	 * @param pt point avec lequel on veut la distance
	 */
	public double getDistance(Point pt) {
		return Math.sqrt((pt.getY() - y) * (pt.getY() - y) + (pt.getX() - x) * (pt.getX() - x));
	}
	/**
	 * Donne la distance en pixel arrondie entre this et un autre point
	 * @param pt point avec lequel on veut la distance
	 */
	public double getRoundDistance(Point pt) {
		return Math.round((Math.sqrt((pt.getY() - y) * (pt.getY() - y) + (pt.getX() - x) * (pt.getX() - x)))*1000.0)/1000.0;
	}
}
