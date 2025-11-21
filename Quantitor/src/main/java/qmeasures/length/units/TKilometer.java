package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class TKilometer extends ALength<TKilometer> {

    public TKilometer(double value) { super(value, ELengthUnit.KILOMETER, ELengthDims.LENGTH);  }

    @Override  public TKilometer of(double value, ELengthUnit dummy) { return new TKilometer(value); }

}