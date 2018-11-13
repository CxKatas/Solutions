import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/****************************************************************************
// Copyright (c) 2018, Construx Software, Inc., All Rights Reserved.
//
// This code is the exclusive property of Construx Software, Inc. It may ONLY 
// be used by learners during Construx's workshops or by individuals who are 
// being coached by Construx on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Construx Software, Inc.
// ***************************************************************************/

/**
 * @author melvinperez
 *
 */
class ActEligibilityIndexCalculatorTest {
	private static final int HIGHEST_POSSIBLE_ACT_SCORE = 36;
	private static final int HIGHEST_POSSIBLE_ELIGIBILITY_INDEX_USING_ACT_SCORE = 1160;
	private static final int LOWEST_POSSIBLE_ACT_SCORE = 0;
	private static final int MINIMUM_REQUIRED_ELIGIBILITY_INDEX_USING_ACT_SCORE = 718;
	private static final int SCORE_TOLERANCE = 1;
	private static final int TYPICAL_ACT_SCORE = 21;

	@SuppressWarnings("unused")
	private static Stream<Arguments> testCasesBasedOnACT() {
		return Stream.of(Arguments.of(GPATestValues.HIGHEST_POSSIBLE_GPA, TYPICAL_ACT_SCORE, 1010),
				Arguments.of(GPATestValues.TYPICAL_GPA, HIGHEST_POSSIBLE_ACT_SCORE, 900),
				Arguments.of(GPATestValues.LOWEST_POSSIBLE_GPA, TYPICAL_ACT_SCORE, 210),
				Arguments.of(GPATestValues.TYPICAL_GPA, LOWEST_POSSIBLE_ACT_SCORE, 540),
				Arguments.of(2.54, TYPICAL_ACT_SCORE, MINIMUM_REQUIRED_ELIGIBILITY_INDEX_USING_ACT_SCORE),
				Arguments.of(2.685, 18, MINIMUM_REQUIRED_ELIGIBILITY_INDEX_USING_ACT_SCORE - SCORE_TOLERANCE),
				Arguments.of(GPATestValues.HIGHEST_POSSIBLE_GPA, HIGHEST_POSSIBLE_ACT_SCORE,
						HIGHEST_POSSIBLE_ELIGIBILITY_INDEX_USING_ACT_SCORE));
	}

	private EligibilityIndexCalculator calculator;

	@Test
	void actScoreShouldBeAtLeastTheLowestPossibleScore() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			(new ActEligibilityIndexCalculator()).eligibilityIndex(new GradePointAverage(GPATestValues.TYPICAL_GPA),
					LOWEST_POSSIBLE_ACT_SCORE - SCORE_TOLERANCE);
		});
	}

	@Test
	void actScoreShouldBeAtMostTheHighestPossibleScore() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			(new ActEligibilityIndexCalculator()).eligibilityIndex(new GradePointAverage(GPATestValues.TYPICAL_GPA),
					HIGHEST_POSSIBLE_ACT_SCORE + SCORE_TOLERANCE);
		});
	}

	@ParameterizedTest(name = "The Eligibility Index for a GPA of {0} and ACT Score of {1} is {2}")
	@MethodSource("testCasesBasedOnACT")
	public void determineEligibilityIndexUsingACT(double GPA, int testScore, int expectedEligibilityIndex) {
		calculator = new ActEligibilityIndexCalculator();
		assertEquals(expectedEligibilityIndex, calculator.eligibilityIndex(new GradePointAverage(GPA), testScore));
	}
}
