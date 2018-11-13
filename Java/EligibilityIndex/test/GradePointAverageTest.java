import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
class GradePointAverageTest {

	@Test
	void gpaShouldBeAtLeastTheLowestPossibleValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			new GradePointAverage(GPATestValues.JUST_BELOW_LOWEST_POSSIBLE_GPA);
		});
	}

	@Test
	void gpaShouldBeAtMostTheHighestPossibleValue() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			new GradePointAverage(GPATestValues.JUST_ABOVE_HIGHEST_POSSIBLE_GPA);
		});
	}

	@Test
	void returnTheGPAValue() throws Exception {
		assertEquals(GPATestValues.TYPICAL_GPA, new GradePointAverage(GPATestValues.TYPICAL_GPA).getValue());
	}
}
