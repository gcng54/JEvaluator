package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QWaveLength extends ALengthDim<QWaveLength> {

    public QWaveLength(ALength<?> length) { super(length, ELengthDims.WAVE_LENGTH);  }

    public QWaveLength(double value) { super(value, ELengths.METER, ELengthDims.WAVE_LENGTH);  }

    public QWaveLength(double value, ELengths unit) { super(value, unit, ELengthDims.WAVE_LENGTH);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QWaveLength of(double value, ELengths unit) { return new QWaveLength(value, unit);  }

}
