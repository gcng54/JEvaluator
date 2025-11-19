package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public final class QDistance extends ALength<QDistance> {

    public QDistance(Double value) { super(value, ELengths.METER, ELengthDims.DISTANCE);  }

    public QDistance(Double value, ELengths unit) { super(value, unit, ELengthDims.DISTANCE);  }

    @Override public QDistance of(Double value, ELengths unit) { return new QDistance(value, unit);  }

}

