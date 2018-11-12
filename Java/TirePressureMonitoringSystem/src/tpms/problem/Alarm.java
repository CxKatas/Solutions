package tpms.problem;

public class Alarm {
    private double lowPressureThreshold = 29;
    private double highPressureThreshold = 38;

    Sensor sensor = new Sensor();

    boolean isOn = false;

    public final void check() {
        double tirePressure = sensor.getValue();

        isOn = (tirePressure < lowPressureThreshold || highPressureThreshold < tirePressure);
    }

    public final boolean isOn() {
        return isOn;
    }
}
