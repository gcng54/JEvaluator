
package qmeasures.pressure.units;

import qmeasures.pressure.quantities.APressure;
import qmeasures.pressure.quantities.EPressureDims;

/**
 * Time quantity representing a value in seconds.
 */
public class TAtmosphere extends APressure<TAtmosphere> {

    public TAtmosphere(double value) { super(value, EPressureUnit.ATMOSPHERE, EPressureDims.PRESSURE);  }

    @Override  public TAtmosphere of(double value, EPressureUnit unit) { return new TAtmosphere(value);  }
}