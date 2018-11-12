package tpms.cleanup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tpms.cleanup.Alarm;

public class AlarmTest {

	private static final int HIGH_PRESSURE_THRESHOLD = 21;
	private static final int LOW_PRESSURE_THRESHOLD = 17;
	private static final double TOLERANCE = 0.01;
	private SensorStub sensorStub;
	private Alarm sut;

	@Before
	public void setup() {
		sensorStub = new SensorStub();
		sut = new Alarm(sensorStub);
	}

	@Test
	public void tirePressureBelowMinimumWillTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiValue(LOW_PRESSURE_THRESHOLD - TOLERANCE);
		sut.check();
		assertTrue(sut.isAlarmOn());
	}

	@Test
	public void tirePressureAtTheMinimumWillNotTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiValue(LOW_PRESSURE_THRESHOLD);
		sut.check();
		assertFalse(sut.isAlarmOn());
	}

	@Test
	public void tirePressureAboveTheMaximumWillTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiValue(HIGH_PRESSURE_THRESHOLD + TOLERANCE);
		sut.check();
		assertTrue(sut.isAlarmOn());
	}

	@Test
	public void tirePressureAtTheMaximumWillNotTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiValue(HIGH_PRESSURE_THRESHOLD);
		sut.check();
		assertFalse(sut.isAlarmOn());
	}
}
