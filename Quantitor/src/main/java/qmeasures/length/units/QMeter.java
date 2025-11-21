package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class QMeter extends ALength<QMeter> {

    public QMeter(double value) { super(value, ELengths.METER, ELengthDims.LENGTH); }

    @Override public QMeter of(double value, ELengths dummy) { return new QMeter(value); }

}