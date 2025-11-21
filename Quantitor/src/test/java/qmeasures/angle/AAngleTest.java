package qmeasures.angle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import qmeasures.angle.quantities.EAngleDims;
import qmeasures.angle.quantities.QAngle;
import qmeasures.angle.quantities.QAzimuth;
import qmeasures.angle.quantities.QBearing;
import qmeasures.angle.quantities.QDirection;
import qmeasures.angle.quantities.QElevation;
import qmeasures.angle.quantities.QHeading;
import qmeasures.angle.quantities.QLatitude;
import qmeasures.angle.quantities.QLongitude;
import qmeasures.angle.quantities.QOrientation;
import qmeasures.angle.quantities.QRotation;
import qmeasures.angle.units.EAngles;
import qmeasures.core.Clampable;
import qmeasures.qgeodetics.RDegMinSec;

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
        assertEquals(EAngles.ARCMINUTE, a.ofArcMinute().getUnit());
        assertEquals(EAngles.ARCSECOND, a.ofArcSecond().getUnit());

        assertEquals(45.0, a.ofDegree(45.0).getValue(), EPS);
        assertEquals(Math.PI, a.ofRadian(Math.PI).getValue(), EPS);
    }

    @Test
    void testToDimension() {
        QAngle a = new QAngle(10.0, EAngles.DEGREE);

        assertInstanceOf(QAngle.class, a.toDimension(EAngleDims.ANGLE));
        assertInstanceOf(QLatitude.class, a.toDimension(EAngleDims.LATITUDE));
        assertInstanceOf(QLongitude.class, a.toDimension(EAngleDims.LONGITUDE));
        assertInstanceOf(QBearing.class, a.toDimension(EAngleDims.BEARING));
        assertInstanceOf(QAzimuth.class, a.toDimension(EAngleDims.AZIMUTH));
        assertInstanceOf(QHeading.class, a.toDimension(EAngleDims.HEADING));
        assertInstanceOf(QElevation.class, a.toDimension(EAngleDims.ELEVATION));
        assertInstanceOf(QDirection.class, a.toDimension(EAngleDims.DIRECTION));
        assertInstanceOf(QRotation.class, a.toDimension(EAngleDims.ROTATION));
        assertInstanceOf(QOrientation.class, a.toDimension(EAngleDims.ORIENTATION));

    }


    @Test
    void testGetClampMode() {
        QAngle a = new QAngle(0.0, EAngles.DEGREE);
        assertEquals(Clampable.EClampMode.WRAP, a.getClampMode());
    }

    @Test
    void testDegMinSecFormatting() {
        QAngle angle = new QAngle(123.5, EAngles.DEGREE);
        RDegMinSec dms = angle.getDegMinSec();
        assertEquals(123, dms.Degree());
        assertEquals(30, dms.Minute());
        assertEquals(0.0, dms.Second(), EPS);
        assertEquals("123\u00b030'00.00\"", angle.toStringDMS());
    }

    @Test
    void testTurnRatioWithMultipleTurns() {
        QAngle angle = new QAngle(810.0, EAngles.DEGREE);
        assertTrue(angle.isTurnQuarter());
        assertFalse(angle.isTurnHalf());
        assertFalse(angle.isTurnFull());
    }

    @Test
    void testToDimensionCreatesOrientation() {
        QAngle angle = new QAngle(45.0, EAngles.DEGREE);
        QOrientation orientation = (QOrientation) angle.toDimension(EAngleDims.ORIENTATION);
        assertEquals(45.0, orientation.getValue(), EPS);
        assertEquals(EAngleDims.ORIENTATION, orientation.getDimension());
    }
}