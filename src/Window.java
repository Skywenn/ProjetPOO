import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Window extends JFrame {
	private JTextField textField;
	
	
	public Window() {
		super("Projet POO -- USBDriver");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		setResizable(false); 
		
			
		JPanel contentPane = (JPanel) this.getContentPane();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		contentPane.add(createMenu(), BorderLayout.EAST);
		contentPane.add(createInformationBar(), BorderLayout.SOUTH);
	}
		
	
	private JPanel createMenu() {
			
		JPanel panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(12, 1, 0, 0));
		
		JButton btnEmployee = new JButton("Ajout Employée");
		btnEmployee.setPreferredSize(new Dimension(200,10));
		JButton btnVehicle = new JButton("Ajout Véhicule");
			
		textField = new JTextField();
			
		JLabel textEmployee = new JLabel("Selectionnez un employé");
		JLabel textVehicle = new JLabel("Selectionnez un véhicule");
		JLabel textWeight = new JLabel("Entrez le poids de la livraison");
		JLabel textAdd = new JLabel("Ajouter un élément à l'entreprise");
		textWeight.setPreferredSize(new Dimension(200,5));
			
		/*
		ArrayList<String> ls = new ArrayList<>(Arrays.asList("e1", "e2", "e3", "e4", "e5"));
		*/
			
		JComboBox comboBoxVehicle = new JComboBox();
		JComboBox comboBoxEmployee = new JComboBox();
			
		JButton btnCreateTrip = new JButton("Ajouter un trajet");
		JButton btnCreateDelivery = new JButton("Enregistrer la livraison");
		JButton btnSimulate = new JButton("Lancer la simulation");
		
		// Ajout des composants
		panelEast.add(textWeight);
		panelEast.add(textField);
		panelEast.add(textEmployee);
		panelEast.add(comboBoxEmployee);
		panelEast.add(textVehicle);
		panelEast.add(comboBoxVehicle);
		panelEast.add(btnCreateTrip);
		panelEast.add(btnCreateDelivery);
		panelEast.add(btnSimulate);
		panelEast.add(textAdd);
		panelEast.add(btnVehicle);	
		panelEast.add(btnEmployee);
			
		return panelEast;
	}
	
	private JPanel createInformationBar() {
		JPanel panelSouth = new JPanel(new BorderLayout(0,0));
		JLabel textInformation = new JLabel("Best Delivery : ");
		panelSouth.add(textInformation, BorderLayout.WEST);
		return panelSouth;
	}
	
	private JPanel createMap() {
		//TODO
		return new JPanel();
	}
	
}

