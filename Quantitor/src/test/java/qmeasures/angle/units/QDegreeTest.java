package qmeasures.angle.units;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import qmeasures.angle.EAngles;
import qmeasures.angle.quantities.EAngleDims;

class QDegreeTest {

    @Test
    void constructorSetsValueAndUnitAndDimension() {
        double value = 45.0;
        QDegree degree = new QDegree(value);
        assertEquals(value, degree.getValue(), 1e-10);
        assertEquals(EAngles.DEGREE, degree.getUnit());
        assertEquals(EAngleDims.ANGLE, degree.getDimension());
    }

    @Test
    void ofCreatesNewQDegreeWithGivenValue() {
        QDegree original = new QDegree(30.0);
        QDegree created = original.of(90.0, EAngles.DEGREE);
        assertNotSame(original, created);
        assertEquals(90.0, created.getValue(), 1e-10);
        assertEquals(EAngles.DEGREE, created.getUnit());
    }

    @Test
    void valueIsClampedWithinMinAndMaxQ() {
        QDegree minDegree = new QDegree(Double.NEGATIVE_INFINITY);
        QDegree maxDegree = new QDegree(Double.POSITIVE_INFINITY);

        double minQ = minDegree.getMinQ().getValue();
        double maxQ = maxDegree.getMaxQ().getValue();

        QDegree belowMin = new QDegree(minQ - 100);
        QDegree aboveMax = new QDegree(maxQ + 100);

        assertTrue(belowMin.getValue() >= minQ);
        assertTrue(aboveMax.getValue() <= maxQ);
    }
}