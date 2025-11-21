package qmeasures.length.quantities;

import qmeasures.length.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QElevation extends ALength<QElevation> {

    public QElevation(double value) { super(value, ELengths.METER, ELengthDims.ELEVATION);  }

    public QElevation(double value, ELengths unit) { super(value, unit, ELengthDims.ELEVATION);  }

    @Override public QElevation of(double value, ELengths unit) { return new QElevation(value, unit);  }

}

