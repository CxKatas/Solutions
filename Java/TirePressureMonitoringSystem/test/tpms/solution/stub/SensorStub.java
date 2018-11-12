package tpms.solution.stub;

import tpms.solution.stub.ISensor;

public class SensorStub implements ISensor {
	private double nextPsiValue = 0;

	public void setNexPressurePsiVale(double psi_value) {
		this.nextPsiValue = psi_value;
	}

	@Override
	public double popNextPressurePsiValue() {
		return nextPsiValue;
	}

}
