
package qmeasures.temperature.units;

import qmeasures.temperature.ETemperatures;
import qmeasures.temperature.quantities.ATemperature;
import qmeasures.temperature.quantities.ETemperatureDims;

/**
 * Temperature quantity in Fahrenheit.
 */
public class QFahrenheit extends ATemperature<QFahrenheit> {
    /**
     * Constructs a Fahrenheit temperature quantity.
     * @param value the value in Fahrenheit
     */
    public QFahrenheit(double value) {
        super(value, ETemperatures.FAHRENHEIT, ETemperatureDims.FAHRENHEIT);
    }

    /**
     * Creates a new QFahrenheit instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QFahrenheit instance
     */
    @Override
    public QFahrenheit of(double value, ETemperatures unit) {
        return new QFahrenheit(unit.fromBaseValue(value));
    }
}
