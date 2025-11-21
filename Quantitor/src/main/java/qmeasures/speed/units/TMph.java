
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class TMph extends ASpeed<TMph> {

    public TMph(double value) { super(value, ESpeedUnit.MILES_PER_HOUR, ESpeedDims.SPEED);  }
    
    @Override  public TMph of(double value, ESpeedUnit unit) { return new TMph(value);  }

}