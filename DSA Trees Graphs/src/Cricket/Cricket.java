package Cricket;

public class Cricket {
	MyPriorityQueue myPriorityQueue;
	int totalNumberOfBalls;

	public Cricket(int numberOfBowlers, int totalNumberOfBalls) {
		this.myPriorityQueue = new MyPriorityQueue(numberOfBowlers);
		this.totalNumberOfBalls = totalNumberOfBalls;
		if (totalNumberOfBalls < 0)
			throw new AssertionError("Invalid total number of balls");
	}

	/**
	 * This method will get the bowling order so that we Virat can score minimum
	 * runs
	 */
	public String getBowlingOrder() {
		String bowlingOrder = "";
		while (this.totalNumberOfBalls != 0 && !myPriorityQueue.isEmpty()) {
			Bowler currentBowler = myPriorityQueue.remove();
			int bowlerQuota = currentBowler.getBowlerQuota();
			if (bowlerQuota != 0) {
				currentBowler.setBowlerQuota(bowlerQuota - 1);
				bowlingOrder += currentBowler.toString() + "\n";
				myPriorityQueue.add(currentBowler);
				totalNumberOfBalls--;
			}
		}
		return bowlingOrder;
	}

	/**
	 * @return the myPriorityQueue
	 */
	public MyPriorityQueue getMyPriorityQueue() {
		return myPriorityQueue;
	}

	public static void main(String[] args) {
		try {
			Cricket cricket = new Cricket(3, 20);
			cricket.getMyPriorityQueue().add(new Bowler("Bowler 1", 5));
			cricket.getMyPriorityQueue().add(new Bowler("Bowler 2", 7));
			cricket.getMyPriorityQueue().add(new Bowler("Bowler 3", 6));
			System.out.println(cricket.getBowlingOrder());
		} catch (AssertionError assertionError) {
			System.out.println(assertionError.getMessage());
		}
	}

}
