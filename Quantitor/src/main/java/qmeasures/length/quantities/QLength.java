package qmeasures.length.quantities;

import qmeasures.length.units.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public class QLength extends ALengthDim<QLength> {

    public QLength(ALength<?> length) {  super(length, ELengthDims.LENGTH);  }

    public QLength(double value) { super(value, ELengths.METER, ELengthDims.LENGTH);  }

    public QLength(double value, ELengths unit) { super(value, unit, ELengthDims.LENGTH);
    }

    @Override public QLength of(double value, ELengths unit) {  return new QLength(value, unit);  }


}

