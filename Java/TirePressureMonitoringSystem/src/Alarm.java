public class Alarm {
	/**
	 * @param sensor
	 */
	public Alarm(TirePressureSensor sensor) {
		super();
		this.sensor = sensor;
	}

	private static final double LOW_PRESSURE_THRESHOLD = 17;
	private static final double HIGH_PRESSURE_THRESHOLD = 21;

	TirePressureSensor sensor = new Sensor();

	boolean alarmOn = false;

	public void check() {
		double psiPressureValue = sensor.popNextPressurePsiValue();

		if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
			alarmOn = true;
		}
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}
