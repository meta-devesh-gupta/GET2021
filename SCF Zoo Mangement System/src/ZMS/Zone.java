package ZMS;

import java.util.ArrayList;
import java.util.List;

// Zone would support animals from a single category like mammal, reptile or bird
public class Zone {
	private int zoneId;
	private static int count=0;
	private String zoneAnimalCategory;
	private int zoneCageCapacity = 1;
	boolean hasPark, hasCanteen;
	List<Cage> listOfCages;

	//Initialing zone 
	public Zone(String zoneAnimalCategory,
			boolean hasPark, boolean hasCanteen) {
		this.zoneAnimalCategory = zoneAnimalCategory;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
		count++;
		this.zoneId=count;
		this.listOfCages = new ArrayList<>();
	}

	//return animal category of the zone
	public String getZoneAnimalCategory() {
		return zoneAnimalCategory;
	}

	//set animal category of the zone
	public void setZoneAnimalCategory(String zoneAnimalCategory) {
		this.zoneAnimalCategory = zoneAnimalCategory;
	}

	//return cage capacity of the zone
	public int getZoneCageCapacity() {
		return zoneCageCapacity;
	}

	//set cage capacity for the zone
	public void setZoneCageCapacity(int zoneCageCapacity) {
		this.zoneCageCapacity = zoneCageCapacity;
	}

	//return id of the zone
	public int getZoneId() {
		return zoneId;
	}

	//return true if zone has capacity else return false
	public boolean zoneHasCapacity() {
		if (listOfCages.size() < zoneCageCapacity)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", zoneAnimalCategory="
				+ zoneAnimalCategory + ", zoneCageCapacity=" + zoneCageCapacity
				+ ", hasPark=" + hasPark + ", hasCanteen=" + hasCanteen + "]";
	}
	
}
