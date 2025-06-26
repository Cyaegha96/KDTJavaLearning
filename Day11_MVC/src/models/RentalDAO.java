package models;

import classes.RentalDTO;

public class RentalDAO {

	
	private RentalDTO[] rentals = new RentalDTO[3];
	private int rentalIndex = 0;
	
	
	public RentalDTO[] getRentals() {
		return rentals;
	}
	
	//Create 
	//view에서 생성된 이용자 한명의 예약정보 Rental인스턴스를 받아서
	//Rental 인스턴스를 여러개 보관할 수 잇는 배열에 저장하는 것
	public void addRentals(RentalDTO rental) {
		this.rentals[rentalIndex] = rental;
		rentalIndex++;
	}
	
	public RentalDTO getRental(int index) {
		return rentals[index];
	}
	
	public int getRentalCount() {
		return rentalIndex;
	}
	
	//string값을 받으면 해당 스트링값과 이름값이 일치하는 RentalDTO 배열을 리턴합니다
	public RentalDTO[] getSearchedDTO(String searchString) {
		int count=0;
		
		for(int i=0;i<this.rentalIndex;i++) {
			if(rentals[i].getNameString().contains(searchString)) {
				count++;
			}
		}
		
		RentalDTO[] newDtos = new RentalDTO[count];
		count = 0;
		for(int i=0;i<this.rentalIndex;i++) {
			if(rentals[i].getNameString().contains(searchString)) {
				newDtos[count] = rentals[i];
				count++;
			}
		}
		
		return newDtos;
	}
	
	
	public boolean isDupli(String searchString,int index ) {
		if(rentals[index].getNameString().contains(searchString)) {
			return true;
		}
		return false;
	}
	
	public void updateRental(int index, RentalDTO rentalDTO) {
		rentals[index] = rentalDTO;
	}
	
	
	public void deleteRental(int index) {
		for(int j=index;j<rentalIndex;j++) {
			if(j+1<rentalIndex) {
				rentals[j+1].setId(rentals[j+1].getId()-1);
				rentals[j] = rentals[j+1];
			}	
		}
		
		rentalIndex--;
	}
	
}
