import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

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
class AlarmTestParameterized {

	private static final double HIGH_PRESSURE_THRESHOLD = 21;
	private static final double TOLERANCE = 0.5;
	private static final double LOW_PRESSURE_THRESHOLD = 17;

	@ParameterizedTest(name = "When the tire pressure is at {0}, the alarm should be {1}")
	@MethodSource("boundaryTirePressureValues")
	void testAlarmWithBoundaryPressureValues(double psiPressureValue, boolean expectAlarmStatus) {
		Alarm alarm = new Alarm(new SensorStub(psiPressureValue));
		alarm.check();
		assertEquals(expectAlarmStatus, alarm.isAlarmOn());
	}

	static Stream<Arguments> boundaryTirePressureValues() {
		return Stream.of(Arguments.of(HIGH_PRESSURE_THRESHOLD, false),
				Arguments.of(HIGH_PRESSURE_THRESHOLD + TOLERANCE, true), Arguments.of(LOW_PRESSURE_THRESHOLD, false),
				Arguments.of(LOW_PRESSURE_THRESHOLD - TOLERANCE, true));
	}
}
