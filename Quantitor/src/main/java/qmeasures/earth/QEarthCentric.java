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
public final class QEarthCentric extends ALengthDim<QEarthCentric> {

    public QEarthCentric(ALength<?> length) { super(length, ELengthDims.EARTH_CENTRIC); }

    public QEarthCentric(double value) { super(value, ELengthUnit.METER, ELengthDims.EARTH_CENTRIC);  }

    public QEarthCentric() { super(0.0, ELengthUnit.METER, ELengthDims.EARTH_CENTRIC); }
    
    public QEarthCentric(double value, ELengthUnit unit) { super(value, unit, ELengthDims.EARTH_CENTRIC);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QEarthCentric of(double value, ELengthUnit unit) { return new QEarthCentric(value, unit);  }
}
