package qmeasures.length.quantities;

import qmeasures.length.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QEarthRadius extends ALengthDim<QEarthRadius> {

    public QEarthRadius(ALength<?> length) {
        super(length, ELengthDims.EARTH_RADIUS);
    }

    public QEarthRadius(double value) { super(value, ELengths.METER, ELengthDims.EARTH_RADIUS);  }

    public QEarthRadius(double value, ELengths unit) { super(value, unit, ELengthDims.EARTH_RADIUS);  }

    @Override public QEarthRadius of(double value, ELengths unit) { return new QEarthRadius(value, unit);  }

}
