package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class QFoot extends ALength<QFoot> {

    public QFoot(double value) { super(value, ELengths.FOOT, ELengthDims.LENGTH); }

    @Override public QFoot of(double value, ELengths dummy) { return new QFoot(value); }

}