package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public final class QRange extends ALength<QRange> {

    public QRange(Double value) { super(value, ELengths.METER, ELengthDims.RANGE);  }

    public QRange(Double value, ELengths unit) { super(value, unit, ELengthDims.RANGE);  }

    @Override public QRange of(Double value, ELengths unit) { return new QRange(value, unit);  }

}

