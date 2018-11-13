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
public final class GradePointAverage {

	private static final double HIGHEST_POSSIBLE_GPA = 4.0;
	private static final double LOWEST_POSSIBLE_GPA = 0.0;
	private final double value;

	public GradePointAverage(double value) {
		if (LOWEST_POSSIBLE_GPA > value || value > HIGHEST_POSSIBLE_GPA)
			throw new IllegalArgumentException();
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
}
