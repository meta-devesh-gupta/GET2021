package ZMS;

//Animal is the base class
public abstract class Animal {
	private static int count = 0;
	private final int id;
	private String name;
	private int age;
	private int weight;
	private String animalCategory;
	private String animalType;

	/**
	 * Initializing the animal
	 * 
	 * @param name
	 *            It is the name of the animal
	 * @param age
	 *            It is the name age of the animal
	 * @param weight
	 *            weight of the animal
	 * @param animalCategory
	 *            It is the animal category of the animal
	 * @param animalType
	 *            It is the animal type of the animal
	 */
	public Animal(String name, int age, int weight, String animalCategory,
			String animalType) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.animalCategory = animalCategory;
		this.animalType = animalType;
		count++;
		this.id = count;
	}

	//return Id of the animal
	public int getId() {
		return id;
	}

	//return name of the animal
	public String getName() {
		return name;
	}

	//set the name of the animal
	public void setName(String name) {
		this.name = name;
	}

	//return age of the animal
	public int getAge() {
		return age;
	}

	//set the age of the 
	public void setAge(int age) {
		this.age = age;
	}

	//return weight of the animal
	public int getWeight() {
		return weight;
	}

	//set weight of the animal
	public void setWeight(int weight) {
		this.weight = weight;
	}

	//return animal category
	public String getAnimalCategory() {
		return animalCategory;
	}

	//set animal category
	public void setAnimalCategory(String animalCategory) {
		this.animalCategory = animalCategory;
	}

	//return animal type
	public String getAnimalType() {
		return animalType;
	}

	//set animal type
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	//return the sound of the animal
	public abstract String getSound();
}
