import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MedallionQualificationTest {

    private static final MedallionQualification.Level MEMBER = MedallionQualification.Level.MEMBER;
    private static final MedallionQualification.Level SILVER = MedallionQualification.Level.SILVER;
    private static final MedallionQualification.Level GOLD = MedallionQualification.Level.GOLD;
    private static final MedallionQualification.Level DIAMOND = MedallionQualification.Level.DIAMOND;
    private final int miles;
    private final int segments;
    private final int dollars;
    private final MedallionQualification.Level expectedLevel;

    public MedallionQualificationTest(int miles, int segments, int dollars,
            MedallionQualification.Level expectedLevel) {
        this.miles = miles;
        this.segments = segments;
        this.dollars = dollars;
        this.expectedLevel = expectedLevel;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                { 25000, 25, 3000, SILVER },
                { 100000, 141, 12500, DIAMOND }, 
                { 24999, 20, 1000, MEMBER },
                { 24999, 29, 2500, MEMBER }, 
                { 24999, 30, 2500, SILVER },
                { 25000, 30, 2499, MEMBER }, 
                { 125000, 100, 2500, SILVER } 
                });
    }

    @Test
    public void getQualificationStatus() {
        assertEquals(expectedLevel,
                MedallionQualification.getStatus(miles, segments, dollars));
    }
}
