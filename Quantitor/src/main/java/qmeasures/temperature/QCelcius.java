
package qmeasures.temperature;

/**
 * Temperature quantity in Celsius.
 */
public class QCelcius extends ATemperature<QCelcius> {
    /**
     * Constructs a Celsius temperature quantity.
     * @param value the value in Celsius
     */
    public QCelcius(Double value) {
        super(value, ETemperatures.CELCIUS, ETemperatureDims.CELCIUS);
    }

    /**
     * Creates a new QCelcius instance from a value and unit.
     * @param value the value
     * @param unit the temperature unit
     * @return a new QCelcius instance
     */
    @Override
    public QCelcius of(Double value, ETemperatures unit) {
        return new QCelcius(unit.fromBaseValue(value));
    }
}
