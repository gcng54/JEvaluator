package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class QMile extends ALength<QMile> {

    public QMile(double value) { super(value, ELengths.MILE, ELengthDims.LENGTH); }

    @Override public QMile of(double value, ELengths dummy) { return new QMile(value); }

}