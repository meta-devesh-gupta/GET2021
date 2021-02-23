package question2;

import java.util.Arrays;
import java.util.Comparator;

public class FcfsJobScheduling {
	/**
	 * Sorting 2D array on basis of arrival time
	 * @param atbt 2D array having arrival time at 0 index and burst time at index 1.
	 */
	public static void sort(int atbt[][]) {
		Comparator<int[]> co = new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {

				return a[0] - b[0];
			}
		};
		Arrays.sort(atbt, co);
	}
	/**
	 * Calculating the completion time
	 * @param atbt 2D array having arrival time at 0 index and burst time at index 1.
	 * @return the completion time array for each i process
	 */
	public static int[] calculateCompletionTime(int atbt[][]) {
		int ct[] = new int[atbt.length];
		ct[0] = atbt[0][0] + atbt[0][1];
		for (int i = 1; i < ct.length; i++) {
			int currentAT = atbt[i][0];
			int currentBT = atbt[i][1];
			if (currentAT > ct[i - 1])
				ct[i] = currentAT + currentBT;
			else
				ct[i] = ct[i - 1] + currentBT;
		}
		return ct;
	}
	/**
	 * Calculating Turn around time
	 * @param atbt 2D array having arrival time at 0 index and burst time at index 1.
	 * @return the turn around time array for each i process
	 */
	public static int[] calculateTurnAroundTime(int atbt[][]) {
		int ct[] = calculateCompletionTime(atbt);
		int tat[] = new int[atbt.length];
		for (int i = 0; i < tat.length; i++) {
			tat[i] = ct[i] - atbt[i][0];
		}
		return tat;
	}
	/**
	 * Calculating waiting time
	 * @param atbt 2D array having arrival time at 0 index and burst time at index 1.
	 * @return the waiting time array for each i process
	 */
	public static int[] calculateWaitingTime(int atbt[][]) {
		int tat[] = calculateTurnAroundTime(atbt);
		int wt[] = new int[atbt.length];
		for (int i = 0; i < wt.length; i++)
			wt[i] = tat[i] - atbt[i][1];
		return wt;
	}
	/**
	 * Calculating average waiting time
	 * @param atbt 2D array having arrival time at 0 index and burst time at index 1.
	 * @return average waiting time
	 */
	public static double calculateAverageWaitingTime(int atbt[][]) {
		int wt[] = calculateWaitingTime(atbt);
		int total = 0;
		for (int i : wt)
			total += i;
		return (double) total / wt.length;
	}
	/**
	 * Calculating maximum waiting time
	 * @param atbt 2D array having arrival time at 0 index and burst time at index 1.
	 * @return maximum waiting time
	 */
	public static int maxWaitingTime(int atbt[][]) {
		int wt[] = calculateWaitingTime(atbt);
		int max = Integer.MIN_VALUE;
		for (int i : wt)
			max = Math.max(max, i);
		return max;
	}
	
	
	//For testing 
	public static void main(String[] args) {
		int atbt[][] = { { 0, 10 }, { 60, 10 }, { 6, 20 }, { 110, 5 } };
		sort(atbt);
		int ct[] = calculateCompletionTime(atbt);
		System.out.println("Completion Time: ");
		for (int i : ct)
			System.out.println(i);

		int tat[] = calculateTurnAroundTime(atbt);
		System.out.println("Turn Around Time: ");
		for (int i : tat)
			System.out.println(i);
		
		System.out.println("Waiting Time: ");
		int wt[] = calculateWaitingTime(atbt);
		
		for(int i: wt)
			System.out.println(i);
		System.out.println("Average Waiting Time: " + calculateAverageWaitingTime(atbt));
		System.out.println("Maximum waiting time: " + maxWaitingTime(atbt));
	}
}
