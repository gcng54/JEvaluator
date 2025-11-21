
package qmeasures.power.units;

import qmeasures.power.quantities.APower;
import qmeasures.power.quantities.EPowerDims;

public class TMegaWatt extends APower<TMegaWatt> {

    public TMegaWatt(double value) { super(value, EPowerUnit.MEGAWATT, EPowerDims.POWER);  }

    @Override  public TMegaWatt of(double value, EPowerUnit unit) { return new TMegaWatt(value);  }

}