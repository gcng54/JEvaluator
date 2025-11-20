
package qmeasures.temperature;

/**
 * Temperature quantity in Kelvin.
 */
public class QKelvin extends ATemperature<QKelvin> {
    /**
     * Constructs a Kelvin temperature quantity.
     * @param value the value in Kelvin
     */
    public QKelvin(double value) {
        super(value, ETemperatures.KELVIN, ETemperatureDims.KELVIN);
    }

    /**
     * Creates a new QKelvin instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QKelvin instance
     */
    @Override
    public QKelvin of(double value, ETemperatures unit) {
        return new QKelvin(unit.toBaseValue(value));
    }
}
