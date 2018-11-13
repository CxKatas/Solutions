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
public final class GPATestValues {

	static final double HIGHEST_POSSIBLE_GPA = 4.0;
	static final double LOWEST_POSSIBLE_GPA = 0.0;
	static final double TYPICAL_GPA = 2.7;
	static final double GPA_TOLERANCE = 0.1;
	static final double JUST_ABOVE_HIGHEST_POSSIBLE_GPA = GPATestValues.HIGHEST_POSSIBLE_GPA + 0.1;
	static final double JUST_BELOW_LOWEST_POSSIBLE_GPA = GPATestValues.LOWEST_POSSIBLE_GPA - 0.1;

	private GPATestValues() {
	}
}
