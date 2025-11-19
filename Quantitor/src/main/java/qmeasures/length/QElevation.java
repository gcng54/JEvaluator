package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public final class QElevation extends ALength<QElevation> {

    public QElevation(Double value) { super(value, ELengths.METER, ELengthDims.ELEVATION);  }

    public QElevation(Double value, ELengths unit) { super(value, unit, ELengthDims.ELEVATION);  }

    @Override public QElevation of(Double value, ELengths unit) { return new QElevation(value, unit);  }

}

