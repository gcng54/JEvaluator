package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public final class QEarthecric extends ALength<QEarthecric> {

    public QEarthecric(Double value) { super(value, ELengths.METER, ELengthDims.EARTHECTIC);  }

    public QEarthecric(Double value, ELengths unit) { super(value, unit, ELengthDims.EARTHECTIC);  }

    @Override public QEarthecric of(Double value, ELengths unit) { return new QEarthecric(value, unit);  }

}

