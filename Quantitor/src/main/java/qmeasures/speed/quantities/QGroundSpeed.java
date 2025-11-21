
package qmeasures.speed.quantities;

import qmeasures.speed.ESpeeds;

/**
 * Speed quantity representing ground speed (typically measured in km/h).
 */
public class QGroundSpeed extends ASpeed<QGroundSpeed> {

    /**
     * Constructs a ground speed with the specified value and unit.
     * @param value the value
     * @param unit the speed unit
     */
    public QGroundSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.GROUND_SPEED);}

    /**
     * Constructs a ground speed in kilometers per hour.
     * @param value the value in km/h
     */
    public QGroundSpeed(double value) { super(value, ESpeeds.KILOMETERS_PER_HOUR, ESpeedDims.GROUND_SPEED);  }

    /**
     * Creates a new QGroundSpeed instance from a value and unit.
     * @param value the value
     * @param unit the speed unit
     * @return a new QGroundSpeed instance
     */
    @Override public QGroundSpeed of(double value, ESpeeds unit) { return new QGroundSpeed(value, unit); }

}
