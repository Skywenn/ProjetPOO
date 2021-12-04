
public enum CyclistType {
	BEGINNER(10), SPORTIF(15), EXPERT(20); 
	
	private double speed;
	
	private CyclistType(double speed) {
		this.speed = speed;
	}
	
	public double getCyclistSpeed() {
		return this.speed;
	}
}
