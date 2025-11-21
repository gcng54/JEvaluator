
package qmeasures.speed.units;

import qmeasures.speed.ESpeeds;
import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class QMeterPerSec extends ASpeed<QMeterPerSec> {

    /**
     * Constructs a speed in meters per second.
     * @param value the value in m/s
     */
    public QMeterPerSec(double value) { super(value, ESpeeds.METERS_PER_SECOND, ESpeedDims.SPEED);  }
    
    /**
     * Creates a new QMeterPerSec instance from a value and unit.
     * @param value the value
     * @param unit the speed unit (ignored, always m/s)
     * @return a new QMeterPerSec instance
     */
    @Override  public QMeterPerSec of(double value, ESpeeds unit) { return new QMeterPerSec(value);  }

}