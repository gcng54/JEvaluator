
package qmeasures.power.units;

import qmeasures.power.quantities.APower;
import qmeasures.power.quantities.EPowerDims;

/**
 * Time quantity representing a value in seconds.
 */
public class THorsePower extends APower<THorsePower> {

    /**
     * Constructs a time quantity in seconds.
     * @param value the value in seconds
     */
    public THorsePower(double value) { super(value, EPowerUnit.HORSE_POWER, EPowerDims.POWER);  }

    /**
     * Creates a new QSecond instance from a value and unit.
     * @param value the value
     * @param unit the time unit
     * @return a new QSecond instance
     */
    @Override  public THorsePower of(double value, EPowerUnit unit) { return new THorsePower(value);  }

}