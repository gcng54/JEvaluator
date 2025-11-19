package qmeasures.length;


/**
 * Concrete length quantity representing a distance.
 */
public final class QAltitude extends ALength<QAltitude> {

    public QAltitude(double value) {
        super(value, ELengths.METER, ELengthDims.ALTITUDE);
    }

    public QAltitude(double value, ELengths unit) {
        super(value, unit, ELengthDims.ALTITUDE);
    }

    @Override
    public QAltitude of(double value, ELengths unit) {
        return new QAltitude(value, unit);
    }



}

