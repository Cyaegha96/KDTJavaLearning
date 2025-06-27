package dto;

public class Topaz extends Member {
	
	static final double DOUBLE_POINT_BONUS = 0.05d;
	
	public Topaz(int id, String name, double point) {
		super(id, name, point);
	}
	

	public Topaz() {
		super();
	}

	@Override
	public double getBonus() {
		return getPoint() * DOUBLE_POINT_BONUS;
	}

}
