
public class Application {

	public static void main(String[] args) {
		
		Cyclist c1 = new Cyclist("bob", 65, 1200, CyclistType.BEGINNER);
		Bike v1 = new Bike("bicloo", 50);
		
		Point pt = new Point(1,1);
		Point pt1 = new Point(32,2);
		
		System.out.println(v1.getAvgSpeed(c1));
		System.out.println(pt.getDistance(pt1));
		System.out.println(pt.getRoundDistance(pt1));

	}
}
