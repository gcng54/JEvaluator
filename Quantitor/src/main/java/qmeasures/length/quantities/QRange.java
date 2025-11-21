package qmeasures.length.quantities;

import qmeasures.length.units.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QRange extends ALengthDim<QRange> {

    public QRange(ALength<?> length) {        super(length, ELengthDims.RANGE);    }

    protected QRange(double value) { super(value, ELengths.METER, ELengthDims.RANGE);  }

    public QRange(double value, ELengths unit) { super(value, unit, ELengthDims.RANGE);  }

    @Override public QRange of(double value, ELengths unit) { return new QRange(value, unit);  }

}
