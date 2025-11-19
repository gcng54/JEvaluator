package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public final class QHeight extends ALength<QHeight> {

    public QHeight(Double value) { super(value, ELengths.METER, ELengthDims.HEIGHT);  }

    public QHeight(Double value, ELengths unit) { super(value, unit, ELengthDims.HEIGHT);  }

    @Override public QHeight of(Double value, ELengths unit) { return new QHeight(value, unit);  }

}

