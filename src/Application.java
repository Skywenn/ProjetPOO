
public class Application {

	public static void main(String[] args) {
		
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
		 
		/*
		System.out.println(v3.getCost());
		System.out.println(v1.getCost());
		System.out.println(CyclistType.BEGINNER.getTypeSpeed());
		System.out.println(e1.getCyclistSpeed());
		System.out.println(v1.getAvgSpeed(e4)); // Exception to do
		System.out.println(v1.getAvgSpeed(e3)); 
		System.out.println(v4.getAvgSpeed(e3)); 
		System.out.println(v4.getAvgSpeed(e5));
		*/
		
		
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
	}
}
