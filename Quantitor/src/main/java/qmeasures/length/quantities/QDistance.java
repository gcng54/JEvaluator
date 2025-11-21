package qmeasures.length.quantities;

import qmeasures.length.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QDistance extends ALength<QDistance> {

    public QDistance(double value) { super(value, ELengths.METER, ELengthDims.DISTANCE);  }

    public QDistance(double value, ELengths unit) { super(value, unit, ELengthDims.DISTANCE);  }

    @Override public QDistance of(double value, ELengths unit) { return new QDistance(value, unit);  }

}

