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
public class SensorStub implements TirePressureSensor {

	private double nextPsiValue;

	/* (non-Javadoc)
	 * @see TirePressureSensor#popNextPressurePsiValue()
	 */
	@Override
	public double popNextPressurePsiValue() {
		return nextPsiValue;
	}

	public void pushNextPressurePsiValue(double psiValue) {
		nextPsiValue = psiValue;
	}
}
