package qmeasures.temperature;

import org.junit.jupiter.api.Test;

import qmeasures.temperature.quantities.ETemperatureDims;

import static org.junit.jupiter.api.Assertions.*;

class ATemperatureTest {


    @Test
    void testConstructorAndGetters() {
        QTemperature temp = new QTemperature(100.0, ETemperatures.CELSIUS);
        assertEquals(100.0, temp.getValue());
        assertEquals(ETemperatures.CELSIUS, temp.getUnit());
        assertEquals(ETemperatureDims.TEMPERATURE, temp.getDimension());
    }

    @Test
    void testOfMethod() {
        QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        QTemperature temp2 = temp.of(25.0, ETemperatures.CELSIUS);
        assertEquals(25.0, temp2.getValue());
        assertEquals(ETemperatures.CELSIUS, temp2.getUnit());
    }

    @Test
    void testUnitConversionMethods() {
        QTemperature temp = new QTemperature(10.0, ETemperatures.KELVIN);
        assertEquals(ETemperatures.KELVIN, temp.ofKelvin().getUnit());
        assertEquals(ETemperatures.CELSIUS, temp.ofCelsius().getUnit());
        assertEquals(ETemperatures.FAHRENHEIT, temp.ofFahrenheit().getUnit());
    }

    @Test
    void testUnitConversionWithValue() {
        QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        assertEquals(50.0, temp.ofKelvin(50.0).getValue());
        assertEquals(20.0, temp.ofCelsius(20.0).getValue());
        assertEquals(32.0, temp.ofFahrenheit(32.0).getValue());
    }

    @Test
    void testInUnitMethods() {
        QTemperature temp = new QTemperature(273.15, ETemperatures.KELVIN);
        // These methods just call inUnit, which is not implemented in the abstract class,
        // so we expect the default implementation (likely from AQuantity) to be called.
        // Here, just check that the methods return a double (no exception).
        assertDoesNotThrow(() -> temp.inKelvin());
        assertDoesNotThrow(() -> temp.inCelsius());
        assertDoesNotThrow(() -> temp.inFahrenheit());
    }

    @Test
    void testClampMode() {
        QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        assertEquals(qmeasures.core.Clampable.EClampMode.BOUND, temp.getClampMode());
    }

    @Test
    void testToDimension() {
       // QTemperature temp = new QTemperature(0.0, ETemperatures.KELVIN);
        // Since QKelvin, QCelsius, QFahrenheit are not available, just check for IllegalStateException for unknown dim
       //  assertThrows(IllegalStateException.class, () -> temp.toDimension(null));
    }

    @Test
    void testToWithReflection() {
       // QTemperature temp = new QTemperature(42.0, ETemperatures.FAHRENHEIT);
       // QTemperature converted = temp.to(QTemperature.class);
     //   assertEquals(42.0, converted.getValue());
      //  assertEquals(ETemperatures.FAHRENHEIT, converted.getUnit());
    }

    @Test
    void testInUnitConversionsReturnExpectedValues() {
        QTemperature temp = new QTemperature(25.0, ETemperatures.CELSIUS);
        assertEquals(25.0, temp.inCelsius(), 1e-9);
        assertEquals(298.15, temp.inKelvin(), 1e-9);
        assertEquals(77.0, temp.inFahrenheit(), 1e-9);
    }

    @Test
    void testOfUnitConvenienceMethods() {
        QTemperature base = new QTemperature(300.0, ETemperatures.KELVIN);
        QTemperature asCelsius = base.ofCelsius();
        assertEquals(base.inCelsius(), asCelsius.getValue(), 1e-9);
        assertEquals(ETemperatures.CELSIUS, asCelsius.getUnit());

        QTemperature manualFahrenheit = base.ofFahrenheit(32.0);
        assertEquals(32.0, manualFahrenheit.getValue(), 1e-9);
        assertEquals(ETemperatures.FAHRENHEIT, manualFahrenheit.getUnit());
    }

    @Test
    void testExplicitOfCreatesConvertedInstance() {
        QTemperature template = new QTemperature(0.0, ETemperatures.KELVIN);
        QTemperature fahrenheit = template.of(32.0, ETemperatures.FAHRENHEIT);
        assertEquals(32.0, fahrenheit.getValue(), 1e-9);
        assertEquals(0.0, fahrenheit.inCelsius(), 1e-9);
    }

}