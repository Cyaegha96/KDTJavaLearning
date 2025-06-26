package pack1;

public class Car {
	private String brand;
	private String name;
	
	public Car() {
		super();
	}
	
	public Car(String name, String brand) {
		super();
		this.brand = brand;
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
