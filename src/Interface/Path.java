package Interface;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import defaultPackage.Company;
import defaultPackage.Delivery;
/**
 * Cette classe d objets drawable represente les itineraires 
 * des differentes livraisons possible de l entreprise
 */
public class Path implements Drawable{
	private ArrayList<Delivery> list;	// liste de livraison
	private MapWindow window;			// fenetre
	
	/**
	 * Constructeur
	 * @param company
	 */
	public Path(Company company) {
		this.list = company.getListDelivery();
	}
	
	// Methode de dessin
	// Dessine une ligne entre chaque point d une liste de point
	public void draw(Graphics g) { 
		g.setColor(Color.BLACK);
		for(Delivery d : list) {
			for (int i=0; i< (d.getTrip().size()-1); i++) {
				int x1 = d.getTrip().get(i).getX();
				int x2 = d.getTrip().get(i+1).getX();
				int y1 = d.getTrip().get(i).getY();
				int y2 = d.getTrip().get(i+1).getY();
				g.drawLine(x1, y1, x2, y2);	
				if (window != null) window.update(); // mise à jour
			}
			
		}
	} 
	
	// Methode d'affectation de la fenetre
	public void setWindow(MapWindow w) {
		this.window = w;
		}
	
	// Methode de mise a jour de l affichage
	public void setPath(ArrayList<Delivery> list) {
		if (window != null) window.update();
		}
}