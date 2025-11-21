package qmeasures.angle.units;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import qmeasures.angle.quantities.EAngleDims;

class QDegreeTest {

    @Test
    void constructorSetsValueAndUnitAndDimension() {
        double value = 45.0;
        TDegree degree = new TDegree(value);
        assertEquals(value, degree.getValue(), 1e-10);
        assertEquals(EAngles.DEGREE, degree.getUnit());
        assertEquals(EAngleDims.ANGLE, degree.getDimension());
    }

    @Test
    void ofCreatesNewQDegreeWithGivenValue() {
        TDegree original = new TDegree(30.0);
        TDegree created = original.of(90.0, EAngles.DEGREE);
        assertNotSame(original, created);
        assertEquals(90.0, created.getValue(), 1e-10);
        assertEquals(EAngles.DEGREE, created.getUnit());
    }

    @Test
    void valueIsClampedWithinMinAndMaxQ() {
        TDegree minDegree = new TDegree(Double.NEGATIVE_INFINITY);
        TDegree maxDegree = new TDegree(Double.POSITIVE_INFINITY);

        double minQ = minDegree.getMinQ().getValue();
        double maxQ = maxDegree.getMaxQ().getValue();

        TDegree belowMin = new TDegree(minQ - 100);
        TDegree aboveMax = new TDegree(maxQ + 100);

        assertTrue(belowMin.getValue() >= minQ);
        assertTrue(aboveMax.getValue() <= maxQ);
    }
}