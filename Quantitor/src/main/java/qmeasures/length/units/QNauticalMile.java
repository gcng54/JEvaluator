package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class QNauticalMile extends ALength<QNauticalMile> {

    public QNauticalMile(double value) { super(value, ELengths.NAUTICALMILE, ELengthDims.LENGTH); }

    @Override public QNauticalMile of(double value, ELengths dummy) { return new QNauticalMile(value); }

}