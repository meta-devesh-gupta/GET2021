package ZMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {

	List<Zone> listOfZones = new ArrayList<>();
	Map<Integer, Animal> listOfAnimals = new HashMap<>();
	String[] animalCategories = { "Mammal", "Reptile", "Bird" };
	String[] animalTypes = { "Lion", "Crocodile", "Peacock" };

	/**
	 * This method will add the animal to the zoo and will create cage
	 * automatically if zone has the capacity
	 * 
	 * @param animal
	 *            It is the animal that needs to be added in the zoo
	 * @return true if animal can be added in the zoo else return false
	 */
	public boolean addAnimal(Animal animal) {
		boolean flag = false;
		// if zone is of same animal category and has capacity and cage is of
		// same animal type and have capacity
		for (Zone currentZone : listOfZones) {
			if (currentZone.getZoneAnimalCategory().equalsIgnoreCase(
					animal.getAnimalCategory())
					&& currentZone.zoneHasCapacity()) {

				for (Cage cage : currentZone.listOfCages) {
					if (cage.getAnimalType().equalsIgnoreCase(
							animal.getAnimalType())
							&& cage.availableCapacityInCage()) {
						cage.listOfAnimals.add(animal);
						cage.setCapacityOfAnimal(cage.getCapacityOfAnimal() - 1);
						listOfAnimals.put(animal.getId(), animal);
						flag = true;
						break;
					}
				}

			}
		}
		// adding cage if zone has the capacity
		if (!flag) {
			for (Zone currentZone : listOfZones) {
				if (currentZone.getZoneAnimalCategory().equalsIgnoreCase(
						animal.getAnimalCategory())
						&& currentZone.zoneHasCapacity()) {
					Cage cage = new Cage(animal.getAnimalType());
					cage.listOfAnimals.add(animal);
					listOfAnimals.put(animal.getId(), animal);
					currentZone.listOfCages.add(cage);
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * This method will add zone to the zoo
	 * 
	 * @param zoneAnimalCategory
	 *            It is the animal category of the zone such as Bird, Reptile
	 *            and Mammal
	 * @param hasPark
	 *            It is true if zone has park else false
	 * @param hasCanteen
	 *            It is true if zone has canteen else false
	 * @return true if zone can be added in the zoo
	 */
	public boolean addZone(String zoneAnimalCategory, boolean hasPark,
			boolean hasCanteen) {
		boolean flag = false;
		for (String currentAnimalCategory : animalCategories) {
			if (currentAnimalCategory.equalsIgnoreCase(zoneAnimalCategory)) {
				flag = true;
				break;
			}
		}
		if (!flag)
			return flag;

		Zone zone = new Zone(zoneAnimalCategory, hasPark, hasCanteen);
		listOfZones.add(zone);
		return flag;
	}

	/**
	 * This method will get the zone of the zone id
	 * 
	 * @param id
	 *            It is the id of zone
	 * @return the zone which has same id as given in the input
	 */
	public Zone getZone(int id) {
		Zone zone = null;
		for (Zone currentZone : listOfZones) {
			if (currentZone.getZoneId() == id) {
				zone = currentZone;
				break;
			}
		}
		if (zone == null)
			throw new AssertionError("Invalid zone id...zone not found");
		return zone;
	}

	/**
	 * This method will display all the zone in the zoo
	 */
	public void displayZone() {
		for (Zone zone : listOfZones)
			System.out.println(zone);
	}

	/**
	 * This method will display all the animal in the zoo
	 */
	public void displayAnimals() {
		for (Map.Entry<Integer, Animal> mapEntry : listOfAnimals.entrySet()) {
			System.out.println((Animal) mapEntry.getValue());
		}
	}

	/**
	 * This method will add cage to the input zone
	 * 
	 * @param animalType
	 *            It is the type of animal such as peacock, lion and crocodile
	 * @param zone
	 *            It the zone in which cage has to be added
	 * @return true if cage can be added to the zone else return false
	 */
	public boolean addCage(String animalType, Zone zone) {
		if (zone == null)
			return false;
		boolean flag = false;
		// validating animal type
		for (String currentAnimalType : animalTypes) {
			if (currentAnimalType.equalsIgnoreCase(animalType)) {
				flag = true;
				break;
			}
		}
		if (!flag) // invalid animal type
			return false;

		if (!zone.zoneHasCapacity())
			return false;
		Cage cage = new Cage(animalType);
		zone.listOfCages.add(cage);
		return true;
	}

	/**
	 * This method will remove the animal from the zoo
	 * 
	 * @param id
	 *            It is the id of the animal which needs to be removed
	 * @return true if animal can be removed
	 */
	public boolean removeAnimal(int id) {
		if (!listOfAnimals.containsKey(id)) // animal not present in the zoo
			return false;

		Animal animal = listOfAnimals.get(id);
		boolean flag = false;
		for (Zone currentZone : listOfZones) {
			if (currentZone.getZoneAnimalCategory().equals(
					animal.getAnimalCategory())) {

				for (Cage cage : currentZone.listOfCages) {
					if (cage.getAnimalType().equals(animal.getAnimalType())) {
						cage.listOfAnimals.remove(animal);
						cage.setCapacityOfAnimal(cage.getCapacityOfAnimal() + 1);
						listOfAnimals.remove(animal.getId());
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}

}
