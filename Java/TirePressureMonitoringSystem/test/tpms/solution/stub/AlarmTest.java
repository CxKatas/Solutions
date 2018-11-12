package tpms.solution.stub;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tpms.solution.stub.Alarm;

public class AlarmTest {

	private static final double TOLERANCE = 0.01;
	private static final int LOW_PRESSURE_THRESHOLD = 17;
	private SensorStub sensorStub;
	private Alarm sut;

	@Before
	public void setup() {
		sensorStub = new SensorStub();
		sut = new Alarm(sensorStub);
	}

	@Test
	public void tirePressureBelowMinimumWillTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiVale(LOW_PRESSURE_THRESHOLD - TOLERANCE);
		sut.check();
		assertTrue(sut.isAlarmOn());
	}

	@Test
	public void tirePressureAtTheMinimumWillNotTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiVale(LOW_PRESSURE_THRESHOLD);
		sut.check();
		assertFalse(sut.isAlarmOn());
	}

	@Test
	public void tirePressureAboveTheMaximumWillTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiVale(21.01);
		sut.check();
		assertTrue(sut.isAlarmOn());
	}

	@Test
	public void tirePressureAtTheMaximumWillNotTurnTheAlarmOn() {
		sensorStub.setNexPressurePsiVale(21);
		sut.check();
		assertFalse(sut.isAlarmOn());
	}
}
