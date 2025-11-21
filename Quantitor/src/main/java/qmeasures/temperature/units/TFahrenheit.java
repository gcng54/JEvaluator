
package qmeasures.temperature.units;

import qmeasures.temperature.quantities.ATemperature;
import qmeasures.temperature.quantities.ETemperatureDims;

/**
 * Temperature quantity in Fahrenheit.
 */
public class TFahrenheit extends ATemperature<TFahrenheit> {
    /**
     * Constructs a Fahrenheit temperature quantity.
     * @param value the value in Fahrenheit
     */
    public TFahrenheit(double value) {
        super(value, ETemperatures.FAHRENHEIT, ETemperatureDims.FAHRENHEIT);
    }

    /**
     * Creates a new QFahrenheit instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QFahrenheit instance
     */
    @Override
    public TFahrenheit of(double value, ETemperatures unit) {
        return new TFahrenheit(unit.fromBaseValue(value));
    }
}
