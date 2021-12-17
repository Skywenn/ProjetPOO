package Interface;
import java.awt.event.*;

import javax.swing.JFrame;

import defaultPackage.Company;

/**
 * Cette classe represente une fenetre graphique de type JFrame dans lequel
 * se trouve une carte affichant l entreprise et une destination ainsi
 * que les trajets des differentes livraison
 */
public class MapWindow extends JFrame {
	private DrawingPanel panel;		// panel de dessin
	
	/**
	 * Constructeur de la fen�tre
	 */
	public MapWindow(Company company) {
		super("Dessiner l'itin�raire 1px=10m");
		
		// creation du panel de dessin
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.panel = new DrawingPanel(company);
		this.getContentPane().add(panel);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pack();
	}
	
	/**
	 * Ajout d'un objet � dessiner dans le panel de dessin
	 * @param obj objet � dessiner
	 */
	public void addDrawable(Drawable obj) {
		panel.addDrawable(obj);
	}
	
	/**
	 * Mise à jour de la vue qui est redessinee
	 */
	public void update() {
		getContentPane().repaint();
	}
}
