
package qmeasures.time.units;

import qmeasures.time.quantities.ATime;
import qmeasures.time.quantities.ETimeDims;

/**
 * Time quantity representing a value in seconds.
 */
public class THour extends ATime<THour> {

    /**
     * Constructs a time quantity in seconds.
     * @param value the value in seconds
     */
    public THour(double value) { super(value, ETimeUnit.HOUR, ETimeDims.TIME);  }

    /**
     * Creates a new QSecond instance from a value and unit.
     * @param value the value
     * @param unit the time unit
     * @return a new QSecond instance
     */
    @Override  public THour of(double value, ETimeUnit unit) { return new THour(value);  }

}