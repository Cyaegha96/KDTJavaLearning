package dto;

//abstract가 붙음으로서 상속을 위한 클래스가 됨
public abstract class Member {
	
	static final double DOUBLE_POINT_BONUS = 0.03d;
	
	private int id;
	private String name;
	private double point;
	
	public Member() {
		
	}
	
	public Member(int id, String name, double point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	abstract public double getBonus();
}
