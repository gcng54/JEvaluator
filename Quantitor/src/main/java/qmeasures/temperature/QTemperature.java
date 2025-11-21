package qmeasures.temperature;

import qmeasures.temperature.quantities.ATemperature;
import qmeasures.temperature.quantities.ETemperatureDims;

/**
 * Concrete length quantity representing a distance.
 */
public class QTemperature extends ATemperature<QTemperature> {

    public QTemperature(double value) {
        super(value, ETemperatures.CELSIUS, ETemperatureDims.TEMPERATURE);
    }

    public QTemperature(double value, ETemperatures unit) {
        super(value, unit, ETemperatureDims.TEMPERATURE);
    }

    @Override public QTemperature of(double value, ETemperatures unit) {
        return new QTemperature(value, unit);
    }


}

