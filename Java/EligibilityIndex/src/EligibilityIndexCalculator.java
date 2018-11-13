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

public interface EligibilityIndexCalculator {
	abstract int eligibilityIndex(GradePointAverage gpa, int testScore);

	boolean isScoreOutOfRange(int testScore);
}