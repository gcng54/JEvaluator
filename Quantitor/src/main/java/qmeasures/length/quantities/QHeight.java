package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengths;

/**
 * Concrete length quantity representing a distance.
 */
public final class QHeight extends ALengthDim<QHeight> {

    public QHeight(ALength<?> length) {        super(length, ELengthDims.HEIGHT);    }

    protected QHeight(double value) { super(value, ELengths.METER, ELengthDims.HEIGHT);  }

    public QHeight(double value, ELengths unit) { super(value, unit, ELengthDims.HEIGHT);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QHeight of(double value, ELengths unit) { return new QHeight(value, unit);  }

}
