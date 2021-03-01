package question2;

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
	
	//For testing purpose
		public static void main(String[] args) {
			FcfsJobScheduling fcfs = new FcfsJobScheduling();
			while (true) {
				System.out.println("\n        MENU");
				System.out
						.println("*******************************************");
				System.out.println("1. To calculate completion time");
				System.out.println("2. To calculate waiting time");
				System.out.println("3. To calculate turn around time");
				System.out.println("4. To calculate average waiting time");
				System.out.println("5. To calculate maximum waiting time");
				System.out.println("6. To exit");
				System.out.println("Enter Your Choice: ");

				int userOptionChoice = integerInput();
				int arrivalBurstTime[][] = new int[1000][2];
				int arrivalTimeIndex=0, burstTimeIndex=1;
				int numberOfProcess;
				switch (userOptionChoice) {
				case 1:
					System.out.println("Enter total number of processes: ");
					numberOfProcess = integerInput();
					
					System.out.println("Enter Arrival and Burst Time for each process ");
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Enter arrival time for process "+(process+1)+": ");
						arrivalBurstTime[process][arrivalTimeIndex]=integerInput();
						System.out.println("Enter burst time for process "+(process+1)+": ");
						arrivalBurstTime[process][burstTimeIndex] = integerInput();
					}
						
					int completionTime[] = fcfs.calculateCompletionTime(arrivalBurstTime,numberOfProcess) ;
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Completion time for process "+ (process+1) + ": " + completionTime[process]);
					}
					break;

				case 2:
					System.out.println("Enter total number of processes: ");
					numberOfProcess = integerInput();
					
					System.out.println("Enter Arrival and Burst Time for each process ");
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Enter arrival time for process "+(process+1)+": ");
						arrivalBurstTime[process][arrivalTimeIndex]=integerInput();
						System.out.println("Enter burst time for process "+(process+1)+": ");
						arrivalBurstTime[process][burstTimeIndex] = integerInput();
					}
						
					int waitingTime[] = fcfs.calculateWaitingTime(arrivalBurstTime,numberOfProcess) ;
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Waiting time for process "+ (process+1) + ": " + waitingTime[process]);
					}
					break;
					
				case 3:
					System.out.println("Enter total number of processes: ");
					numberOfProcess = integerInput();
					
					System.out.println("Enter Arrival and Burst Time for each process ");
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Enter arrival time for process "+(process+1)+": ");
						arrivalBurstTime[process][arrivalTimeIndex]=integerInput();
						System.out.println("Enter burst time for process "+(process+1)+": ");
						arrivalBurstTime[process][burstTimeIndex] = integerInput();
					}
						
					int turnAroundTime[] = fcfs.calculateTurnAroundTime(arrivalBurstTime,numberOfProcess) ;
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Turn around time for process "+ (process+1) + ": " + turnAroundTime[process]);
					}
					break;
					
				case 4:
					System.out.println("Enter total number of processes: ");
					numberOfProcess = integerInput();
					
					System.out.println("Enter Arrival and Burst Time for each process ");
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Enter arrival time for process "+(process+1)+": ");
						arrivalBurstTime[process][arrivalTimeIndex]=integerInput();
						System.out.println("Enter burst time for process "+(process+1)+": ");
						arrivalBurstTime[process][burstTimeIndex] = integerInput();
					}
					
					double averageWaitingTime = fcfs.calculateAverageWaitingTime(arrivalBurstTime,numberOfProcess);
					System.out.println("Average waiting time: " + averageWaitingTime);
					break;

				case 5:
					System.out.println("Enter total number of processes: ");
					numberOfProcess = integerInput();
					
					System.out.println("Enter Arrival and Burst Time for each process ");
					for(int process=0;process<numberOfProcess;process++){
						System.out.println("Enter arrival time for process "+(process+1)+": ");
						arrivalBurstTime[process][arrivalTimeIndex]=integerInput();
						System.out.println("Enter burst time for process "+(process+1)+": ");
						arrivalBurstTime[process][burstTimeIndex] = integerInput();
					}
					
					int maximumWaitingTime = fcfs.maxWaitingTime(arrivalBurstTime,numberOfProcess) ;
					System.out.println("Maximum waiting time: " + maximumWaitingTime);
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

