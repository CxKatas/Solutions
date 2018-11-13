// ***************************************************************************
// Copyright (c) 2016, Construx Software, Inc., All Rights Reserved.
//
// This code is the exclusive property of Construx Software, Inc. 
// It may ONLY be used by learners during Construx's workshops or 
// by individuals who are being coached by Construx on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Construx Software, Inc.
// ****************************************************************************

public class SatEligibilityIndexCalculator implements EligibilityIndexCalculator {

	private static final int LOWEST_POSSIBLE_SCORE = 0;
	private static final int HIGHEST_POSSIBLE_SCORE = 1600;

	public int eligibilityIndex(GradePointAverage gpa, int testScore) {
		if (isScoreOutOfRange(testScore))
			throw new IllegalArgumentException();
		
		return (int) Math.round(gpa.getValue() * 800 + testScore);
	}

	/**
	 * @param testScore
	 * @return
	 */
	@Override
	public boolean isScoreOutOfRange(int testScore) {
		return (LOWEST_POSSIBLE_SCORE > testScore || testScore > HIGHEST_POSSIBLE_SCORE);
	}
}

