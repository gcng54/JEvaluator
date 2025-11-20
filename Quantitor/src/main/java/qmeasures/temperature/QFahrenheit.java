
package qmeasures.temperature;

/**
 * Temperature quantity in Fahrenheit.
 */
public class QFahrenheit extends ATemperature<QFahrenheit> {
    /**
     * Constructs a Fahrenheit temperature quantity.
     * @param value the value in Fahrenheit
     */
    public QFahrenheit(Double value) {
        super(value, ETemperatures.FAHRENHEIT, ETemperatureDims.FAHRENHEIT);
    }

    /**
     * Creates a new QFahrenheit instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QFahrenheit instance
     */
    @Override
    public QFahrenheit of(Double value, ETemperatures unit) {
        return new QFahrenheit(unit.fromBaseValue(value));
    }
}
