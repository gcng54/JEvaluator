package qmeasures.length.quantities;

import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public class QLength extends ALengthDim<QLength> {

    public QLength(ALength<?> length) {  super(length, ELengthDims.LENGTH);  }

    public QLength(double value) { super(value, ELengthUnit.METER, ELengthDims.LENGTH);  }

    public QLength() { super(0.0, ELengthUnit.METER, ELengthDims.LENGTH);  }

    public QLength(double value, ELengthUnit unit) { super(value, unit, ELengthDims.LENGTH);
    }

    @Override public QLength of(double value, ELengthUnit unit) {  return new QLength(value, unit);  }


}

