package classes;

import java.text.SimpleDateFormat;

public class RentalDTO {
	private int id;
	private String nameString;
	private int carNum;
	private Long startDate;

	
	public RentalDTO(int count,String nameString, int carNum, Long startDate) {
		super();
		this.id = 1001+count;
		this.nameString = nameString;
		this.carNum = carNum;
		this.startDate = startDate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public Long getStartDate() {
		return startDate;
	}
	
	public Long getEndDate() {
		
		int Days= 3;
		return this.startDate+ 86400000L* Days;

	}
	
	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}
	
	public String getDateFormatted(Long date) {
		return new SimpleDateFormat("MM/dd").format(date);
	}
	
	
}
