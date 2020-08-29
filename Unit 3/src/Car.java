
public class Car implements Measurable {
	
	private int speed;
	private String type;
	
	public Car(String type, int speed) {
		this.speed = speed;
		this.type = type;
	}

	@Override
	public int getMeasure() {
		return speed;
	}
	
	@Override
	public String toString() {
		return "Car [Type: " +type+ ", Speed: " +speed+ "]\n";
	}
}
