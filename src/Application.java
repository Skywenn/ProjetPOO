
public class Application {

	public static void main(String[] args) {
		
		// Test
		
		// Definition of the company
		Company UbDriver = new Company();
		
		// Adding employees 
		Employee e1 = new Employee("Jade", 55, 7.1, CyclistType.BEGINNER);
		Employee e2 = new Employee("Anna", 67, 7.4, CyclistType.EXPERT);
		Employee e3 = new Employee("Blaise", 74, 7.25, CyclistType.ATHLETIC);
		Employee e4 = new Employee("Alfred", 80, 7.2, CyclistType.NONE);
		Employee e5 = new Employee("Tiago", 62, 7.2, CyclistType.NONE);
		
		Bike v1 = new Bike("Cyclou", 450);
		Bike v2 = new Bike("Vavite", 500);
		Scooter v3 = new Scooter("Yamama", 3500, 300, 50, 7.5);
		Scooter v4 = new Scooter("Vespo", 2500, 125, 30, 5.5);
		Scooter v5 = new Scooter("Piagigi", 2000, 150, 35, 6);
		
		
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
		
		
		Delivery d1 = new Delivery(5, v1, e1);
		Delivery d2 = new Delivery(5, v1, e4);
		Delivery d3 = new Delivery(5, v5, e3);
		
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
