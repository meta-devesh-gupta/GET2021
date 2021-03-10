package ZMS;

public class Crocodile extends Reptile {

	/**
	 * Initializing crocodile object
	 * 
	 * @param name
	 *            It is the name of the crocodile
	 * @param age
	 *            It is the age of the crocodile
	 * @param weight
	 *            It is the weight of crocodile
	 */
	public Crocodile(String name, int age, int weight) {
		super(name, age, weight, "Crocodile");
	}

	@Override
	public String getSound() {
		return new String("Hiss");
	}

	@Override
	public String toString() {
		return "Crocodile [Sound=" + getSound() + ", Id=" + getId()
				+ ", Name=" + getName() + ", Age=" + getAge()
				+ ", Weight=" + getWeight() + ", AnimalCategory="
				+ getAnimalCategory() + ", AnimalType=" + getAnimalType()
				+ "]";
	}

}
