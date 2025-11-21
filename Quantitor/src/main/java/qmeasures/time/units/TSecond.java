
package qmeasures.time.units;

import qmeasures.time.quantities.ATime;
import qmeasures.time.quantities.ETimeDims;

/**
 * Time quantity representing a value in seconds.
 */
public class TSecond extends ATime<TSecond> {

    /**
     * Constructs a time quantity in seconds.
     * @param value the value in seconds
     */
    public TSecond(double value) { super(value, ETimeUnit.SECOND, ETimeDims.TIME);  }

    /**
     * Creates a new QSecond instance from a value and unit.
     * @param value the value
     * @param unit the time unit
     * @return a new QSecond instance
     */
    @Override  public TSecond of(double value, ETimeUnit unit) { return new TSecond(value);  }

}