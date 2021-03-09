package College;

//Program class containing the capacity of the 
public class Program {
	String programName;
	int capacity;

	//Initializing the object of program class
	public Program(String programName, int capacity) {
		this.programName = programName;
		this.capacity = capacity;
	}

	//this method set the capacity of the program
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	//this method return the name of the program
	public String getProgramName() {
		return programName;
	}

	//this method return capacity of the program
	public int getCapacity() {
		return capacity;
	}

	//this method will check whether program has capacity or not
	public boolean hasCapacity(){
		if(getCapacity()>0)
			return true;
		return false;
	}
}
