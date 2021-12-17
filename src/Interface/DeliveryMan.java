package Interface;
import java.awt.Graphics;
/**
 * Un DeliveryMan represente la position d un livreur lors de sa livraison
 * DeliveryMan implemente Drawable et Runnable
 */
public class DeliveryMan implements Drawable, Runnable {
	private int x, y; // position
	private MapWindow window;
	
	/**
	 * Constructeur
	 * @param x coordonee verticale
	 * @param y coordonee horizontale
	 */
	public DeliveryMan(int x, int y) { 
		setPosition(x,y);
	}
	
	// Methode de dessin
	public void draw(Graphics g) { 
			g.fillOval(x-10, y-10, 20,20);	
	} 
	
	// Methode d'affectation de la fenetre
	public void setWindow(MapWindow w) {
		this.window = w;
		}
	
	// Methode de mise a jour de la position
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		if (window != null) window.update(); // mise a jour de la fentre
		}
	
	// Methode d animation de l objet
	public void run() {
		for (int i=0; i<100; ++i) {
			setPosition(x+1, y); // un pixel vers la droite
		try {
			Thread.sleep(20); 	// pause de 20ms
		}
			catch(Exception e) {}
		}
	}
}