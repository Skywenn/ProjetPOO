import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Application {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		
		// Test
		
		// Definition of the company
		Company UbDriver = new Company();
		
		// Adding default employees
		for(Employee e : Param.defaultEmployee) {
			UbDriver.addEmployee(e);
		}
		// Adding default Vehicle
		for(Vehicle v: Param.defaultVehicle) {
			UbDriver.addVehicle(v);
		}
		
		Point p1 = new Point(0,0);  
		Point p2 = new Point(500,0);
		 
		Delivery d1 = new Delivery(5, UbDriver.getListVehicle().get(0), UbDriver.getListEmployee().get(0));
		Delivery d2 = new Delivery(5, UbDriver.getListVehicle().get(0), UbDriver.getListEmployee().get(3));
		Delivery d3 = new Delivery(5, UbDriver.getListVehicle().get(4), UbDriver.getListEmployee().get(2));
		
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
		
		UbDriver.addDelivery(d1);
		UbDriver.addDelivery(d2);
		UbDriver.addDelivery(d3);
		
		for(Delivery d : UbDriver.getListDelivery()) {
			System.out.println(" Possible ? : " + d.isPossible());
		}
		
		System.out.println(UbDriver.getListDelivery());
		UbDriver.deleteWrongDelivery();
		UbDriver.bestDelivery();
		
		System.out.println(UbDriver.getListDelivery());
		System.out.println(UbDriver.getBestDelivery().PrettyPrint());
		
		//---------------------------------------------------------------------------------
		// Partie graphique
		
		// Apply LookAndField
		UIManager.setLookAndFeel(new NimbusLookAndFeel());

		Window view = new Window();
		view.setVisible(true);

	}
}
