
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class TKnot extends ASpeed<TKnot> {

    public TKnot(double value) { super(value, ESpeedUnit.KNOTS, ESpeedDims.SPEED);  }
    
    @Override  public TKnot of(double value, ESpeedUnit unit) { return new TKnot(value);  }

}