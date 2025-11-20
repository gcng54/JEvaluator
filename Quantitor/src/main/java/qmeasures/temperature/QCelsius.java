
package qmeasures.temperature;

/**
 * Temperature quantity in Celsius.
 */
public class QCelsius extends ATemperature<QCelsius> {
    /**
     * Constructs a Celsius temperature quantity.
     * @param value the value in Celsius
     */
    public QCelsius(double value) {
        super(value, ETemperatures.CELSIUS, ETemperatureDims.CELSIUS);
    }

    /**
     * Creates a new QCelsius instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QCelsius instance
     */
    @Override
    public QCelsius of(double value, ETemperatures unit) {
        return new QCelsius(unit.fromBaseValue(value));
    }
}
