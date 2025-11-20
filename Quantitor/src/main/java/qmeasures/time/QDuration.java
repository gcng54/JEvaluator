
package qmeasures.time;

/**
 * Time quantity representing a duration (elapsed time, always >= 0).
 */
public class QDuration extends ATime<QDuration> {

    /**
     * Constructs a duration with the specified value and unit.
     * @param value the value
     * @param unit the time unit
     */
    public QDuration(double value, ETimes unit) { super(value, unit, ETimeDims.DURATION); }

    /**
     * Constructs a duration in seconds.
     * @param value the value in seconds
     */
    public QDuration(double value) { this(value, ETimes.SECOND); }

    /**
     * Creates a new QDuration instance from a value and unit.
     * @param value the value
     * @param unit the time unit
     * @return a new QDuration instance
     */
    @Override public QDuration of(double value, ETimes unit) {  return new QDuration(value, unit);   }

}