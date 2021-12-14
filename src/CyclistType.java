
public enum CyclistType {
	BEGINNER(10), ATHLETIC(15), EXPERT(20), NONE(0); 
	
	private double speed;
	
	private CyclistType(double speed) {
		this.speed = speed;
	}
	
	public double getTypeSpeed() {
		return this.speed;
	}
}
