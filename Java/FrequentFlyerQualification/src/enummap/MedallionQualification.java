package enummap;

import java.util.EnumMap;
import java.util.Map;

public class MedallionQualification {
	public enum Level {
		DIAMOND, PLATINUM, GOLD, SILVER, MEMBER
	}

	private static final Map<Level, int[]> MINIMUM_QUALIFICATION = new EnumMap<>(Level.class);
	static {
		MINIMUM_QUALIFICATION.put(Level.DIAMOND, new int[] { 125000, 140, 12500 });
		MINIMUM_QUALIFICATION.put(Level.PLATINUM, new int[] { 75000, 100, 7500 });
		MINIMUM_QUALIFICATION.put(Level.GOLD, new int[] { 50000, 60, 5000 });
		MINIMUM_QUALIFICATION.put(Level.SILVER, new int[] { 25000, 30, 2500 });
		MINIMUM_QUALIFICATION.put(Level.MEMBER, new int[] { 0, 0, 0 });
	}

	public static Level getStatus(int miles, int segments, int dollars) {
		Level level = Level.MEMBER;
		final int MILES = 0;
		final int SEGMENTS = 1;
		final int DOLLARS = 2;

		for (Level currentLevel : Level.values()) {
			if ((miles >= MINIMUM_QUALIFICATION.get(currentLevel)[MILES]
					|| segments >= MINIMUM_QUALIFICATION.get(currentLevel)[SEGMENTS])
					&& (dollars >= MINIMUM_QUALIFICATION.get(currentLevel)[DOLLARS])) {
				level = currentLevel;
				break;
			}
		}

		return level;
	}
}
