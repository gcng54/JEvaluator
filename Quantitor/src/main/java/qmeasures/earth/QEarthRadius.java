package qmeasures.earth;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import qmeasures.length.quantities.ALength;
import qmeasures.length.quantities.ALengthDim;
import qmeasures.length.quantities.ELengthDims;
import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public final class QEarthRadius extends ALengthDim<QEarthRadius> {

    public QEarthRadius(ALength<?> length) { super(length, ELengthDims.EARTH_RADIUS); }

    protected QEarthRadius(double value) { super(value, ELengthUnit.METER, ELengthDims.EARTH_RADIUS);  }

    public QEarthRadius(double value, ELengthUnit unit) { super(value, unit, ELengthDims.EARTH_RADIUS);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QEarthRadius of(double value, ELengthUnit unit) { return new QEarthRadius(value, unit);  }

}
