package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public final class QEarthecric extends ALength<QEarthecric> {

    public QEarthecric(double value) { super(value, ELengths.METER, ELengthDims.EARTHECTIC);  }

    public QEarthecric(double value, ELengths unit) { super(value, unit, ELengthDims.EARTHECTIC);  }

    @Override public QEarthecric of(double value, ELengths unit) { return new QEarthecric(value, unit);  }

}

