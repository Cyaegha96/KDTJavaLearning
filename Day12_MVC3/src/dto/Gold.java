package dto;

public class Gold extends Member {

	static final double DOUBLE_POINT_BONUS = 0.04d;
	
	public Gold(int id, String name, double point) {
		super(id, name, point);
		
		
	}

	public Gold() {
		super();
	}
	
	@Override
	public double getBonus() {
		
		return getPoint() * DOUBLE_POINT_BONUS;
	}
	
	
}
