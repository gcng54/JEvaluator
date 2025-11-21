package qmeasures.length.quantities;

import qmeasures.length.units.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QAltitude extends ALengthDim<QAltitude> {

    public QAltitude(ALength<?> length) {        super(length, ELengthDims.ALTITUDE);    }

    protected QAltitude(double value) {        super(value, ELengths.METER, ELengthDims.ALTITUDE);    }

    public QAltitude(double value, ELengths unit) {        super(value, unit, ELengthDims.ALTITUDE);    }

    @Override public QAltitude of(double value, ELengths unit) {       return new QAltitude(value, unit);  }



}
