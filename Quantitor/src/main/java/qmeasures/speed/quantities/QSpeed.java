
package qmeasures.speed.quantities;

import qmeasures.speed.units.ESpeedUnit;

/**
 * Speed quantity representing generic speed (default unit: meters per second).
 */
public class QSpeed extends ASpeed<QSpeed> {

    /**
     * Constructs a speed with the specified value and unit.
     * @param value the value
     * @param unit the speed unit
     */
    public QSpeed(double value, ESpeedUnit unit) { super(value, unit, ESpeedDims.SPEED);}

    /**
     * Constructs a speed in meters per second.
     * @param value the value in m/s
     */
    public QSpeed(double value) { super(value, ESpeedUnit.METERS_PER_SECOND, ESpeedDims.SPEED);  }

    /**
     * Creates a new QSpeed instance from a value and unit.
     * @param value the value
     * @param unit the speed unit
     * @return a new QSpeed instance
     */
    @Override public QSpeed of(double value, ESpeedUnit unit) { return new QSpeed(value, unit); }

}