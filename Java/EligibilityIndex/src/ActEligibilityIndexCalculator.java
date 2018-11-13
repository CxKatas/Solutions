
public class ActEligibilityIndexCalculator implements EligibilityIndexCalculator {

	private static final int LOWEST_POSSIBLE_ACT_SCORE = 0;
	private static final int HIGHEST_POSSIBLE_ACT_SCORE = 36;

	@Override
	public int eligibilityIndex(GradePointAverage gpa, int testScore) {
		if (isScoreOutOfRange(testScore))
			throw new IllegalArgumentException();
		
		return (int) Math.round(gpa.getValue() * 200 + 10 * testScore);
	}

	@Override
	public boolean isScoreOutOfRange(int testScore) {
		return (LOWEST_POSSIBLE_ACT_SCORE > testScore || testScore > HIGHEST_POSSIBLE_ACT_SCORE);
	}
}
