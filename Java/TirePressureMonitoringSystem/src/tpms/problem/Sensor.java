package tpms.problem;

import java.util.Random;

public class Sensor {

    public double getValue() {
        return samplePressure();
    }

    // Placeholder implementation simulating info read from real sensor in a
    // real tire
    private static double samplePressure() {
        final double OFFSET = 28;
        final double DELTA = 11 * new Random().nextDouble()
                * new Random().nextDouble();
        return OFFSET + DELTA;
    }
}
