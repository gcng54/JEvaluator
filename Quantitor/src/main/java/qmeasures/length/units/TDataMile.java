package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class TDataMile extends ALength<TDataMile> {

    public TDataMile(double value) { super(value, ELengthUnit.DATAMILE, ELengthDims.LENGTH); }

    @Override public TDataMile of(double value, ELengthUnit dummy) { return new TDataMile(value); }

}