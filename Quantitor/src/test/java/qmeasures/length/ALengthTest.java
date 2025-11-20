package qmeasures.length;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qmeasures.core.Clampable;
import static org.junit.jupiter.api.Assertions.*;

// Test class
public class ALengthTest {

    private QLength lengthMeter;
    private QLength lengthKm;

    @BeforeEach
    void setUp() {
        lengthMeter = new QLength(10.0, ELengths.METER);
        lengthKm = new QLength(5.0, ELengths.KILOMETER);
    }

    @Test
    void testMathematics() {

        assertEquals(10.0 + 5000.0, lengthMeter.add(lengthKm).inMeter(), 1e-9);
        assertEquals(5000.0 - 10.0, lengthKm.sub(lengthMeter).inMeter(), 1e-9);
        assertEquals(10.0 * 3.0, lengthMeter.mul(3.0).inMeter(), 1e-9);
        assertEquals(5.0 / 2.0, lengthKm.div(2.0).inKilometer(), 1e-9); 
        assertEquals(-10.0, lengthMeter.negative().inMeter(), 1e-9);
        assertEquals(100.0, lengthMeter.pow(2).inMeter(), 1e-9);
        assertEquals(Math.sqrt(10.0), lengthMeter.sqrt().inMeter(), 1e-9);
        assertEquals(Math.floor(10.0), lengthMeter.floor().inMeter(), 1e-9);
        assertEquals(Math.ceil(10.0), lengthMeter.ceil().inMeter(), 1e-9);
        assertEquals(Math.abs(10.0), lengthMeter.abs().inMeter(), 1e-9);
        assertEquals(1.0 / 10.0, lengthMeter.invert().inMeter(), 1e-9);
        assertEquals(2.0, lengthMeter.add( -8.0).inMeter(), 1e-9);
        assertEquals(8.0, lengthMeter.sub(2.0).inMeter(), 1e-9);
        assertEquals(5.0, lengthMeter.rsub(15.0).inMeter(), 1e-9);
        assertEquals(2.0, lengthMeter.div(new QLength(5.0, ELengths.METER)).getValue(), 1e-9);
        assertEquals(2.0, lengthMeter.ratio(new QLength(5.0, ELengths.METER)), 1e-9);
        assertEquals(-1.0, lengthMeter.compareTo(new QLength(15.0, ELengths.METER)), 1e-9);
        assertTrue(lengthMeter.less(new QLength(15.0, ELengths.METER)));
        assertTrue(lengthMeter.lessOrEqual(new QLength(10.0, ELengths.METER)));
        assertTrue(lengthKm.greater(new QLength(3000.0, ELengths.METER)));
        assertTrue(lengthKm.greaterOrEqual(new QLength(5.0, ELengths.KILOMETER)));
        assertTrue(lengthMeter.equalsTo(new QLength(10.0, ELengths.METER)));
        assertFalse(lengthMeter.isEqualToZero());
        assertFalse(lengthMeter.isCloseToZero());
        assertTrue(lengthMeter.isPositive());
        assertTrue(lengthMeter.isPositiveOrZero());
        assertFalse(lengthMeter.isNegative());
        assertFalse(lengthMeter.isNegativeOrZero());
        assertEquals(Math.log(10.0) / Math.log(10.0), lengthMeter.logBase(10.0).getValue(), 1e-9);
        
    }


    @Test
    void testGetUnitAndDimension() {
        assertEquals(ELengths.METER, lengthMeter.getUnit());
        assertEquals(ELengthDims.LENGTH, lengthMeter.getDimension());
    }

    @Test
    void testClampMode() {
        assertEquals(Clampable.EClampMode.BOUND, lengthMeter.getClampMode());
    }

    @Test
    void testToDimension() {
        assertTrue(lengthMeter.toDimension(ELengthDims.LENGTH) instanceof QLength);
        assertTrue(lengthMeter.toDimension(ELengthDims.DISTANCE) instanceof QDistance);
        assertTrue(lengthMeter.toDimension(ELengthDims.ALTITUDE) instanceof QAltitude);
        assertTrue(lengthMeter.toDimension(ELengthDims.HEIGHT) instanceof QHeight);
        assertTrue(lengthMeter.toDimension(ELengthDims.AREA) instanceof QArea);
        assertTrue(lengthMeter.toDimension(ELengthDims.VOLUME) instanceof QVolume);
        assertThrows(NullPointerException.class, () -> lengthMeter.toDimension(null));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    void testToWithReflection() {
        QDistance dist = lengthMeter.to(QDistance.class);
        assertNotNull(dist);
        assertEquals(lengthMeter.getValue(), dist.getValue());
        assertEquals(lengthMeter.getUnit(), dist.getUnit());
        assertThrows(IllegalArgumentException.class, () -> lengthMeter.to((Class)null));
    }

    @Test
    void testToArea() {
        QArea area = lengthMeter.toArea(lengthMeter);
        assertEquals(Math.pow(10.0, 2), area.getValue());
        assertEquals(lengthMeter.getUnit(), area.getUnit());
        assertThrows(IllegalArgumentException.class, () -> lengthMeter.toArea(null));
    }

    @Test
    void testToVolume() {
        QVolume volume = lengthMeter.toVolume(lengthMeter);
        assertEquals(Math.pow(10.0, 3), volume.getValue());
        assertEquals(lengthMeter.getUnit(), volume.getUnit());
        assertThrows(IllegalArgumentException.class, () -> lengthMeter.toVolume(null));
    }

    @Test
    void testDiv() {
        QLength divisor = new QLength(2.0, ELengths.METER);
        QLength result = lengthMeter.div(divisor);
        assertEquals(5.0, result.getValue(), 1e-9);
        assertEquals(lengthMeter.getUnit(), result.getUnit());

        assertThrows(IllegalArgumentException.class, () -> lengthMeter.div(null));
        assertEquals(0.0, new QLength(0.0, ELengths.METER).getValue());
    }

    @Test
    void testUnitConversions() {
        assertEquals(10.0, lengthMeter.ofMeter().getValue());
        assertEquals(10.0, lengthMeter.ofMeter(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofKilometer(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofMillimeter(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofFoot(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofNauticalMile(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofDataMile(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofFlightLevel(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofYard(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofInch(10.0).getValue());
        assertEquals(10.0, lengthMeter.ofMile(10.0).getValue());
    }

    @Test
    void testInUnitMethods() {
        assertEquals(10.0, lengthMeter.inMeter());
        assertEquals(0.01, lengthMeter.inKilometer(), 1e-9);
        assertEquals(10000.0, lengthMeter.inMillimeter(), 1e-9);
        assertEquals(10.936132983377078, lengthMeter.inYard(), 1e-9);
        assertEquals(32.80839895013123, lengthMeter.inFoot(), 1e-9);
        assertEquals(393.7007874015748, lengthMeter.inInch(), 1e-9);
        assertEquals(0.0062137119223733395, lengthMeter.inMile(), 1e-9);
        assertEquals(0.005399568034557235, lengthMeter.inNautMile(), 1e-9);
        assertEquals(0.005494505494505495, lengthMeter.inDataMile(), 1e-4);
        assertEquals(0.32808398950131234, lengthMeter.inFlightLevel(), 1e-9);
    }

    @Test
    void testClampBelowMinimum() {
        // AREA dimension has min 0.0; negative values should be clamped to 0.0
        QArea negArea = new QArea(-5.0, ELengths.METER);
        assertEquals(0.0, negArea.getValue(), 1e-12);
        assertTrue(negArea.wasClamped());
    }
}