
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class QMph extends ASpeed<QMph> {

    public QMph(double value) { super(value, ESpeeds.MILES_PER_HOUR, ESpeedDims.SPEED);  }
    
    @Override  public QMph of(double value, ESpeeds unit) { return new QMph(value);  }

}