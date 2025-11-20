package qmeasures.length;

public class QKilometer extends ALength<QKilometer> {

    public QKilometer(double value) {
        super(value, ELengths.KILOMETER, ELengthDims.LENGTH);
    }

    @Override
    public QKilometer of(double value, ELengths dummy) {
        return new QKilometer(value);
    }

}