package main;

import java.util.Scanner;

import dao.Manager;
import dto.Gold;
import dto.Member;
import dto.Silver;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static Manager manager = new Manager();

	static final String MENU_STRING = "menu";
	static final String SEARCH_NAME_STRING = "search";
	static final String UPDATE_NAME_STRING = "update";
	static final String DELETE_NAME_STRING = "delete";
	static final String ID_INPUT_STRING= "ID";
	static final String NAME_INPUT_STRING="NAME";
	static final String POINT_INPUT_STRING = "POINT";
	static final String ERROR_STRING = "!!제대로 된 내용을 입력해주세요!!";

	public static String inputString(String type) {

		String returnString = "";


		switch (type) {
		case NAME_INPUT_STRING:
			System.out.print("회원 이름 입력:");
			break;
		case SEARCH_NAME_STRING:
			System.out.print("검색할 이름:");
			break;
		}
		returnString = sc.nextLine();

		return returnString;
	}


	public static double inputNumberDOUBLE(String type) {

		while(true) {
			switch (type) {
			case POINT_INPUT_STRING :
				System.out.print("회원 POINT 입력:");
				break;
			}

			try {
				double num = Double.parseDouble(sc.nextLine());
				return num;
			} catch (Exception e) {
				System.out.println(ERROR_STRING);
			}
		}
	}

	public static boolean hasMembers(Manager manager) {
		if(manager.getMemberCounts() == 0) {
			System.out.println("아직 회원이 충분히 많이 등록되지 않았습니다.\n");
			return false;
		}
		return true;
	}


	public static int inputNumber(String type) {

		while(true) {
			switch (type) {
			case MENU_STRING :
				System.out.print(">>");
				break;
			case ID_INPUT_STRING :
				System.out.print("회원 ID 입력:");
				break;
			case UPDATE_NAME_STRING :
				System.out.print("수정할 ID:");
				break;
			case DELETE_NAME_STRING:
				System.out.print("삭제할 ID:");
			}

			try {
				int num = Integer.parseInt(sc.nextLine());
				if(type.equals(ID_INPUT_STRING) ) {
					if(manager.isDupId(num)) {
						System.out.println("이미 중복되는 아이디가 있습니다.");
						continue;
					}
				}
				boolean isUpdateOrDelete = type.equals(UPDATE_NAME_STRING) || type.equals(DELETE_NAME_STRING);

				if (isUpdateOrDelete && !manager.isDupId(num)) {
					System.out.println("입력한 id와 일치하는 id가 없습니다.");
					continue;
				} 

				return num;
			} catch (Exception e) {
				System.out.println(ERROR_STRING);
			}
		}
	}

	public static void memberPrint(Member[] members, int length) {

		System.out.println("회원id\t회원이름\t회원포인트\t회원보너스\t");
		for(int i=0;i<length;i++) {

			// 포맷: 아이디\t이름\t포인트(소수점2자리)\t보너스(소수점2자리)\t
			System.out.printf("%d\t%s\t%.2f\t%.2f\t\n",
					members[i].getId(), 
					members[i].getName(), 
					members[i].getPoint(), 
					members[i].getBonus());
		}
	}

	public static void menuPrint() {
		System.out.println("<<회원 관리 시스템>>");
		System.out.println("1> 신규 회원 등록");
		System.out.println("2> 회원 목록 출력");
		System.out.println("3> 회원 검색 (이름으로 검색)");
		System.out.println("4> 회원 수정 (id로 검색)");
		System.out.println("5> 회원 삭제 (id로 검색)");
		System.out.println("0> 시스템 종료");
	}

	public static void initMember() {

		manager.addMembers(new Silver(1001, "TOM", 1000));
		manager.addMembers(new Silver(1002, "Jane", 2000 ));
		manager.addMembers(new Silver(1003, "Susan", 3000));
		manager.addMembers(new Gold(1004, "Eric", 2500));

	}


	//회원관리 시스템 mvc 모델로
	public static void main(String[] args) {

		initMember();


		while(true) {
			menuPrint();
			int menuSelect= inputNumber(MENU_STRING );

			switch (menuSelect) {
			case 1: 
				//신규 회원 등록
				//id, name, point 입력 받을 것

				int id = inputNumber(ID_INPUT_STRING);
				String nameString = inputString(NAME_INPUT_STRING);
				double point = inputNumberDOUBLE(POINT_INPUT_STRING);

				//manager (dao)에게 넘겨주기
				Silver member = new Silver(id, nameString, point);
				manager.addMembers(member);

				break;

			case 2:
				//회원 목록 출력
				if(hasMembers(manager)) {

					memberPrint(manager.getMembers(), manager.getMemberCounts());
				}

				break;

			case 3:
				//회원 검색(이름으로 출력)
				if(hasMembers(manager)) {
					String searchString = inputString(SEARCH_NAME_STRING);


					Member[] memberSilver = manager.searchByName(searchString );
					memberPrint(memberSilver, memberSilver.length);

				}


				break;
			case 4:
				//회원 정보 수정


				if(hasMembers(manager)) {

					memberPrint(manager.getMembers(), manager.getMemberCounts());
					int searchId =  inputNumber(UPDATE_NAME_STRING);
					int indexUpdate = manager.getMemberIndex( searchId);
					System.out.println("<<해당 이름의 회원 내용을 다음과 같이 수정합니다.>>");

					//업데이트할 내용 받음
					int idUpdate = inputNumber(ID_INPUT_STRING);
					String nameUpdate = inputString(NAME_INPUT_STRING);
					double pointUpdate = inputNumberDOUBLE(POINT_INPUT_STRING);

					//업데이트
					manager.updateMember(new Silver(idUpdate, nameUpdate, pointUpdate ), indexUpdate);

					System.out.println("<<수정 완료>>");
					memberPrint(manager.getMembers(), manager.getMemberCounts());
				}
				break;
			case 5:
				//회원 삭제

				if(hasMembers(manager)) {
					memberPrint(manager.getMembers(), manager.getMemberCounts());

					int deleteId = inputNumber(DELETE_NAME_STRING);
					int indexDelete = manager.getMemberIndex(deleteId);
					System.out.println("<<해당 이름의 회원을 삭제합니다.>>");

					manager.deleteMember(indexDelete);

					System.out.println("<<삭제 완료>>");
					memberPrint(manager.getMembers(), manager.getMemberCounts());


				}
				break;
			case 0:
				//시스템 종료
				System.out.println("회원 관리 시스템을 종료합니다.");
				System.exit(0);

				break;
			default:
				System.out.println("제대로 된 메뉴 번호를 입력해주세요");
			}
			System.out.println();
		}

	}

}
