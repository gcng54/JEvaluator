package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public final class QWaveLength extends ALengthDim<QWaveLength> {

    public QWaveLength(ALength<?> length) { super(length, ELengthDims.WAVE_LENGTH);  }

    public QWaveLength(double value) { super(value, ELengthUnit.METER, ELengthDims.WAVE_LENGTH);  }

    public QWaveLength(double value, ELengthUnit unit) { super(value, unit, ELengthDims.WAVE_LENGTH);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QWaveLength of(double value, ELengthUnit unit) { return new QWaveLength(value, unit);  }

}
