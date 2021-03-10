package ZMS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZooTest {
	Zoo zoo;

	@Before
	public void init() {
		zoo = new Zoo();
		zoo.addZone("Mammal", true, true);
		zoo.addZone("Bird", true, true);
		zoo.addZone("Reptile", true, false);
	}

	@Test
	public void addAnimalTest() {
		Lion lion1 = new Lion("First Lion", 12, 130);
		Crocodile crocodile1 = new Crocodile("First Crocodile", 17, 145);
		Peacock peacock1 = new Peacock("Second Peacock", 15, 130);

		assertTrue(zoo.addAnimal(lion1));
		assertTrue(zoo.addAnimal(crocodile1));
		assertTrue(zoo.addAnimal(peacock1));

		// Can't create another cage and add animal because cage and zone limit
		// is 1
		Lion lion2 = new Lion("First Lion", 12, 130);
		assertFalse(zoo.addAnimal(lion2));

	}

	@Test
	public void addZone() {
		// creating zone
		assertTrue(zoo.addZone("Mammal", true, true));

		// adding animals into zones
		Lion lion1 = new Lion("First Lion", 12, 130);
		Crocodile crocodile1 = new Crocodile("First Crocodile", 17, 145);
		Peacock peacock1 = new Peacock("Second Peacock", 15, 130);

		assertTrue(zoo.addAnimal(lion1));
		assertTrue(zoo.addAnimal(crocodile1));
		assertTrue(zoo.addAnimal(peacock1));

		// animal will be added in 2 mammal zone
		Lion lion2 = new Lion("First Lion", 12, 130);
		assertTrue(zoo.addAnimal(lion2));

		// Can't create another cage and add animal because cage and zone limit
		// is 1
		Lion lion3 = new Lion("Second Lion", 12, 130);
		assertFalse(zoo.addAnimal(lion3));
	}

	@Test
	public void addCageTest() {

		Zone zoneMammal = zoo.getZone(1);
		assertTrue(zoo.addCage("Lion", zoneMammal));

		Zone zoneBird = zoo.getZone(2);
		assertTrue(zoo.addCage("peacock", zoneBird));

		Zone zoneReptile = zoo.getZone(3);
		assertTrue(zoo.addCage("crocodile", zoneReptile));

		// if zone=null
		assertFalse(zoo.addCage("lion", null));

	}

	@Test
	public void removeAnimalTest(){
		
		//creating and adding animal
		
		Lion lion1 = new Lion("First Lion", 12, 130);
		Crocodile crocodile1 = new Crocodile("First Crocodile", 17, 145);
		Peacock peacock1 = new Peacock("First Peacock", 15, 130);

		assertTrue(zoo.addAnimal(lion1));
		assertTrue(zoo.addAnimal(crocodile1));
		assertTrue(zoo.addAnimal(peacock1));

		//removing animal
		//zoo.displayAnimals();
		assertTrue(zoo.removeAnimal(10));
		assertTrue(zoo.removeAnimal(11));
		assertTrue(zoo.removeAnimal(12));
		
		//removing animal on invalid id
		assertFalse(zoo.removeAnimal(10));
		assertFalse(zoo.removeAnimal(-90));
	}
}
