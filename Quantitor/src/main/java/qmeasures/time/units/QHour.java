
package qmeasures.time.units;

import qmeasures.time.quantities.ATime;
import qmeasures.time.quantities.ETimeDims;

/**
 * Time quantity representing a value in seconds.
 */
public class QHour extends ATime<QHour> {

    /**
     * Constructs a time quantity in seconds.
     * @param value the value in seconds
     */
    public QHour(double value) { super(value, ETimes.HOUR, ETimeDims.TIME);  }

    /**
     * Creates a new QSecond instance from a value and unit.
     * @param value the value
     * @param unit the time unit
     * @return a new QSecond instance
     */
    @Override  public QHour of(double value, ETimes unit) { return new QHour(value);  }

}