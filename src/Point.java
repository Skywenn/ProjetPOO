
public class Point {
	private int x;
	private int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double getDistance(Point pt) {
		return Math.sqrt((pt.getY() - y) * (pt.getY() - y) + (pt.getX() - x) * (pt.getX() - x));
	}
	
	public double getRoundDistance(Point pt) {
		return Math.round((Math.sqrt((pt.getY() - y) * (pt.getY() - y) + (pt.getX() - x) * (pt.getX() - x)))*1000.0)/1000.0;
	}
}
