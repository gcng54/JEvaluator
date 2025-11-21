
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class TKph extends ASpeed<TKph> {

    public TKph(double value) { super(value, ESpeedUnit.KILOMETERS_PER_HOUR, ESpeedDims.SPEED);  }
    
    @Override  public TKph of(double value, ESpeedUnit unit) { return new TKph(value);  }

}