
package qmeasures.pressure.units;

import qmeasures.pressure.quantities.APressure;
import qmeasures.pressure.quantities.EPressureDims;

/**
 * Time quantity representing a value in seconds.
 */
public class TPSI extends APressure<TPSI> {

    public TPSI(double value) { super(value, EPressureUnit.PSI, EPressureDims.PRESSURE);  }

    @Override  public TPSI of(double value, EPressureUnit unit) { return new TPSI(value);  }
}