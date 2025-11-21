package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class TFoot extends ALength<TFoot> {

    public TFoot(double value) { super(value, ELengthUnit.FOOT, ELengthDims.LENGTH); }

    @Override public TFoot of(double value, ELengthUnit dummy) { return new TFoot(value); }

}