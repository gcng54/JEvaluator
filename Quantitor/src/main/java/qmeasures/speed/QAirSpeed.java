
package qmeasures.speed;

/**
 * Speed quantity representing airspeed (typically measured in knots).
 */
public class QAirSpeed extends ASpeed<QAirSpeed> {

    /**
     * Constructs an airspeed with the specified value and unit.
     * @param value the value
     * @param unit the speed unit
     */
    public QAirSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.AIR_SPEED);}

    /**
     * Constructs an airspeed in knots.
     * @param value the value in knots
     */
    public QAirSpeed(double value) { this(value, ESpeeds.KNOTS);  }

    /**
     * Creates a new QAirSpeed instance from a value and unit.
     * @param value the value
     * @param unit the speed unit
     * @return a new QAirSpeed instance
     */
    @Override public QAirSpeed of(double value, ESpeeds unit) { return new QAirSpeed(value, unit); }

}
