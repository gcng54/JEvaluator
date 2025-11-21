
package qmeasures.temperature.units;

import qmeasures.temperature.quantities.ATemperature;
import qmeasures.temperature.quantities.ETemperatureDims;

/**
 * Temperature quantity in Celsius.
 */
public class TCelsius extends ATemperature<TCelsius> {
    /**
     * Constructs a Celsius temperature quantity.
     * @param value the value in Celsius
     */
    public TCelsius(double value) {
        super(value, ETemperatures.CELSIUS, ETemperatureDims.CELSIUS);
    }

    /**
     * Creates a new QCelsius instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QCelsius instance
     */
    @Override
    public TCelsius of(double value, ETemperatures unit) {
        return new TCelsius(unit.fromBaseValue(value));
    }
}
