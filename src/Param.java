import java.util.ArrayList;
import java.util.Arrays;

public class Param {
	static double fuelPrice = 1.65;
	static double maxDistance = 10000; // 10km
	static double maxDuration = 180;  // 3h
	
	static Employee e1 = new Employee("Jade", 55, 7.1, CyclistType.BEGINNER);
	static Employee e2 = new Employee("Anna", 67, 7.4, CyclistType.EXPERT);
	static Employee e3 = new Employee("Blaise", 74, 7.25, CyclistType.ATHLETIC);
	static Employee e4 = new Employee("Alfred", 80, 7.2, CyclistType.NONE);
	static Employee e5 = new Employee("Tiago", 62, 7.2, CyclistType.NONE);
	
	static Bike v1 = new Bike("Cyclou", 450);
	static Bike v2 = new Bike("Vavite", 500);
	static Scooter v3 = new Scooter("Yamama", 3500, 300, 50, 7.5);
	static Scooter v4 = new Scooter("Vespo", 2500, 125, 30, 5.5);
	static Scooter v5 = new Scooter("Piagigi", 2000, 150, 35, 6);
	
	static ArrayList<Employee> defaultEmployee = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
	static ArrayList<Vehicle> defaultVehicle = new ArrayList<>(Arrays.asList(v1, v2, v3, v4, v5));
}
