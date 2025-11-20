
package qmeasures.time;

/**
 * Time quantity representing a value in seconds.
 */
public class QSecond extends ATime<QSecond> {

    /**
     * Constructs a time quantity in seconds.
     * @param value the value in seconds
     */
    public QSecond(double value) { super(value, ETimes.SECOND, ETimeDims.TIME);  }

    /**
     * Creates a new QSecond instance from a value and unit.
     * @param value the value
     * @param unit the time unit
     * @return a new QSecond instance
     */
    @Override  public QSecond of(Double value, ETimes unit) { return new QSecond(value);  }

}