package qmeasures.length.quantities;

import qmeasures.length.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QRange extends ALength<QRange> {

    public QRange(double value) { super(value, ELengths.METER, ELengthDims.RANGE);  }

    public QRange(double value, ELengths unit) { super(value, unit, ELengthDims.RANGE);  }

    @Override public QRange of(double value, ELengths unit) { return new QRange(value, unit);  }

}

