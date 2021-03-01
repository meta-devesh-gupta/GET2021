package question1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	/**
	 * For reading integer input from the user
	 * @return integer read from the user
	 */
	public static int integerInput() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int integer = 0;

		while (true) {
			try {
				integer = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return integer;
	}
	
	/**
	 * Reading the set in input from user
	 * @return the set that is read fromt the user
	 */
	public static int[] inputSet(){
		System.out.println("Enter size of the set: ");
		int length=integerInput();
		int set[] = new int[length];
		System.out.println("Enter values of set: ");
		for(int index=0;index<length;index++){
			set[index] = integerInput();
		}
		return set;
	}
	
	//For testing purpose
		public static void main(String[] args) {
			while (true) {
				System.out.println("\n        MENU");
				System.out
						.println("*******************************************");
				System.out.println("1. To return the size of set");
				System.out.println("2. To check whether x is a member of the set ");
				System.out.println("3. To check whether s is a subset");
				System.out.println("4. To get the complement set");
				System.out.println("5. For union of two sets");
				System.out.println("6. To exit");
				System.out.println("Enter Your Choice: ");

				int userOptionChoice = integerInput();
				int set[];
				IntSet intSet;
				switch (userOptionChoice) {
				case 1:
					set = inputSet();
					intSet = new IntSet(set, set.length);
					System.out.println("Size of the set: " + intSet.size());
					break;
					
				case 2:
					set = inputSet();
					intSet = new IntSet(set, set.length);
					System.out.println("Enter the value to search for: ");
					int value = integerInput();
					if(intSet.isMember(value))
						System.out.println(value+" is a member of the set");
					else
						System.out.println(value+" is not a member of the set");
					break;
					
				case 3:
					set = inputSet();
					intSet = new IntSet(set, set.length);
					System.out.println("Enter length of subset: ");
					int lengthOfSubset = integerInput();
					int subsetArray[] = new int[lengthOfSubset];
					System.out.println("Enter values of subset: ");
					for(int index=0;index<lengthOfSubset;index++)
						subsetArray[index]=integerInput();
					IntSet subset = new IntSet(subsetArray, lengthOfSubset);
					if(intSet.isSubSet(subset))
						System.out.println("The entered set is a subset");
					else
						System.out.println("The entered set is not a subset");
					break;

				case 4:
					set = inputSet();
					intSet = new IntSet(set, set.length);
					System.out.println("Compliment of the set: ");
					IntSet complimentSet = intSet.getComplement();
					System.out.println(complimentSet);
					break;

				case 5:
					System.out.println("For first set: ");
					set = inputSet();
					intSet = new IntSet(set, set.length);
					System.out.println("For second set: ");
					System.out.println("Enter the length of second set: ");
					int lengthOfSecondSet = integerInput();
					int secondSetArray[] = new int[lengthOfSecondSet];
					System.out.println("Enter values of second set: ");
					for(int index=0;index<lengthOfSecondSet;index++)
						secondSetArray[index]=integerInput();
					IntSet secondSet = new IntSet(secondSetArray, lengthOfSecondSet);
					IntSet unionSet = intSet.union(secondSet);
					System.out.println(unionSet);
					break;


				case 6:
					System.exit(0);

				default:
					System.out.println("Illegal Input");
					break;
				}
			}

		}
}


