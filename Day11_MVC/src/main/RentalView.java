package main;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import classes.RentalDTO;
import models.RentalDAO;

//렌트카 관리 시스템
public class RentalView {

	static Scanner sc = new Scanner(System.in);


	public static boolean search(RentalDAO rentalDAO) {

		Boolean isResult = false;

		System.out.print("검색할 예약자 이름 :");

		String searchString = sc.nextLine();

		System.out.println("예약번호\t예약자\t차번호\t시작일\t반환일\t");

		//		boolean isDuli= false;

		//		for(int i=0;i<rentalDAO.getRentalCount();i++) {
		//				if(rentalDAO.isDupli(searchString, i)) {
		//					printRental(rentalDAO.getRental(i));
		//					isDuli= true;
		//				}
		//			}
		//		if(!isDuli) {
		//			System.out.println("~~검색한 예약자 정보가 존재하지 않습니다~~");
		//		}

		RentalDTO[] newDtos = rentalDAO.getSearchedDTO(searchString);
		if(!(newDtos.length==0)) {
			for(int i=0;i<newDtos.length;i++) {
				printRental(newDtos[i]);
			}
			isResult=true;
		}else {
			System.out.println("~~검색한 예약자 정보가 존재하지 않습니다~~");
			isResult=false;
		}

		return isResult;
	}

	public static long inputDate() {
		while(true) {
			System.out.print("대여 시작일:");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년MM월dd일");

			try {
				String dateString = sc.nextLine();
				Date startDate=simpleDateFormat.parse(dateString);
				if(startDate==null) {
					System.out.println("포맷에 맞게 날짜를 입력해주세요");
				}else {
					return startDate.getTime();
				}


			} catch (ParseException e) {
				System.out.println("포맷에 맞게 날짜를 입력해주세요");
			}
		}

	}

	public static int inputNumber(String type) {

		while(true) {
			if(type.equals("menu")) {
				System.out.print(">>");
			}
			if(type.equals("carNumber")) {
				System.out.print("차번호:");
			}
			if(type.equals("change")) {
				System.out.print("수정할 예약 번호:");
			}
			if(type.equals("delete")) {
				System.out.print("삭제할 예약 번호:");
			}

			try {
				int num = Integer.parseInt(sc.nextLine());
				return num;
			} catch (Exception e) {
				System.out.println("!!제대로 된 번호를 입력해주세요!!");
			}
		}
	}

	public static void printRental(RentalDTO dto) {
		System.out.println(dto.getId()+"\t"+dto.getNameString()+"\t"+dto.getCarNum()+"\t"+dto.getDateFormatted(dto.getStartDate())+"\t"+ dto.getDateFormatted(dto.getEndDate()));

	}

	public static void printRentalAll(RentalDAO rentalDAO) {
		for(int i=0;i< rentalDAO.getRentalCount();i++) {
			printRental(rentalDAO.getRental(i));
		}
	}


	public static void showMenu() {

		System.out.println("<<렌트카 관리 시스템>>");
		System.out.println("1. 신규 예약 등록");
		System.out.println("2. 예약 목록 출력");
		System.out.println("3. 예약 검색 (예약자 이름으로 검색)");
		System.out.println("4. 예약 수정");
		System.out.println("5. 예약 삭제");
		System.out.println("0. 시스템 종료");
	}

	public static void main(String[] args) {

		RentalDAO rentalDAO = new RentalDAO();



		while(true) {

			showMenu();
			int num = inputNumber("menu");
			switch (num) {
			case 1: 

				if(rentalDAO.getRentalCount()>=3) {
					System.out.println("더이상 예약자를 받을 수 없습니다.");
				}else {
					System.out.print("예약자 이름:");
					String nameString = sc.nextLine();

					int carNumber = inputNumber("carNumber");

					long dateStamp = inputDate();

					RentalDTO dto = new RentalDTO(rentalDAO.getRentalCount(), nameString, carNumber, dateStamp);
					rentalDAO.addRentals(dto);

				}


				break;
			case 2:
				//예약 목록 출력
				if(rentalDAO.getRentalCount()==0) {

					System.out.println("아직 렌탈 예약자가 없습니다.");

				}else {

					System.out.println("예약번호\t예약자\t차번호\t시작일\t반환일\t");
					printRentalAll(rentalDAO);

				}

				break;
			case 3:
				//예약 검색

				if(rentalDAO.getRentalCount()==0) {
					System.out.println("아직 렌탈 예약자가 없습니다.");
				}else {
					search(rentalDAO);
				}

				break;

			case 4:
				//예약 수정
				if(rentalDAO.getRentalCount()==0) {
					System.out.println("아직 렌탈 예약자가 없습니다.");
				}else {
					if(search(rentalDAO)) {
						System.out.println();
						change: while(true) {
							int idForChange = inputNumber("change");
							for(int i=0;i<rentalDAO.getRentalCount();i++) {
								if(rentalDAO.getRental(i).getId() == idForChange) {
									//예약 수정
									System.out.println(rentalDAO.getRental(i).getId()+"번 예약 수정<<");
									System.out.print("예약자 이름:");
									String nameString = sc.nextLine();

									int carNumber = inputNumber("carNumber");

									long dateStamp = inputDate();


									RentalDTO dto = new RentalDTO(i, nameString, carNumber, dateStamp);
									rentalDAO.updateRental(i, dto);

									System.out.println(">>예약 수정 완료<<");
									break change;
								}
							}

							System.out.println("일치하는 id가 없습니다");
						}  
					}

				}


				break;
			case 5:
				//예약 삭제
				if(rentalDAO.getRentalCount()==0) {
					System.out.println("아직 렌탈 예약자가 없습니다.");
				}else {
					if(search(rentalDAO)) {
						System.out.println();
						delete: while(true) {
							int idForDelete = inputNumber("delete");
							for(int i=0;i<rentalDAO.getRentalCount();i++) {
								if(rentalDAO.getRental(i).getId() == idForDelete) {
									//예약 삭제
									System.out.println(rentalDAO.getRental(i).getId()+"번 예약 삭제<<");

									rentalDAO.deleteRental(i);
									break delete;
								}
							}
						}
					}
				}


				break;
			case 0 :
				System.out.println("렌트카 시스템을 종료합니다");
				System.out.println("...");
				System.out.println("...bye");
				System.exit(0);

			default:
				System.out.println("!!메뉴 안에서 번호를 골라주세요!!");
				break;

			}
			System.out.println();
		}


	}
}
