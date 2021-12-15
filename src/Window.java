import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Window extends JFrame{
	
	private JTextField textField;
	private JButton btnEmployee = new JButton("Ajout Employée");
	private JButton btnVehicle = new JButton("Ajout Véhicule");
	private JButton btnCreateTrip = new JButton("Ajouter un trajet");
	private JButton btnCreateDelivery = new JButton("Enregistrer la livraison");
	private JButton btnSimulate = new JButton("Lancer la simulation");

	/*
	ArrayList<String> ls = new ArrayList<>(Arrays.asList("e1", "e2", "e3", "e4", "e5"));
	*/	

	// Construction de l'interface graphique 

	public Window(Company company) {
		super("Projet POO -- USBDriver");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		setResizable(false); 
		
		JPanel contentPane = (JPanel) this.getContentPane();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		contentPane.add(createMenu(company), BorderLayout.EAST);
		contentPane.add(createInformationBar(company), BorderLayout.SOUTH);
	}
		
	
	// Menu à gauche de la fenêtre
	private JPanel createMenu(Company company) {

		JPanel panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(12, 1, 0, 0));
		
		btnEmployee.setPreferredSize(new Dimension(200,10));
		textField = new JTextField();
		
		JLabel textEmployee = new JLabel("Selectionnez un employé");
		JLabel textVehicle = new JLabel("Selectionnez un véhicule");
		JLabel textWeight = new JLabel("Entrez le poids de la livraison");
		JLabel textAdd = new JLabel("Ajouter un élément à l'entreprise");
		
		textWeight.setPreferredSize(new Dimension(200,5));

		// Ajout des boites de selections des véhicules et employés
		JComboBox<Vehicle> comboBoxVehicle = new JComboBox<Vehicle>(new Vector<Vehicle>(company.getListVehicle()));

		JComboBox<Employee> comboBoxEmployee = new JComboBox<Employee>(new Vector<Employee>(company.getListEmployee()));
		
		// Ajout des composants graphique
		panelEast.add(textWeight);
		
		
		panelEast.add(textField);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float weight = Float.parseFloat(textField.getText());
					textWeight.setText("Vous avez entrez " + weight + "kg");
				}
				catch(Exception ex) {
					textWeight.setText("Entrez un nombre pour le poids svp");
				}
			}
		} );
		
		panelEast.add(textEmployee);
		
		panelEast.add(comboBoxEmployee);
		comboBoxEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.out.println("Valeur: " + comboBoxEmployee.getSelectedItem().toString());      
		     }
		} );
		
		
		panelEast.add(textVehicle);
		panelEast.add(comboBoxVehicle);
		comboBoxVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.out.println("Valeur: " + comboBoxVehicle.getSelectedItem().toString());      
		     }
		} );
		
		panelEast.add(btnCreateTrip);
		panelEast.add(btnCreateDelivery);
		panelEast.add(btnSimulate);
		panelEast.add(textAdd);
		
		panelEast.add(btnVehicle);	
		btnVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ajoutez un véhicule");
				//TODO
				btnVehicle.setText("A implémenter");
			}
		} );
		
		panelEast.add(btnEmployee);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ajoutez une personne");
				//TODO
				btnEmployee.setText("A implémenter");
			}
		} );
			
		return panelEast;
	}

	// Barre d'information en bas de fenêtre
	private JPanel createInformationBar(Company company) {
		JPanel panelSouth = new JPanel(new BorderLayout(0,0));
		
		JLabel textList = new JLabel("List of possible Delivery : " + company.getListDelivery().toString());
		panelSouth.add(textList, BorderLayout.NORTH);
		
		JLabel textBest = new JLabel("Best Delivery : " + company.getBestDelivery().toString());
		panelSouth.add(textBest, BorderLayout.SOUTH);
		
		return panelSouth;
	}
	
	
	private JPanel createMap() {
		//TODO
		return new JPanel();
	}

}

