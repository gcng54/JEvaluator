
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class QMach extends ASpeed<QMach> {

    public QMach(double value) { super(value, ESpeeds.MACH, ESpeedDims.SPEED);  }
    
    @Override  public QMach of(double value, ESpeeds unit) { return new QMach(value);  }

}