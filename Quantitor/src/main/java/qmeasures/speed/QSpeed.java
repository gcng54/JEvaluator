
package qmeasures.speed;

/**
 * Speed quantity representing generic speed (default unit: meters per second).
 */
public class QSpeed extends ASpeed<QSpeed> {

    /**
     * Constructs a speed with the specified value and unit.
     * @param value the value
     * @param unit the speed unit
     */
    public QSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.SPEED);}

    /**
     * Constructs a speed in meters per second.
     * @param value the value in m/s
     */
    public QSpeed(double value) { this(value, ESpeeds.METERS_PER_SECOND);  }

    /**
     * Creates a new QSpeed instance from a value and unit.
     * @param value the value
     * @param unit the speed unit
     * @return a new QSpeed instance
     */
    @Override public QSpeed of(Double value, ESpeeds unit) { return new QSpeed(value, unit); }

}