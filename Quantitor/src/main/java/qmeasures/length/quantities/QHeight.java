package qmeasures.length.quantities;

import qmeasures.length.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QHeight extends ALength<QHeight> {

    public QHeight(double value) { super(value, ELengths.METER, ELengthDims.HEIGHT);  }

    public QHeight(double value, ELengths unit) { super(value, unit, ELengthDims.HEIGHT);  }

    @Override public QHeight of(double value, ELengths unit) { return new QHeight(value, unit);  }

}

