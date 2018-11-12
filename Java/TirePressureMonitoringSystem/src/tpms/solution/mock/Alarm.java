package tpms.solution.mock;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;

    public void check() {
        if (pressureIsOutOfBounds(sensor.popNextPressurePsiValue())) {
            alarmOn = true;
        }
    }

    private boolean pressureIsOutOfBounds(double psiPressureValue) {
        return pressureIsTooLow(psiPressureValue)
                || pressureIsTooHigh(psiPressureValue);
    }

    private boolean pressureIsTooHigh(double psiPressureValue) {
        return psiPressureValue > HighPressureThreshold;
    }

    private boolean pressureIsTooLow(double psiPressureValue) {
        return psiPressureValue < LowPressureThreshold;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    public void setSensor(Sensor aSensor) {
        sensor = aSensor;
    }
}
