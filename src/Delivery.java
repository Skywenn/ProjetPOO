import java.util.ArrayList;

// For now, we consider that the distance between two point is 1km

public class Delivery {
	
	private ArrayList<Point> trip;
	private double weight;
	private Vehicle vehicle;
	private Employee employee;
	
	public Delivery(double weight, Vehicle vehicle, Employee employee) {
		this.trip = new ArrayList<Point>();
		this.weight = weight;
		this.vehicle = vehicle;
		this.employee = employee;
	}

	public ArrayList<Point> getItinetary() {
		return trip;
	}

	public double getWeight() {
		return weight;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public double getTotalDistance() {
		double distance = 0;
		for (int i = 0; i < trip.size()-1; i++ ) {
			distance = trip.get(i).getDistance(trip.get(i+1));
		}
		// Multiply by 2 to count the round trip 
		return Math.ceil(distance*2*100)/100;
	}
	// Math.round(0.912385 * 100000) / 100000
	public double getDuration() {
		// Time = Distance / Speed
		return Math.ceil((this.getTotalDistance()/vehicle.getAvgSpeed(employee))*100)/100;
	}
	
	// The delivery paydoad is the maximum between the vehicle and employee payload
	public double getDeliveryPayLoad(){
		return Math.max(vehicle.getPayLoad(), employee.getPayLoad());
	}
	
	public double getDeliveryEmission() {
		// Emissions per kilometer * distance
		return Math.ceil((vehicle.getEmission()*(this.getTotalDistance())/1000)*100)/100;
	}
	
	public double getDeliveryCost() {
		// Time in hour * Salary per hour + Vehicle's cost per kilometer * total distance
		return Math.ceil((employee.getSalary()*this.getDuration() + vehicle.getCost()*this.getTotalDistance())*100)/100;
	}
	
	public void addPoint(Point pt) {
		trip.add(pt);
	}
	
	// Return false if the other delivery is better, true otherwise
	// using this formula ((c1 > c2) and (p1 > p2)) or ((c1 > c2) and (p1 = p2)) or ((c1 = c2) and (p1 > p2))
	public boolean isBetterThan(Delivery other) {
		double p1 = this.getDeliveryCost();
		double c1 = this.getDeliveryEmission();
		double p2 = other.getDeliveryCost();
		double c2 = other.getDeliveryEmission();
		if ( ((c1>c2) && (p1>p2)) || ((c1>c2) && (p1==p2)) || ((c1==c2) && (p1>p2)) ){
			return false;
		}
		return true;
 	}
	
	// Return true if the delivery is possible, false otherwise
	public boolean isPossible() {
		// if the employee can not ride, return false
		if( (employee.getCyclistType()== CyclistType.NONE) && (vehicle instanceof Bike) ) {
			return false;
		}
		// if the load is too heavy, return false
		if(this.getDeliveryPayLoad() < weight) {
			return false;
		}
		// if the trip is too long, return false
		if( (this.getDuration() > Param.maxDuration) || (this.getTotalDistance() > Param.maxDistance) ) {
			return false;
		}
		return true;
	}
	
	public String PrettyPrint() {
		return "Distance :" + this.getTotalDistance() 
				+ " / Temps :" + this.getDuration()
				+ " / Cout :" + this.getDeliveryCost()
				+ " / Employee :" + this.employee.getName()
				+ " / Véhicule :" + this.vehicle.getName()
				+ " / Emission :" + this.getDeliveryEmission();			
	}
}




