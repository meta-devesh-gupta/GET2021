package question2;

import java.util.Arrays;
import java.util.Comparator;

public class FcfsJobScheduling {

	public static void sort(int atbt[][]) {
		Comparator<int[]> co = new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {

				return a[0] - b[0];
			}
		};
		Arrays.sort(atbt, co);
	}

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

	public static int[] calculateTurnAroundTime(int atbt[][]) {
		int ct[] = calculateCompletionTime(atbt);
		int tat[] = new int[atbt.length];
		for (int i = 0; i < tat.length; i++) {
			tat[i] = ct[i] - atbt[i][0];
		}
		return tat;
	}

	public static int[] calculateWaitingTime(int atbt[][]) {
		int tat[] = calculateTurnAroundTime(atbt);
		int wt[] = new int[atbt.length];
		for (int i = 0; i < wt.length; i++)
			wt[i] = tat[i] - atbt[i][1];
		return wt;
	}

	public static double calculateAverageWaitingTime(int atbt[][]) {
		int wt[] = calculateWaitingTime(atbt);
		int total = 0;
		for (int i : wt)
			total += i;
		return (double) total / wt.length;
	}

	public static int maxWaitingTime(int atbt[][]) {
		int wt[] = calculateWaitingTime(atbt);
		int max = Integer.MIN_VALUE;
		for (int i : wt)
			max = Math.max(max, i);
		return max;
	}

	public static void main(String[] args) {
		int atbt[][] = { { 0, 10 }, { 60, 10 }, { 6, 20 }, { 110, 5 } };
		sort(atbt);
		int ct[] = calculateCompletionTime(atbt);
		System.out.println("Completion Time: ");
		for (int i : ct)
			System.out.println(i + " ");

		int tat[] = calculateTurnAroundTime(atbt);
		System.out.println("Turn Around Time: ");
		for (int i : tat)
			System.out.println(i + " ");

		System.out.println("Maximum waiting time: " + maxWaitingTime(atbt));
	}
}
