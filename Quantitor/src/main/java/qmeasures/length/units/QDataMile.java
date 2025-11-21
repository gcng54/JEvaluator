package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class QDataMile extends ALength<QDataMile> {

    public QDataMile(double value) { super(value, ELengths.DATAMILE, ELengthDims.LENGTH); }

    @Override public QDataMile of(double value, ELengths dummy) { return new QDataMile(value); }

}