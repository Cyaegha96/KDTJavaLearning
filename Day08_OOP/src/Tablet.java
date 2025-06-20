
public class Tablet {

	String name;
	String brand;
	
	double cpuSpeed;
	String cpuType;
	
	int mainDisplaySize;
	String mainDisplayType;
	
	boolean hasPen;
	
	int ramMemory;
	int storageMemory;
	
	boolean extraMemory;
	
	boolean hasOs;
	
	String colorType;
	
	int batterySize;
	
	public Tablet() {
		//기본 스팩은 갤탭으로 설정
		this.name = "Samsung Galaxy Tab S10";
		this.brand = "Samsung";
		this.cpuSpeed = 3.4;
		this.cpuType = "Octa-Core";
		
		this.mainDisplaySize = 315;
		this.mainDisplayType = "Dynamic Amoled 2x";
		
		this.hasPen = true;
		
		this.ramMemory = 12;
		this.storageMemory = 256;
		this.extraMemory = true;
		
		this.hasOs = true;
		
		this.colorType = "문스톤그레이";
		
		this.batterySize=10090;
		
		
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public double getCpuSpeed() {
		return cpuSpeed;
	}


	public void setCpuSpeed(double cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}


	public String getCpuType() {
		return cpuType;
	}


	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}


	public int getMainDisplaySize() {
		return mainDisplaySize;
	}


	public void setMainDisplaySize(int mainDisplaySize) {
		this.mainDisplaySize = mainDisplaySize;
	}


	public String getMainDisplayType() {
		return mainDisplayType;
	}


	public void setMainDisplayType(String mainDisplayType) {
		this.mainDisplayType = mainDisplayType;
	}


	public boolean isHasPen() {
		return hasPen;
	}


	public void setHasPen(boolean hasPen) {
		this.hasPen = hasPen;
	}


	public int getRamMemory() {
		return ramMemory;
	}


	public void setRamMemory(int ramMemory) {
		this.ramMemory = ramMemory;
	}


	public int getStorageMemory() {
		return storageMemory;
	}


	public void setStorageMemory(int storageMemory) {
		this.storageMemory = storageMemory;
	}


	public boolean isExtraMemory() {
		return extraMemory;
	}


	public void setExtraMemory(boolean extraMemory) {
		this.extraMemory = extraMemory;
	}


	public boolean isHasOs() {
		return hasOs;
	}


	public void setHasOs(boolean hasOs) {
		this.hasOs = hasOs;
	}


	public String getColorType() {
		return colorType;
	}


	public void setColorType(String colorType) {
		this.colorType = colorType;
	}


	public int getBatterySize() {
		return batterySize;
	}


	public void setBatterySize(int batterySize) {
		this.batterySize = batterySize;
	}


	public void getTableInfo() {
		System.out.println("이 타블렛의 이름은 "+getName()+"입니다.");
		System.out.println("해당 타블렛을 설계한 제조사는 "+getBrand()+"입니다");
		System.out.println("이 타블렛은 "+getCpuSpeed()+"GHZ cpu 속도를 가지고 있으며");
		System.out.println("cpu의 종류는 "+getCpuType()+"입니다");
		System.out.println("또한 "+getMainDisplaySize()+"mm 디스클레이를 가지며 종류는 "+getMainDisplayType()+"을 가집니다.");
		System.out.println("메모리는 "+getRamMemory()+"GB를 가지고, 저장 용량은 "+getStorageMemory()+"GB입니다.");
		if(extraMemory) {
			System.out.println("또한 이 타블렛은 외장메모리를 지원합니다.");
		}
	}
	
}
