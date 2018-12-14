import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
public class AlarmTest {

	private static final double HIGH_PRESSURE_THRESHOLD = 21;
	private static final int LOW_PRESSURE_THRESHOLD = 17;
	private static final double TOLERANCE = 0.5;

	@Test
	public void tirePressureAboveTheMaximumWillTurnTheAlarmOn() {
		Alarm alarm = new Alarm(new SensorStub(HIGH_PRESSURE_THRESHOLD + TOLERANCE));
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void tirePressureAtTheMaximumWillNotTurnTheAlarmOn() {
		Alarm alarm = new Alarm(new SensorStub(HIGH_PRESSURE_THRESHOLD));
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void tirePressureAtTheMinimumWillNotTurnTheAlarmOn() {
		Alarm alarm = new Alarm(new SensorStub(LOW_PRESSURE_THRESHOLD));
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void tirePressureBelowMinimumWillTurnTheAlarmOn() {
		Alarm alarm = new Alarm(new SensorStub(LOW_PRESSURE_THRESHOLD - TOLERANCE));
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
}