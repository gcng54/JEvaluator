package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class QKilometer extends ALength<QKilometer> {

    public QKilometer(double value) { super(value, ELengths.KILOMETER, ELengthDims.LENGTH);  }

    @Override  public QKilometer of(double value, ELengths dummy) { return new QKilometer(value); }

}