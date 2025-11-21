
package qmeasures.pressure.units;

import qmeasures.pressure.quantities.APressure;
import qmeasures.pressure.quantities.EPressureDims;

/**
 * Time quantity representing a value in seconds.
 */
public class TPascal extends APressure<TPascal> {

    public TPascal(double value) { super(value, EPressureUnit.PASCAL, EPressureDims.PRESSURE);  }

    @Override  public TPascal of(double value, EPressureUnit unit) { return new TPascal(value);  }
}