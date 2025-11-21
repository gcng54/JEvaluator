
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class TMeterPerSec extends ASpeed<TMeterPerSec> {

    public TMeterPerSec(double value) { super(value, ESpeedUnit.METERS_PER_SECOND, ESpeedDims.SPEED);  }
    
    @Override  public TMeterPerSec of(double value, ESpeedUnit unit) { return new TMeterPerSec(value);  }

}