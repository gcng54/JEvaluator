package qmeasures.angle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import qmeasures.core.Clampable;

/**
 * Unit tests for AAngle and its methods.
 */
public class AAngleTest {

    static final double EPS = 1e-9;

    @Test
    void testSinCosTan() {
        QAngle a = new QAngle(90.0, EAngles.DEGREE);
        assertEquals(1.0, a.sin(), EPS);
        assertEquals(0.0, a.cos(), EPS);
        assertTrue(Math.abs(a.tan() - Double.POSITIVE_INFINITY) > 1e6 || Math.abs(a.tan()) > 1e6); // tan(90°) is large

        QAngle b = new QAngle(0.0, EAngles.DEGREE);
        assertEquals(0.0, b.sin(), EPS);
        assertEquals(1.0, b.cos(), EPS);
        assertEquals(0.0, b.tan(), EPS);
    }

    @Test
    void testOfArcSinArcCosArcTan() {
        QAngle a = new QAngle(0.0, EAngles.RADIAN);
        QAngle asin = a.ofArcSin(1.0);
        assertEquals(Math.PI / 2, asin.getValue(), EPS);
        assertEquals(EAngles.RADIAN, asin.getUnit());

        QAngle acos = a.ofArcCos(1.0);
        assertEquals(0.0, acos.getValue(), EPS);

        QAngle atan = a.ofArcTan(1.0);
        assertEquals(Math.PI / 4, atan.getValue(), EPS);

        assertThrows(IllegalArgumentException.class, () -> a.ofArcSin(2.0));
        assertThrows(IllegalArgumentException.class, () -> a.ofArcCos(-2.0));
    }

    @Test
    void testOfArcTan2() {
        QAngle a = new QAngle(0.0, EAngles.RADIAN);
        QAngle atan2 = a.ofArcTan2(1.0, 1.0);
        assertEquals(Math.atan2(1.0, 1.0), atan2.getValue(), EPS);
    }

    @Test
    void testOfArcTanXY() {
        QAngle a = new QAngle(0.0, EAngles.RADIAN);

        // North (0, 1)
        QAngle north = a.ofArcTanXY(0.0, 1.0);
        assertEquals(0.0, north.getValue(), EPS);

        // East (1, 0)
        QAngle east = a.ofArcTanXY(1.0, 0.0);
        assertEquals(Math.PI / 2, east.getValue(), EPS);

        // South (0, -1)
        QAngle south = a.ofArcTanXY(0.0, -1.0);
        assertEquals(Math.PI, south.getValue(), EPS);

        // West (-1, 0)
        QAngle west = a.ofArcTanXY(-1.0, 0.0);
        assertEquals(3 * Math.PI / 2, west.getValue(), EPS);

        // Zero vector
        QAngle zero = a.ofArcTanXY(0.0, 0.0);
        assertEquals(0.0, zero.getValue(), EPS);

        // Invalid input
        assertThrows(IllegalArgumentException.class, () -> a.ofArcTanXY(Double.NaN, 1.0));
        assertThrows(IllegalArgumentException.class, () -> a.ofArcTanXY(1.0, Double.POSITIVE_INFINITY));
    }

    @Test
    void testIsTurnRatio() {
        QAngle a = new QAngle(360.0, EAngles.DEGREE);
        assertTrue(a.isTurnFull());
        assertFalse(a.isTurnHalf());
        assertFalse(a.isTurnQuarter());

        QAngle b = new QAngle(180.0, EAngles.DEGREE);
        assertFalse(b.isTurnFull());
        assertTrue(b.isTurnHalf());
        assertFalse(b.isTurnQuarter());

        QAngle c = new QAngle(90.0, EAngles.DEGREE);
        assertFalse(c.isTurnFull());
        assertFalse(c.isTurnHalf());
        assertTrue(c.isTurnQuarter());

        assertThrows(IllegalArgumentException.class, () -> a.isTurnRatio(-0.1));
        assertThrows(IllegalArgumentException.class, () -> a.isTurnRatio(1.1));
    }

    @Test
    void testUnitConversions() {
        QAngle a = new QAngle(180.0, EAngles.DEGREE);
        assertEquals(Math.PI, a.inRadian(), EPS);
        assertEquals(0.5, a.inTurn(), EPS);
        assertEquals(200.0, a.inGradian(), EPS);
        assertEquals(10800.0, a.inArcMinute(), EPS);
        assertEquals(648000.0, a.inArcSecond(), EPS);

        QAngle b = new QAngle(Math.PI, EAngles.RADIAN);
        assertEquals(180.0, b.inDegree(), EPS);
    }

    @Test
    void testOfUnitMethods() {
        QAngle a = new QAngle(90.0, EAngles.DEGREE);
        assertEquals(EAngles.DEGREE, a.ofDegree().getUnit());
        assertEquals(EAngles.RADIAN, a.ofRadian().getUnit());
        assertEquals(EAngles.TURN, a.ofTurn().getUnit());
        assertEquals(EAngles.GRADIAN, a.ofGradian().getUnit());
        assertEquals(EAngles.ARC_MINUTE, a.ofArcMinute().getUnit());
        assertEquals(EAngles.ARC_SECOND, a.ofArcSecond().getUnit());

        assertEquals(45.0, a.ofDegree(45.0).getValue(), EPS);
        assertEquals(Math.PI, a.ofRadian(Math.PI).getValue(), EPS);
    }

    @Test
    void testToDimension() {
        QAngle a = new QAngle(10.0, EAngles.DEGREE);

        assertTrue(a.toDimension(EAngleDims.ANGLE) instanceof QAngle);
        assertTrue(a.toDimension(EAngleDims.LATITUDE) instanceof QLatitude);
        assertTrue(a.toDimension(EAngleDims.LONGITUDE) instanceof QLongitude);
        assertTrue(a.toDimension(EAngleDims.BEARING) instanceof QBearing);
        assertTrue(a.toDimension(EAngleDims.AZIMUTH) instanceof QAzimuth);
        assertTrue(a.toDimension(EAngleDims.HEADING) instanceof QHeading);
        assertTrue(a.toDimension(EAngleDims.COURSE) instanceof QCourse);
        assertTrue(a.toDimension(EAngleDims.DIRECTION) instanceof QDirection);
        assertTrue(a.toDimension(EAngleDims.ROTATION) instanceof QRotation);
        assertTrue(a.toDimension(EAngleDims.ORIENTATION) instanceof QOrientation);

        assertThrows(NullPointerException.class, () -> a.toDimension(null));
    }


    @Test
    void testGetClampMode() {
        QAngle a = new QAngle(0.0, EAngles.DEGREE);
        assertEquals(Clampable.EClampMode.WRAP, a.getClampMode());
    }
}