package qmeasures.speed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import qmeasures.core.Clampable;
import qmeasures.speed.quantities.ESpeedDims;
import qmeasures.speed.quantities.QAirSpeed;
import qmeasures.speed.quantities.QGroundSpeed;
import qmeasures.speed.quantities.QSeaSpeed;


public class ASpeedTest {


    @Test
    void testConstructors() {
        QSpeed s1 = new QSpeed(10.0, ESpeeds.METERS_PER_SECOND);
        assertEquals(10.0, s1.getValue());
        assertEquals(ESpeeds.METERS_PER_SECOND, s1.getUnit());
        assertEquals(ESpeedDims.SPEED, s1.getDimension());

        QSpeed s2 = new QSpeed(20.0, ESpeeds.KILOMETERS_PER_HOUR);
        assertEquals(20.0, s2.getValue());
        assertEquals(ESpeeds.KILOMETERS_PER_HOUR, s2.getUnit());
    }

    @Test
    void testGetUnitAndDimension() {
        QSpeed s = new QSpeed(5.0, ESpeeds.KILOMETERS_PER_HOUR);
        assertEquals(ESpeeds.KILOMETERS_PER_HOUR, s.getUnit());
        assertEquals(ESpeedDims.SPEED, s.getDimension());
    }

    @Test
    void testGetClampMode() {
        QSpeed s = new QSpeed(1.0, ESpeeds.METERS_PER_SECOND);
        assertEquals(Clampable.EClampMode.BOUND, s.getClampMode());
    }

    @Test
    void testToDimension() {
        QSpeed s = new QSpeed(10.0, ESpeeds.METERS_PER_SECOND);

        assertTrue(s.toDimension(ESpeedDims.SPEED) instanceof QSpeed);
        assertTrue(s.toDimension(ESpeedDims.GROUND_SPEED) instanceof QGroundSpeed);
        assertTrue(s.toDimension(ESpeedDims.SEA_SPEED) instanceof QSeaSpeed);
        assertTrue(s.toDimension(ESpeedDims.AIR_SPEED) instanceof QAirSpeed);

    }

    @Test
    void testToReflection() {
        QSpeed s = new QSpeed(15.0, ESpeeds.KILOMETERS_PER_HOUR);
        QGroundSpeed gs = s.to(QGroundSpeed.class);
        assertEquals(15.0, gs.getValue(), 1e-5);
        assertEquals(ESpeeds.KILOMETERS_PER_HOUR, gs.getUnit());
    }


    @Test
    void testOfMeterPerSecondAndKilometerPerHour() {
        QSpeed s = new QSpeed(36.0, ESpeeds.KILOMETERS_PER_HOUR);

        QSpeed sMps = s.ofMeterPerSecond();
        assertEquals(10.0, sMps.getValue(), 1e-5);
        assertEquals(ESpeeds.METERS_PER_SECOND, sMps.getUnit());

        QSpeed sKph = s.ofKilometerPerHour();
        assertEquals(36.0, sKph.getValue(), 1e-9);
        assertEquals(ESpeeds.KILOMETERS_PER_HOUR, sKph.getUnit());
    }

    @Test
    void testInMeterPerSecondAndKilometerPerHour() {
        QSpeed s = new QSpeed(10.0, ESpeeds.METERS_PER_SECOND);
        assertEquals(10.0, s.inMeterPerSecond(), 1e-9);
        assertEquals(36.0, s.inKilometerPerHour(), 1e-4);

        QSpeed s2 = new QSpeed(36.0, ESpeeds.KILOMETERS_PER_HOUR);
        assertEquals(10.0, s2.inMeterPerSecond(), 1e-5);
        assertEquals(36.0, s2.inKilometerPerHour(), 1e-4);
    }
}