
public class Application {

	public static void main(String[] args) {
		
		Cyclist c1 = new Cyclist("bob", 65, 1200, CyclistType.BEGINNER);
		Bike v1 = new Bike("bicloo", 50);
		
		System.out.println(v1.getAvgSpeed(c1));
	}
}
