package tpms.solution.mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class AlarmTest {

	private static final double TOLERANCE = 0.01;
	private static final double HIGH_PRESSURE_THRESHOLD = 21.00;
	private static final double LOW_PRESSURE_THRESHOLD = 17.00;
	private Alarm sut;
	private Sensor sensorMock;

	@Before
	public void setUp() throws Exception {
		sut = new Alarm();
		sensorMock = EasyMock.createMock(Sensor.class);
		sut.setSensor(sensorMock);
	}

	@Test
	public void tirePressureAtTheMinimumWillNotTurnTheAlarmOn() {
		EasyMock.expect(sensorMock.popNextPressurePsiValue()).andReturn(
				LOW_PRESSURE_THRESHOLD);
		EasyMock.replay(sensorMock);

		sut.check();
		assertFalse(sut.isAlarmOn());
		EasyMock.verify(sensorMock);
	}

	@Test
	public void tirePressureBelowTheMinimumWillTurnTheAlarmOn() {
		EasyMock.expect(sensorMock.popNextPressurePsiValue()).andReturn(
				LOW_PRESSURE_THRESHOLD - TOLERANCE);
		EasyMock.replay(sensorMock);

		sut.check();
		assertTrue(sut.isAlarmOn());
		EasyMock.verify(sensorMock);
	}

	@Test
	public void alarmTurnsOnWhenPressureIsAboveMaximum() {
		EasyMock.expect(sensorMock.popNextPressurePsiValue()).andReturn(
				HIGH_PRESSURE_THRESHOLD + TOLERANCE);
		EasyMock.replay(sensorMock);

		sut.check();
		assertTrue(sut.isAlarmOn());
		EasyMock.verify(sensorMock);
	}

	@Test
	public void tirePressureAtTheMaximumWillNotTurnTheAlarmOn() {
		EasyMock.expect(sensorMock.popNextPressurePsiValue()).andReturn(
				HIGH_PRESSURE_THRESHOLD);
		EasyMock.replay(sensorMock);

		sut.check();
		assertFalse(sut.isAlarmOn());
		EasyMock.verify(sensorMock);
	}
}
