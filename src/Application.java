import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Application {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		
		// Test
		
		// Definition of the company
		Company company = new Company();
		
		// Adding default employees
		for(Employee e : Param.defaultEmployee) {
			company.addEmployee(e);
		}
		// Adding default Vehicle
		for(Vehicle v: Param.defaultVehicle) {
			company.addVehicle(v);
		}
		
		Point p1 = new Point(0,0);  
		Point p2 = new Point(500,0);
		 
		Delivery d1 = new Delivery(5, company.getListVehicle().get(0), company.getListEmployee().get(0));
		Delivery d2 = new Delivery(5, company.getListVehicle().get(0), company.getListEmployee().get(3));
		Delivery d3 = new Delivery(5, company.getListVehicle().get(4), company.getListEmployee().get(2));
		
		// Will be done with the graphic interface when creating a delivery
		d1.addPoint(p1);
		d1.addPoint(p2);
		d2.addPoint(p1);
		d2.addPoint(p2);
		d3.addPoint(p1);
		d3.addPoint(p2);
		
		System.out.println(d1.PrettyPrint());
		System.out.println(d2.PrettyPrint());
		System.out.println(d3.PrettyPrint());
		
		company.addDelivery(d1);
		company.addDelivery(d2);
		company.addDelivery(d3);
		
		for(Delivery d : company.getListDelivery()) {
			System.out.println(" Possible ? : " + d.isPossible());
		}
		
		System.out.println(company.getListDelivery());
		company.deleteWrongDelivery();
		company.bestDelivery();
		
		System.out.println(company.getListDelivery());
		System.out.println(company.getBestDelivery().PrettyPrint());
		
		//---------------------------------------------------------------------------------
		// Partie graphique
		
		// Apply LookAndField
		UIManager.setLookAndFeel(new NimbusLookAndFeel());

		Window view = new Window(company);
		view.setVisible(true);

	}
}
