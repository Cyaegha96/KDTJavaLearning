package main;

import pack1.Animal;
import pack1.Car;
import pack2.ParkingTower;
import pack2.Zoo;

public class Main {
	public static void main(String[] args) {

//		Car car1 = new Car("범블비","오토봇");
//		Car car2 = new Car("옵티머스 프라임","오토봇");
//		Car car3 = new Car("메가트론","디셉티콘");
//	
//		ParkingTower tower = new ParkingTower();
//		
//		tower.parking(car1);
//		tower.parking(car2);
//		tower.parking(car3);
//		
//		
//		//------- 주차완료
//		
//		Car myCar = tower.pickUp("메가트론");
//		System.out.println(myCar.getName()+" ("+myCar.getBrand()+") ");
//		
		
		Zoo zoo = new Zoo();
		
		
		Animal animal1 = new Animal("얼룩말", 5);
		Animal animal2 = new Animal("고양이", 4);
		Animal animal3 = new Animal("강아지", 7);
		
		//동물원에 방 배정해주기
		//2번 방 동물 데려와서 무슨 동물인지 나이가 몇살인지 출력
		
		zoo.cage(animal1);
		zoo.cage(animal2);
		zoo.cage(animal3);
		
		Animal trainAnimal = zoo.getAnimal(1);
		System.out.println(trainAnimal.getName()+"는 "+trainAnimal.getAge()+"살 먹은 동물입니다.");
		
	}

}
