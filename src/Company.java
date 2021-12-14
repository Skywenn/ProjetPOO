import java.util.ArrayList;

public class Company {
	private ArrayList<Employee> listEmployee;
	private ArrayList<Vehicle> listVehicle;
	private ArrayList<Delivery> listDelivery;
	private Delivery bestDelivery;
	
	public Company() {
		this.listEmployee = new ArrayList<Employee>();
		this.listVehicle = new ArrayList<Vehicle>();
		this.listDelivery = new ArrayList<Delivery>();
	}

	public ArrayList<Employee> getListEmployee() {
		return listEmployee;
	}

	public ArrayList<Vehicle> getListVehicle() {
		return listVehicle;
	}

	public ArrayList<Delivery> getListDelivery() {
		return listDelivery;
	}
	
	public Delivery getBestDelivery() {
		return bestDelivery;
	}
	
	public void addEmployee(Employee e) {
		listEmployee.add(e);
	}
	
	public void addVehicle(Vehicle v) {
		listVehicle.add(v);
	}
	
	public void addDelivery(Delivery d) {
		listDelivery.add(d);
	}
	
	public void deleteWrongDelivery() {
		for(Delivery d : this.getListDelivery()) {
			if (d.isPossible() == false) {
				listDelivery.remove(d);
			}
		}
	}
	
	// Return the best delivery and delete the not possible ones
	public void bestDelivery() {
		// Delete all the not possible delivery
		this.deleteWrongDelivery();
		Delivery best = listDelivery.get(0);
		for(Delivery d : this.getListDelivery()) {
			if (d.isBetterThan(best)){
				best = d;
			}
		}
		this.bestDelivery = best;
	}
}
