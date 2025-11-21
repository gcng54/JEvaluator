
package qmeasures.pressure.units;

import qmeasures.pressure.quantities.APressure;
import qmeasures.pressure.quantities.EPressureDims;

/**
 * Time quantity representing a value in seconds.
 */
public class TBar extends APressure<TBar> {

    public TBar(double value) { super(value, EPressureUnit.BAR, EPressureDims.PRESSURE);  }

    @Override  public TBar of(double value, EPressureUnit unit) { return new TBar(value);  }
}