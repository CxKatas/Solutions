import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SatEligibilityIndexCalculatorTest {

	private static final int MINIMUM_REQUIRED_ELIGIBILITY_INDEX_USING_SAT = 3000;
	private static final int HIGHEST_POSSIBLE_ELIGIBILITY_INDEX_USING_SAT = 4800;
	private static final int LOWEST_POSSIBLE_SAT_SCORE = 0;
	private static final int TYPICAL_SAT_SCORE = 1050;
	private static final int HIGHEST_POSSIBLE_SAT_SCORE = 1600;
	private static final int SCORE_TOLERANCE = 1;
	private EligibilityIndexCalculator calculator;

	@Test
	void gpaShouldBeAtLeastTheLowestPossible() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			(new SatEligibilityIndexCalculator()).eligibilityIndex(new GradePointAverage(GPATestValues.JUST_BELOW_LOWEST_POSSIBLE_GPA),
					TYPICAL_SAT_SCORE);
		});
	}

	@Test
	void gpaShouldBeAtMostTheHighestPossible() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			(new SatEligibilityIndexCalculator())
					.eligibilityIndex(new GradePointAverage(GPATestValues.JUST_ABOVE_HIGHEST_POSSIBLE_GPA), TYPICAL_SAT_SCORE);
		});
	}

	@Test
	void satScoreShouldBeAtLeastTheLowestPossibleScore() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			(new SatEligibilityIndexCalculator()).eligibilityIndex(new GradePointAverage(GPATestValues.TYPICAL_GPA),
					LOWEST_POSSIBLE_SAT_SCORE - SCORE_TOLERANCE);
		});
	}

	@Test
	void satScoreShouldBeAtMostTheHighestPossibleScore() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			(new SatEligibilityIndexCalculator()).eligibilityIndex(new GradePointAverage(GPATestValues.TYPICAL_GPA),
					HIGHEST_POSSIBLE_SAT_SCORE + SCORE_TOLERANCE);
		});
	}

	@ParameterizedTest(name = "The Eligibility Index for a GPA of {0} and SAT Score of {1} is {2}")
	@MethodSource("testCasesBasedOnSAT")
	public void determineEligibilityIndexUsingSAT(double GPA, int testScore, int expectedEligibilityIndex) {
		calculator = new SatEligibilityIndexCalculator();
		assertEquals(expectedEligibilityIndex, calculator.eligibilityIndex(new GradePointAverage(GPA), testScore));
	}

	@SuppressWarnings("unused")
	private static Stream<Arguments> testCasesBasedOnSAT() {
		return Stream.of(Arguments.of(GPATestValues.LOWEST_POSSIBLE_GPA, TYPICAL_SAT_SCORE, 1050),
				Arguments.of(GPATestValues.HIGHEST_POSSIBLE_GPA, TYPICAL_SAT_SCORE, 4250),
				Arguments.of(GPATestValues.TYPICAL_GPA, LOWEST_POSSIBLE_SAT_SCORE, 2160),
				Arguments.of(GPATestValues.TYPICAL_GPA, HIGHEST_POSSIBLE_SAT_SCORE, 3760),
				Arguments.of(GPATestValues.TYPICAL_GPA, 839, MINIMUM_REQUIRED_ELIGIBILITY_INDEX_USING_SAT - SCORE_TOLERANCE),
				Arguments.of(GPATestValues.TYPICAL_GPA, 840, MINIMUM_REQUIRED_ELIGIBILITY_INDEX_USING_SAT),
				Arguments.of(GPATestValues.HIGHEST_POSSIBLE_GPA, HIGHEST_POSSIBLE_SAT_SCORE,
						HIGHEST_POSSIBLE_ELIGIBILITY_INDEX_USING_SAT));
	}
}
