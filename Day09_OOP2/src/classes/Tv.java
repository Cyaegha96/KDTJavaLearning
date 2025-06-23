package classes;

public class Tv {
	
	//클래스 설계 규칙 권고안
	//1. 정보은닉 규칙에 따라야 함
	//접근 제한자 문법과 관련 있음
	//정보 은닉에 따른 클래스 설계는 캡슐화(외부에 노출될 필요가 잇는 것만 노출한다라는 원칙)에도 영향을 미침
	private String brand;
	private int channel;
	private int volume;
	
	//클래스 구성요소
	//1.Member Field (멤버 변수): 클래스를 구성하는 멤버인 변수
	//>지역변수: 메서드 또는 메서드 내부의 {}내에 생성되는 변수
	//2. Member Method (멤버 메서드) : 클래스를 구성하는 멤버인 함수
	
	public Tv getThis() {
		return this;
	}
	
	void powerOn() {
		brand = "Hello";
	}
	void powerOff() {}
	//3. Constructor (생성자)
	//4. Nested Class (중첩 클래스)
	public String getBrand() {
		return brand;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
