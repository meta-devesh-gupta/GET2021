package Cricket;

//Bowler class containing the name and balls to bowl
class Bowler {
	String bowlerName;
	int bowlerQuota;

	public Bowler(String bowlerName, int bowlerQuota) {
		this.bowlerName = bowlerName;
		this.bowlerQuota = bowlerQuota;
		if(bowlerQuota < 0)
			throw new AssertionError("Invalid balls");
	}

	/**
	 * @return the bowlerQuota
	 */
	public int getBowlerQuota() {
		return bowlerQuota;
	}

	/**
	 * @param bowlerQuota
	 *            the bowlerQuota to set
	 */
	public void setBowlerQuota(int bowlerQuota) {
		this.bowlerQuota = bowlerQuota;
	}

	@Override
	public String toString() {
		return "BowlerName=" + bowlerName + ", Balls Left=" + bowlerQuota;
	}

}
