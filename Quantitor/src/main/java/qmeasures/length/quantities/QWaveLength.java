package qmeasures.length.quantities;

import qmeasures.length.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QWaveLength extends ALength<QWaveLength> {

    public QWaveLength(double value) { super(value, ELengths.METER, ELengthDims.DISTANCE);  }

    public QWaveLength(double value, ELengths unit) { super(value, unit, ELengthDims.DISTANCE);  }

    @Override public QWaveLength of(double value, ELengths unit) { return new QWaveLength(value, unit);  }

}

