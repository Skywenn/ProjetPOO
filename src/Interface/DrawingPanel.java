package Interface;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import defaultPackage.Company;
import defaultPackage.Param;
import defaultPackage.Point;
/**
 * Cette classe représente un panel de dessin de type JPanel.
 * Un objet DrawingPanel contient une liste d'objets de type Drawable.
 * 
 * Ces objets Drawable sont dessines dans le panel lors de l'appel de la methode paintComponent
 */
public class DrawingPanel extends JPanel {
	
	private List<Drawable> drawList;
	/**
	 * Constructeur
	 * @param company entreprise de l application
	 * 
	 * 
	 */
	public DrawingPanel(Company company) {
		ArrayList<Drawable> list = new ArrayList<Drawable>();
		this.setPreferredSize(new Dimension(400,400));
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.drawList = Collections.synchronizedList(list);
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				company.getNewDelivery().addAvPoint(new Point(e.getX(),e.getY()));
				System.out.println(e.getX() + e.getY() + company.getNewDelivery().getTrip().toString());
			    }
		});
		
	}
	
	/**
	 * Dessine les objets de this
	 * @param g objet graphique
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // dessin du JPanel (fond, bordure...)
		
		// Affichage Map;
		int w = this.getWidth(), h = this.getHeight(),
		r = 10, d = 2*r;
		g.setColor(Color.BLACK);
		g.fillRect(Param.base.getX() - r, Param.base.getY() - r, d, d); // Position Entreprise
		g.setColor(Color.PINK);
		g.fillOval(Param.destination.getX() - r, Param.destination.getY() - r, d, d);  // Position Destination
		
		// Affichage des drawable
		synchronized(drawList) {
			for (Drawable obj : drawList) {
				obj.draw(g);
			}
		}
	}
	
	/**
	 * Ajout d'un objet  drawable de la liste de drawable this
	 * @param g drawable
	 */
	public void addDrawable(Drawable obj) {
		drawList.add(obj);
		}
	/**
	 * Suppression du drawable specifie en paramtre de la liste de drawable de this
	 * @param g drawable
	 */
	public void removeDrawable(Drawable obj) {
		drawList.remove(obj);
		}
}

