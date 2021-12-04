import java.util.ArrayList;

// For now, we consider that the distance between two point is 1km

public class Delivery {
	
	private ArrayList<Point> itinetary;
	private double weight;
	private Vehicle vehicle;
	private Employee employee;
	
	public Delivery(ArrayList<Point> itinetary, double weight, Vehicle vehicle, Employee employee) {
		this.itinetary = itinetary;
		this.weight = weight;
		this.vehicle = vehicle;
		this.employee = employee;
	}

	public ArrayList<Point> getItinetary() {
		return itinetary;
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
		for (int i = 0; i < itinetary.size()-1; i++ ) {
			distance = itinetary.get(i).getDistance(itinetary.get(i+1));
		}
		return distance;
	}
	
	public double getDuration() {
		// TODO 
		return 0;
	}
	
	public double getDeliveryEmission() {
		return vehicle.getEmission()*this.getTotalDistance();
	}
	
	public double getDeliveryCost() {
		// TODO
		return 0;
	}
}
