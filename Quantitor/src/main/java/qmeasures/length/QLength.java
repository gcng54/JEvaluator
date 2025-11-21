package qmeasures.length;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

/**
 * Concrete length quantity representing a distance.
 */
public class QLength extends ALength<QLength> {

    public QLength(double value) {
        super(value, ELengths.METER, ELengthDims.LENGTH);
    }

    public QLength(double value, ELengths unit) {
        super(value, unit, ELengthDims.LENGTH);
    }

    @Override public QLength of(double value, ELengths unit) {
        return new QLength(value, unit);
    }


}

