
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class QKnot extends ASpeed<QKnot> {

    public QKnot(double value) { super(value, ESpeeds.KNOTS, ESpeedDims.SPEED);  }
    
    @Override  public QKnot of(double value, ESpeeds unit) { return new QKnot(value);  }

}