
package qmeasures.temperature.units;

import qmeasures.temperature.quantities.ATemperature;
import qmeasures.temperature.quantities.ETemperatureDims;

/**
 * Temperature quantity in Kelvin.
 */
public class TKelvin extends ATemperature<TKelvin> {
    /**
     * Constructs a Kelvin temperature quantity.
     * @param value the value in Kelvin
     */
    public TKelvin(double value) {
        super(value, ETemperatures.KELVIN, ETemperatureDims.KELVIN);
    }

    /**
     * Creates a new QKelvin instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QKelvin instance
     */
    @Override
    public TKelvin of(double value, ETemperatures unit) {
        return new TKelvin(unit.toBaseValue(value));
    }
}
