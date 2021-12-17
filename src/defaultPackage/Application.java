package defaultPackage;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Interface.DeliveryMan;
import Interface.InfoWindow;
import Interface.MapWindow;
import Interface.NewPath;
import Interface.Path;

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
		Delivery d2 = new Delivery(5, company.getListVehicle().get(3), company.getListEmployee().get(3));
		Delivery d3 = new Delivery(5, company.getListVehicle().get(4), company.getListEmployee().get(2));
		d1.setTrip(Param.defaultTrip);
		d2.setTrip(Param.defaultTrip);
		d3.setTrip(Param.defaultTrip);
		
		
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
		
		company.bestDelivery();
		company.getNewDelivery().setTrip(new ArrayList<>(Arrays.asList(Param.base, Param.destination)));
		
		//---------------------------------------------------------------------------------
		// Partie graphique
		
		// Apply LookAndField
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		Path path = new Path(company);
		NewPath newPath = new NewPath(company);
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				InfoWindow info = new InfoWindow(company);
				info.setVisible(true);
				
				MapWindow map = new MapWindow(company);
				map.addDrawable(path);
				path.setWindow(map);
				
				map.addDrawable(newPath);
				newPath.setWindow(map);		
				
				map.setVisible(true);
			}
		});
		
	}
}
