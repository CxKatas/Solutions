import java.util.Random;

public class Sensor implements TirePressureSensor {
	public static final double OFFSET = 16;

	/* (non-Javadoc)
	 * @see TirePressureSensor#popNextPressurePsiValue()
	 */
	@Override
	public double popNextPressurePsiValue() {
		double pressureTelemetryValue;
		pressureTelemetryValue = samplePressure();

		return OFFSET + pressureTelemetryValue;
	}

	private static double samplePressure() {
		// placeholder implementation that simulate a real sensor in a real tire
		Random basicRandomNumbersGenerator = new Random(42);
		return 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
	}
}
