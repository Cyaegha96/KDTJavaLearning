package pack2;

import pack1.Animal;

public class Zoo {
	
	private Animal[] animals = new Animal[20];
	private int animalCount = 0;
	
	public void cage(Animal animal) {
		animals[animalCount] = animal;
		animalCount++;
	}
	
	public Animal getAnimal(int index) {
		return animals[index];
	}

}
