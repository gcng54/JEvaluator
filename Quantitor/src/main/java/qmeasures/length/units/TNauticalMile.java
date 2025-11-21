package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class TNauticalMile extends ALength<TNauticalMile> {

    public TNauticalMile(double value) { super(value, ELengthUnit.NAUTICALMILE, ELengthDims.LENGTH); }

    @Override public TNauticalMile of(double value, ELengthUnit dummy) { return new TNauticalMile(value); }

}