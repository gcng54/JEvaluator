
package qmeasures.time;

/**
 * Time quantity representing a frequency (cycles per second, Hz).
 */
public class QFrequency extends ATime<QFrequency> {

    /**
     * Constructs a frequency with the specified value and unit.
     * @param value the value
     * @param unit the time unit
     */
    public QFrequency(double value, ETimes unit) { super(value, unit, ETimeDims.FREQUENCY); }

    /**
     * Constructs a frequency in seconds.
     * @param value the value in seconds
     */
    public QFrequency(double value) { this(value, ETimes.SECOND); }

    /**
     * Creates a new QFrequency instance from a value and unit.
     * @param value the value
     * @param unit the time unit
     * @return a new QFrequency instance
     */
    @Override public QFrequency of(Double value, ETimes unit) {  return new QFrequency(value, unit);   }

}