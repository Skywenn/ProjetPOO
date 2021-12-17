package Interface;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import defaultPackage.Company;
import defaultPackage.Delivery;
import defaultPackage.Employee;
import defaultPackage.Point;
import defaultPackage.Vehicle;
/**
 * Cette classe represente une fenetre de type JFrame dans lequel
 * se trouve les boutons et affichages donnant des informations sur
 * l entreprise.
 */
public class InfoWindow extends JFrame{
	
	
	// Composants de la fenetre :
	private JTextField textField;
	private JButton btnEmployee = new JButton("Ajout Employée");
	private JButton btnVehicle = new JButton("Ajout Véhicule");
	private JButton btnCreateDelivery = new JButton("Enregistrer la livraison");
	private JButton btnSimulate = new JButton("Lancer la simulation");
	private JTextArea textArea = new JTextArea();
	private JLabel textBestDelivery = new JLabel();
	
	/**
	 * Constructeur
	 */
	public InfoWindow(Company company) {
		super("Projet POO -- USBDriver");
		
		build(company);
	}
	
	/**
	 * Methode definissant la fenêtre
	 * @param company
	 */
	private void build(Company company) {
	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(800,600));
		this.setLocationRelativeTo(null);
		this.setResizable(false); 
		this.setContentPane(buildContentPane(company));
		
	}
	
	/**
	 * Methode definissant les composants de la fenetre
	 * le panel est divisé en 3 sous panel disposé avec un BorderLayout
	 * panel mis à jour en cas de clique
	 * @param company
	 * @return le panel d'affichage de la fentre
	 */
	private JPanel buildContentPane(Company company) {
		JPanel panel = (JPanel) this.getContentPane();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel.add(setMenu(company), BorderLayout.EAST);
		panel.add(setBar(company), BorderLayout.SOUTH);
		panel.add(setInfos(company),BorderLayout.WEST);
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel.repaint();
			    }
		});
		return panel;
	}
		
	/**
	 * Methode definissant le menu de la fenetre.
	 * Panel organise en grille d une colonne
	 * La methode definis les différentes interactions avec
	 * les boutons.
	 * @param company
	 * @return le panel d'affichage du menu
	 */
	private JPanel setMenu(Company company) {

		// Creation du panel
		JPanel panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(12, 1, 0, 0));
		
		// Taille des boutons
		btnEmployee.setPreferredSize(new Dimension(200,10));
		

		// Affichage necessaire dans ce panel
		JLabel textEmployee = new JLabel("Selectionnez un employé");
		JLabel textVehicle = new JLabel("Selectionnez un véhicule");
		JLabel textWeight = new JLabel("Entrez le poids de la livraison");
		JLabel textAdd = new JLabel("Ajoutez un élément à l'entreprise");
		JLabel textNew = new JLabel("Enregistrez la livraison");

		// Ajout des boites de selections des véhicules et employes
		JComboBox<Vehicle> comboBoxVehicle = new JComboBox<Vehicle>(new Vector<Vehicle>(company.getListVehicle()));
		JComboBox<Employee> comboBoxEmployee = new JComboBox<Employee>(new Vector<Employee>(company.getListEmployee()));
		
		// Ajout de l'information sur le poids
		panelEast.add(textWeight);
		
		// Nouvelle zone de texte;
		textField = new JTextField();
		
		// Ajout de la zone de texte
		panelEast.add(textField);
		textField.addActionListener(new ActionListener() {
			// Vérifie l'entree valide du poids, et modifie newDelivery
			public void actionPerformed(ActionEvent e) {
				try {
					float weight = Float.parseFloat(textField.getText());
					textWeight.setText("Vous avez entrez " + weight + "kg");
					company.getNewDelivery().setWeight(weight);
				}
				catch(Exception ex) {
					textWeight.setText("Entrez un nombre pour le poids svp");
					textField.setText("");
				}
			}
		} );
		
		// Ajout de l'information sur les employes
		panelEast.add(textEmployee);
		
		// Ajout Box Employee + Selection Employee
		panelEast.add(comboBoxEmployee);
		comboBoxEmployee.addActionListener(new ActionListener() {
			// Selection d'un employé, et mise à jour de la livraison en attente newDelivery
			public void actionPerformed(ActionEvent e) {    
		        company.getNewDelivery().setEmployee((Employee)comboBoxEmployee.getSelectedItem());
		        System.out.println(company.getNewDelivery().PrettyPrint()); 
		     }
		} );
		
		// Ajout de l'information sur les vehicules
		panelEast.add(textVehicle);
		
		// Box Vehicle + Selection Vehicle
		panelEast.add(comboBoxVehicle);
		comboBoxVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Selection d'un employé, et mise à jour de la livraison en attente newDelivery
		        company.getNewDelivery().setVehicle((Vehicle)comboBoxVehicle.getSelectedItem());
		        System.out.println(company.getNewDelivery().PrettyPrint());   
		     }
		} );
		
		// Ajout de l'information sur la création de nouvelle livraison
		panelEast.add(textNew);
		
		// Ajout du bouton de création de nouvelle livraison
		panelEast.add(btnCreateDelivery);
		btnCreateDelivery.addActionListener(new ActionListener() {
			// Création d'une nouvelle livraison
			public void actionPerformed(ActionEvent e) {
				// Regroupement des donnees pour créer une nouvelle livraison
				double weight = company.getNewDelivery().getWeight();
				Vehicle vehicle = (Vehicle) comboBoxVehicle.getSelectedItem();
				Employee employee = (Employee) comboBoxEmployee.getSelectedItem();
				
				// Creation de la nouvelle livraison et affectation de son trajet
				Delivery newDelivery = new Delivery(weight, vehicle, employee);
				newDelivery.setTrip(company.getNewDelivery().getTrip());
				
				// Si le livraison est correct 
				// on l'ajoute à la liste de livraison de l'entreprise
				// on met a jour la meilleur livraison
				// on remet a defaut la livraison en cours de creation
				// Sinon on affiche a l utilisateur que la saison n est pas valide
				if (newDelivery.isPossible()) {
					
					company.addDelivery(newDelivery);
					company.bestDelivery();
					// Mise a jour des textes
					textArea.append("\n "+ newDelivery.PrettyPrint());
					textBestDelivery.setText("Meilleur livraison :" + (company.getBestDelivery().PrettyPrint()));
					textNew.setText("Enregistrez la livraison");
					
					// On remet la livraison en creation par defaut en conservant le poids
					company.getNewDelivery().clearDelivery();
					company.getNewDelivery().setWeight(weight);
					
				} else {
					textNew.setText("L'enregistrement est invalide !");
				}
				
		     }
		} );
		
		// Ajout du bouton de simulation
		// a implenter
		panelEast.add(btnSimulate);
		btnSimulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO animation d un employee faisant un aller retour entre la destination
				// et l entreprise en suivant l itineraire
				btnSimulate.setText("A implémenter");
			}
		} );
		
		// Ajout du texte d'information sur les ajouts d elements a l entreprise
		panelEast.add(textAdd);
		
		// Ajout du bouton d ajout de vehicule
		// a implementer
		panelEast.add(btnVehicle);	
		btnVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ajoutez un véhicule");
				//TODO Ouverture d'une fenêtre permettant l'ajout d'un véhicule
				btnVehicle.setText("A implémenter");
			}
		} );
		
		// Ajout du bouton d ajout d employee
		// a implementer
		panelEast.add(btnEmployee);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ajoutez une personne");
				//TODO Ouverture d'une fenêtre permettant l'ajout d'un employe
				btnEmployee.setText("A implémenter");
			}
		} );
		
		return panelEast;
	}

	/**
	 * Methode definissant la barre d'information de la fenetre.
	 * @param company
	 * @return le panel d'affichage de la barre d information
	 */
	private JPanel setBar(Company company) {
		JPanel panelSouth = new JPanel(new BorderLayout());
		
		// Mise à jour de la meilleur livraison
		company.bestDelivery();
		
		// Affichage de la meilleur livraison
		textBestDelivery.setText("Meilleur livraison :" + (company.getBestDelivery().PrettyPrint()));
		panelSouth.add(textBestDelivery);
			   
		return panelSouth;
	}
	
	/**
	 * Methode definissant la zone d'affichage des livraisons
	 * @param company
	 * @return le panel d affichage des livraison
	 */
	private JPanel setInfos(Company company) {
		JPanel panelWest= new JPanel(new BorderLayout(1,1));
		textArea.setPreferredSize(new Dimension(500,600));
		String list = "Liste des livraisons : ";
		for(Delivery d : company.getListDelivery()) {
			list = (list + "\n " + d.PrettyPrint());
		}
		textArea.setText(list);
		panelWest.add(textArea);
			
		return panelWest;
	}
	
	/**
	 * 	Redessine this
	 */
	public void update() {
		this.repaint();
		}
}

