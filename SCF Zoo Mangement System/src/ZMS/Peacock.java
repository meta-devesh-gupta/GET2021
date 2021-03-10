package ZMS;

//Peacock is subclass of Bird type
public class Peacock extends Bird {

	/**
	 * Initializing peacock object
	 * 
	 * @param name
	 *            It is the name of the peacock
	 * @param age
	 *            It is the age of the peacock
	 * @param weight
	 *            It is the weight of peacock
	 */
	public Peacock(String name, int age, int weight) {
		super(name, age, weight, "Peacock");
	}

	@Override
	public String getSound() {
		return new String("Squawk");
	}

	@Override
	public String toString() {
		return "Peacock [Sound=" + getSound() + ", Id=" + getId() + ", Name="
				+ getName() + ", Age=" + getAge() + ", Weight=" + getWeight()
				+ ", AnimalCategory=" + getAnimalCategory() + ", AnimalType="
				+ getAnimalType() + "]";
	}

}
