package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class TMile extends ALength<TMile> {

    public TMile(double value) { super(value, ELengthUnit.MILE, ELengthDims.LENGTH); }

    @Override public TMile of(double value, ELengthUnit dummy) { return new TMile(value); }

}