package tpms.cleanup;

import tpms.cleanup.ISensor;

public class SensorStub implements ISensor {
	private double nextPsiValue = 0;

	public void setNexPressurePsiValue(double psi_value) {
		this.nextPsiValue = psi_value;
	}

	@Override
	public double popNextPressurePsiValue() {
		return nextPsiValue;
	}

}
