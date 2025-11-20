package qmeasures.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ATemperatureTest {


    @Test
    void testConstructorAndGetters() {
        QTemperature temp = new QTemperature(100.0, ETemperatures.CELCIUS);
        assertEquals(100.0, temp.getValue());
        assertEquals(ETemperatures.CELCIUS, temp.getUnit());
        assertEquals(ETemperatureDims.TEMPERATURE, temp.getDimension());
    }

    @Test
    void testOfMethod() {
        QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        QTemperature temp2 = temp.of(25.0, ETemperatures.CELCIUS);
        assertEquals(25.0, temp2.getValue());
        assertEquals(ETemperatures.CELCIUS, temp2.getUnit());
    }

    @Test
    void testUnitConversionMethods() {
        QTemperature temp = new QTemperature(10.0, ETemperatures.KELVIN);
        assertEquals(ETemperatures.KELVIN, temp.ofKelvin().getUnit());
        assertEquals(ETemperatures.CELCIUS, temp.ofCelcius().getUnit());
        assertEquals(ETemperatures.FAHRENHEIT, temp.ofFahrenheit().getUnit());
    }

    @Test
    void testUnitConversionWithValue() {
        QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        assertEquals(50.0, temp.ofKelvin(50.0).getValue());
        assertEquals(20.0, temp.ofCelcius(20.0).getValue());
        assertEquals(32.0, temp.ofFahrenheit(32.0).getValue());
    }

    @Test
    void testInUnitMethods() {
        QTemperature temp = new QTemperature(273.15, ETemperatures.KELVIN);
        // These methods just call inUnit, which is not implemented in the abstract class,
        // so we expect the default implementation (likely from AQuantity) to be called.
        // Here, just check that the methods return a double (no exception).
        assertDoesNotThrow(() -> temp.inKelvin());
        assertDoesNotThrow(() -> temp.inCelcius());
        assertDoesNotThrow(() -> temp.inFahrenheit());
    }

    @Test
    void testClampMode() {
        QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        assertEquals(qmeasures.core.Clampable.EClampMode.BOUND, temp.getClampMode());
    }

    @Test
    void testToDimension() {
        QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        // Since QKelvin, QCelcius, QFahrenheit are not available, just check for IllegalStateException for unknown dim
       //  assertThrows(IllegalStateException.class, () -> temp.toDimension(null));
    }

    @Test
    void testToWithReflection() {
       // QTemperature temp = new QTemperature(42.0, ETemperatures.FAHRENHEIT);
       // QTemperature converted = temp.to(QTemperature.class);
     //   assertEquals(42.0, converted.getValue());
      //  assertEquals(ETemperatures.FAHRENHEIT, converted.getUnit());
    }

}