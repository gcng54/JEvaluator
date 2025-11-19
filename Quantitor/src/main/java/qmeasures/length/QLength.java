package qmeasures.length;

/**
 * Concrete length quantity representing a distance.
 */
public class QLength extends ALength<QLength> {

    public QLength(Double value) {
        super(value, ELengths.METER, ELengthDims.LENGTH);
    }

    public QLength(Double value, ELengths unit) {
        super(value, unit, ELengthDims.LENGTH);
    }

    @Override public QLength of(Double value, ELengths unit) {
        return new QLength(value, unit);
    }


}

