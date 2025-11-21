
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class QKph extends ASpeed<QKph> {

    public QKph(double value) { super(value, ESpeeds.KILOMETERS_PER_HOUR, ESpeedDims.SPEED);  }
    
    @Override  public QKph of(double value, ESpeeds unit) { return new QKph(value);  }

}