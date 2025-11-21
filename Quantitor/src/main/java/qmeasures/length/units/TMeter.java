package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class TMeter extends ALength<TMeter> {

    public TMeter(double value) { super(value, ELengthUnit.METER, ELengthDims.LENGTH); }

    @Override public TMeter of(double value, ELengthUnit dummy) { return new TMeter(value); }

}