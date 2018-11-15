public class MedallionQualification {

	public enum Level {
		DIAMOND, PLATINUM, GOLD, SILVER, MEMBER
	}

	private static final int[] minimumQualificationMiles = { 125000, 75000, 50000, 25000, 0 };
	private static final int[] minimumQualificationSegments = { 140, 100, 60, 30, 0 };
	private static final int[] minimumQualificationDollars = { 12500, 7500, 5000, 2500, 0 };

	public static Level getStatus(int miles, int segments, int dollars) {
		Level level = Level.MEMBER;

		for (Level currentLevel : Level.values()) {
			if ((miles >= minimumQualificationMiles[currentLevel.ordinal()]
					|| segments >= minimumQualificationSegments[currentLevel.ordinal()])
					&& (dollars >= minimumQualificationDollars[currentLevel.ordinal()])) {
				level = currentLevel;

				break;
			}
		}
		return level;
	}
}
