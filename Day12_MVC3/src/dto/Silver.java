package dto;

public class Silver extends Member{
	
	
	public Silver(int id, String name, double point) {
		super(id, name, point);
	}

	public Silver() {}
	
	@Override
	public double getBonus() {
		
		return getPoint() * DOUBLE_POINT_BONUS;
	}
}
