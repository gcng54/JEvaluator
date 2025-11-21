package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public final class QRakim extends ALengthDim<QRakim> {

    public QRakim(ALength<?> length) {  super(length, ELengthDims.RAKIM);  }

    public QRakim(double value) { super(value, ELengthUnit.METER, ELengthDims.RAKIM);  }

    public QRakim(double value, ELengthUnit unit) { super(value, unit, ELengthDims.RAKIM);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QRakim of(double value, ELengthUnit unit) { return new QRakim(value, unit);  }

}
