
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class QMeterPerSec extends ASpeed<QMeterPerSec> {

    public QMeterPerSec(double value) { super(value, ESpeeds.METERS_PER_SECOND, ESpeedDims.SPEED);  }
    
    @Override  public QMeterPerSec of(double value, ESpeeds unit) { return new QMeterPerSec(value);  }

}