package pack2;

import pack1.Car;

public class ParkingTower {
	private Car[] cars = new Car[10];
	int index=0;
	
	public void parking(Car car) {
		cars[index] = car;
		index++;
	}
	
	
	public Car pickUp(String carName) {
		Car pickupCar=null;
		
		for(int i=0;i<index;i++) {
			if(cars[i].getName().equals(carName)) {
				pickupCar=cars[i];
			}
		}
		return pickupCar;
	
	}
	
	
}
