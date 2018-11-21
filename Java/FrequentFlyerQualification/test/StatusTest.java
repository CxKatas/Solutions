
import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StatusTest {
	@SuppressWarnings("unused")
	private static Stream<Arguments> frequentFlyerActivity() {
		return Stream.of(Arguments.of(50000, 59, 5000, Status.GOLD), 
				         Arguments.of(50000, 59, 4999, Status.SILVER), 
				         Arguments.of(49999, 59, 5000, Status.SILVER),
				         Arguments.of(49999, 60, 5000, Status.GOLD),
				         Arguments.of(-1, -1, -1, Status.MEMBER)
				         );
	}

	@ParameterizedTest(name = "Flying {0} miles or {1} segments, and spending {2} dollars give you {3} status")
	@MethodSource("frequentFlyerActivity")
	public void getQualificationStatus(int milesFlown, int segmentsFlown, int dollarsSpent, Status expectedLevel) {
		assertEquals(expectedLevel, Status.get(milesFlown, segmentsFlown, dollarsSpent));
	}
}
