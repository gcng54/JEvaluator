package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public final class QWaveLength extends ALength<QWaveLength> {

    public QWaveLength(Double value) { super(value, ELengths.METER, ELengthDims.DISTANCE);  }

    public QWaveLength(Double value, ELengths unit) { super(value, unit, ELengthDims.DISTANCE);  }

    @Override public QWaveLength of(Double value, ELengths unit) { return new QWaveLength(value, unit);  }

}

