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
package enummap;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import enummap.MedallionQualification;
import enummap.MedallionQualification.Level;

/**
 * @author melvinperez
 *
 */
@RunWith(Parameterized.class)
public class MedallionQualificationTest {
	private int miles;
	private int segments;
	private int dollars;
	private Level expectedLevel;

	public MedallionQualificationTest(int miles, int segments, int dollars,
			MedallionQualification.Level expectedLevel) {
		this.miles = miles;
		this.segments = segments;
		this.dollars = dollars;
		this.expectedLevel = expectedLevel;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 25000, 25, 3000, MedallionQualification.Level.SILVER },
				{ 100000, 141, 12500, MedallionQualification.Level.DIAMOND },
				{ 24999, 20, 1000, MedallionQualification.Level.MEMBER },
				{ 24999, 29, 2500, MedallionQualification.Level.MEMBER },
				{ 24999, 30, 2500, MedallionQualification.Level.SILVER },
				{ 25000, 30, 2499, MedallionQualification.Level.MEMBER },
				{ 125000, 100, 2500, MedallionQualification.Level.SILVER } });
	}

	@Test
	public void getQualificationStatus() {
		assertEquals(expectedLevel, MedallionQualification.getStatus(miles, segments, dollars));
	}

}
