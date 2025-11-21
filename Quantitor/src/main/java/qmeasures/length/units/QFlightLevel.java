package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class QFlightLevel extends ALength<QFlightLevel> {

    public QFlightLevel(double value) { super(value, ELengths.FLIGHTLEVEL, ELengthDims.LENGTH); }

    @Override public QFlightLevel of(double value, ELengths dummy) { return new QFlightLevel(value); }

}