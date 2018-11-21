public enum Status {

	DIAMOND(125000, 140, 12500), PLATINUM(7500, 100, 7500), GOLD(50000, 60, 5000), SILVER(25000, 30, 2500),
	MEMBER(0, 0, 0);

	private int minimumQualifiedMiles;
	private int minimumQualifiedSegments;
	private int minimumQualifiedDollars;

	/**
	 * @param minimumQualifiedMiles    Minimum qualified miles the frequent flyer
	 *                                 must fly to be eligible this status
	 * @param minimumQualifiedSegments Minimum qualified segments the frequent flyer
	 *                                 must fly to be eligible for this status
	 * @param minimumQualifiedDollars  Minimum amount the frequent flyer must spent
	 *                                 on flight activities to be eligible for this
	 *                                 status
	 */
	private Status(int minimumQualifiedMiles, int minimumQualifiedSegments, int minimumQualifiedDollars) {
		this.minimumQualifiedMiles = minimumQualifiedMiles;
		this.minimumQualifiedSegments = minimumQualifiedSegments;
		this.minimumQualifiedDollars = minimumQualifiedDollars;
	}

	/**
	 * @param milesFlown    Number of miles the frequent flyer has flown thru the
	 *                      year
	 * @param segmentsFlown Number of segments the frequent flyer has flow thru the
	 *                      year
	 * @param dollarsSpent  Amount the frequent flyer has spent on qualified
	 *                      expenses thru the year
	 * @return status 		Corresponding qualification status to be reached
	 */
	public static Status get(int milesFlown, int segmentsFlown, int dollarsSpent) {
		for (Status status : Status.values()) {
			if ((milesFlown >= status.minimumQualifiedMiles || segmentsFlown >= status.minimumQualifiedSegments)
					&& (dollarsSpent >= status.minimumQualifiedDollars)) {
				return status;
			}
		}
		return MEMBER;
	}
}
