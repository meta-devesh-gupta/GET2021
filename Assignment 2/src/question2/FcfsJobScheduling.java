package question2;

//FCFS Job Scheduling algorithm, assuming arrivalBurstTime array containing processes 
//in sorted order of their arrival time 
public class FcfsJobScheduling {
	private int arrivalTimeIndex = 0;
	private int burstTimeIndex = 1;
	
	/**
	 * Calculating the completion time
	 * @param arrivalBurstTime 2D array 
	 * @return the completion time array for each i process
	 */
	public int[] calculateCompletionTime(int arrivalBurstTime[][], int numberOfProcess) {
		int completionTime[] = new int[numberOfProcess];
		
		//Calculating completion time for first process
		completionTime[0] = arrivalBurstTime[0][arrivalTimeIndex] + arrivalBurstTime[0][burstTimeIndex];
		
		for (int index = 1; index < completionTime.length; index++) {
			int currentArrivalTime = arrivalBurstTime[index][arrivalTimeIndex];
			int currentBurstTime = arrivalBurstTime[index][burstTimeIndex];
			if (currentArrivalTime > completionTime[index - 1])
				completionTime[index] = currentArrivalTime + currentBurstTime;
			else
				completionTime[index] = completionTime[index - 1] + currentBurstTime;
		}
		return completionTime;
	}
	/**
	 * Calculating Turn around time
	 * @param arrivalBurstTime 2D array 
	 * @return the turn around time array for each i process
	 */
	public int[] calculateTurnAroundTime(int arrivalBurstTime[][], int numberOfProcess) {
		int completionTime[] = calculateCompletionTime(arrivalBurstTime, numberOfProcess);
		int turnAroundTime[] = new int[numberOfProcess];
		for (int index = 0; index < turnAroundTime.length; index++) {
			turnAroundTime[index] = completionTime[index] - arrivalBurstTime[index][arrivalTimeIndex];
		}
		return turnAroundTime;
	}
	/**
	 * Calculating waiting time
	 * @param arrivalBurstTime 2D array 
	 * @return the waiting time array for each i process
	 */
	public int[] calculateWaitingTime(int arrivalBurstTime[][], int numberOfProcess) {
		int turnAroundTime[] = calculateTurnAroundTime(arrivalBurstTime, numberOfProcess);
		int waitingTime[] = new int[numberOfProcess];
		for (int index = 0; index < waitingTime.length; index++)
			waitingTime[index] = turnAroundTime[index] - arrivalBurstTime[index][burstTimeIndex];
		return waitingTime;
	}
	/**
	 * Calculating average waiting time
	 * @param arrivalBurstTime 2D array 
	 * @return average waiting time
	 */
	public double calculateAverageWaitingTime(int arrivalBurstTime[][], int numberOfProcess) {
		int waitingTime[] = calculateWaitingTime(arrivalBurstTime, numberOfProcess);
		int totalWaitingTime = 0;
		for (int currentWaitingTime : waitingTime)
			totalWaitingTime += currentWaitingTime;
		return (double) totalWaitingTime / waitingTime.length;
	}
	/**
	 * Calculating maximum waiting time
	 * @param arrivalBurstTime 2D array 
	 * @return maximum waiting time
	 */
	public int maxWaitingTime(int arrivalBurstTime[][], int numberOfProcess) {
		int waitingTime[] = calculateWaitingTime(arrivalBurstTime, numberOfProcess);
		int maximumWaitingTime = Integer.MIN_VALUE;
		for (int currentWaitingTime : waitingTime)
			maximumWaitingTime = Math.max(maximumWaitingTime, currentWaitingTime);
		return maximumWaitingTime;
	}
	
}
