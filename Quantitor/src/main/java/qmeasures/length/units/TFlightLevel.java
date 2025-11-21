package qmeasures.length.units;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ELengthDims;

public class TFlightLevel extends ALength<TFlightLevel> {

    public TFlightLevel(double value) { super(value, ELengthUnit.FLIGHTLEVEL, ELengthDims.LENGTH); }

    @Override public TFlightLevel of(double value, ELengthUnit dummy) { return new TFlightLevel(value); }

}