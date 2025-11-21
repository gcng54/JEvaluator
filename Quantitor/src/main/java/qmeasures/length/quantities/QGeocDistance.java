package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public final class QGeocDistance extends ALengthDim<QGeocDistance> {

    public QGeocDistance(ALength<?> length) { super(length, ELengthDims.GEOC_DISTANCE); }

    public QGeocDistance(double value) { super(value, ELengthUnit.METER, ELengthDims.GEOC_DISTANCE);  }

    public QGeocDistance() { super(0.0, ELengthUnit.METER, ELengthDims.GEOC_DISTANCE); }

    public QGeocDistance(double value, ELengthUnit unit) { super(value, unit, ELengthDims.GEOC_DISTANCE);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QGeocDistance of(double value, ELengthUnit unit) { return new QGeocDistance(value, unit);  }
}
