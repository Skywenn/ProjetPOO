package Interface;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import defaultPackage.Company;
import defaultPackage.Delivery;

public class NewPath implements Drawable{
	private Delivery delivery; 	// livriason
	private MapWindow window;	// fenetre
	
	/**
	 * Constructeur
	 * @param company
	 */
	public NewPath(Company company) {
		this.delivery = company.getNewDelivery();
	}
	
	// Méthode de dessin
	// Dessine une ligne entre chaque point d une liste de point
	public void draw(Graphics g) { 
		g.setColor(Color.RED);
		for (int i=0; i< (delivery.getTrip().size()-1); i++) {
			int x1 = delivery.getTrip().get(i).getX();
			int x2 = delivery.getTrip().get(i+1).getX();
			int y1 = delivery.getTrip().get(i).getY();
			int y2 = delivery.getTrip().get(i+1).getY();
			g.drawLine(x1, y1, x2, y2);	
			if (window != null) window.update(); // mise à jour
		}
	}

	// Methode d'affectation de la fenetre
	public void setWindow(MapWindow w) {
		this.window = w;
		}
	
	// Methode de mise a jour de l affichage
	public void setPath(Delivery list) {
		if (window != null) window.update(); // mise à jour
		}
	
}