package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public final class QHeight extends ALengthDim<QHeight> {

    public QHeight(ALength<?> length) {        super(length, ELengthDims.HEIGHT);    }

    protected QHeight(double value) { super(value, ELengthUnit.METER, ELengthDims.HEIGHT);  }

    public QHeight(double value, ELengthUnit unit) { super(value, unit, ELengthDims.HEIGHT);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QHeight of(double value, ELengthUnit unit) { return new QHeight(value, unit);  }

}
