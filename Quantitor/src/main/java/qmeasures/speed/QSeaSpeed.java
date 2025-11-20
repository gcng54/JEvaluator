
package qmeasures.speed;

/**
 * Speed quantity representing sea speed (typically measured in knots).
 */
public class QSeaSpeed extends ASpeed<QSeaSpeed> {

    /**
     * Constructs a sea speed with the specified value and unit.
     * @param value the value
     * @param unit the speed unit
     */
    public QSeaSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.SEA_SPEED);}

    /**
     * Constructs a sea speed in knots.
     * @param value the value in knots
     */
    public QSeaSpeed(double value) { this(value, ESpeeds.KNOTS);  }

    /**
     * Creates a new QSeaSpeed instance from a value and unit.
     * @param value the value
     * @param unit the speed unit
     * @return a new QSeaSpeed instance
     */
    @Override public QSeaSpeed of(Double value, ESpeeds unit) { return new QSeaSpeed(value, unit); }

}
