package qmeasures.length.quantities;

import qmeasures.length.units.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QRakim extends ALengthDim<QRakim> {

    public QRakim(ALength<?> length) {  super(length, ELengthDims.RAKIM);  }

    public QRakim(double value) { super(value, ELengths.METER, ELengthDims.RAKIM);  }

    public QRakim(double value, ELengths unit) { super(value, unit, ELengthDims.RAKIM);  }

    @Override public QRakim of(double value, ELengths unit) { return new QRakim(value, unit);  }

}
