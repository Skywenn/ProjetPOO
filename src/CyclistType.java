
public enum CyclistType {
	BEGINNER(10), SPORTIF(15), EXPERT(20); 
	
	private int speed;
	
	private CyclistType(int speed) {
		this.speed = speed;
	}
	
	public int getCyclistSpeed() {
		return this.speed;
	}
}
