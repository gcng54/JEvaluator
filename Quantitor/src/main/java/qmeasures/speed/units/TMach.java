
package qmeasures.speed.units;

import qmeasures.speed.quantities.ASpeed;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Speed quantity representing a value in meters per second.
 */
public class TMach extends ASpeed<TMach> {

    public TMach(double value) { super(value, ESpeedUnit.MACH, ESpeedDims.SPEED);  }
    
    @Override  public TMach of(double value, ESpeedUnit unit) { return new TMach(value);  }

}