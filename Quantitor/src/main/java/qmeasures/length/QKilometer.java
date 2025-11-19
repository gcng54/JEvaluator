package qmeasures.length;

public class QKilometer extends ALength<QKilometer> {

    public QKilometer(Double value) {
        super(value, ELengths.KILOMETER, ELengthDims.LENGTH);
    }

    @Override
    public QKilometer of(Double value, ELengths dummy) {
        return new QKilometer(value);
    }

}