package ZMS;

import java.util.ArrayList;
import java.util.List;

// Cage will specify the type of animals that can be added to the cage, 
//and will have a limit on the number of animals that can be added to the cage
public class Cage {
	private String animalType;
	private int capacityOfAnimal = 1;
	List<Animal> listOfAnimals;

	/**
	 * Initializing the cage
	 * 
	 * @param animalType
	 *            It is the type of the animal such as peacock, lion and
	 *            crocodile
	 */
	public Cage(String animalType) {
		this.animalType = animalType;
		this.listOfAnimals = new ArrayList<>();
	}

	// return type of the animal
	public String getAnimalType() {
		return animalType;
	}

	// return capacity of the animal
	public int getCapacityOfAnimal() {
		return capacityOfAnimal;
	}

	// return true if cage has capacity to store new animal else return false
	public boolean availableCapacityInCage() {
		if (listOfAnimals.size() < capacityOfAnimal)
			return true;
		return false;
	}

	// set the animal capacity for cage
	public void setCapacityOfAnimal(int capacityOfAnimal) {
		this.capacityOfAnimal = capacityOfAnimal;
	}

}
