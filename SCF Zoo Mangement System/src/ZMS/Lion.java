package ZMS;

public class Lion extends Mammal {

	/**
	 * Initializing lion object
	 * 
	 * @param name
	 *            It is the name of the lion
	 * @param age
	 *            It is the age of the lion
	 * @param weight
	 *            It is the weight of lion
	 */
	public Lion(String name, int age, int weight) {
		super(name, age, weight, "Lion");
	}

	@Override
	public String getSound() {
		return new String("Roars");
	}

	@Override
	public String toString() {
		return "Lion [Sound=" + getSound() + ", Id=" + getId()
				+ ", Name=" + getName() + ", Age=" + getAge()
				+ ", Weight=" + getWeight() + ", AnimalCategory="
				+ getAnimalCategory() + ", AnimalType=" + getAnimalType()
				+ "]";
	}

}
