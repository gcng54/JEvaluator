package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public final class QAltitude extends ALengthDim<QAltitude> {

    public QAltitude(ALength<?> length) { super(length, ELengthDims.ALTITUDE); }

    protected QAltitude(double value) { super(value, ELengthUnit.METER, ELengthDims.ALTITUDE); }

    public QAltitude() { super(0.0, ELengthUnit.METER, ELengthDims.ALTITUDE); }

    public QAltitude(double value, ELengthUnit unit) {        super(value, unit, ELengthDims.ALTITUDE);    }

    @Contract("_, _ -> new")
    @Override public @NotNull QAltitude of(double value, ELengthUnit unit) {       return new QAltitude(value, unit);  }



}
