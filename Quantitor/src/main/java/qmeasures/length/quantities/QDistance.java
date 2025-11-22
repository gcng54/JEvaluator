package qmeasures.length.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

/**
 * Concrete length quantity representing a distance.
 */
public final class QDistance extends ALengthDim<QDistance> {

    public QDistance(){
        super(0.0, ELengthUnit.METER, ELengthDims.DISTANCE);
    }
    
    public QDistance(ALength<?> length) { super(length, ELengthDims.DISTANCE); }

    public QDistance(double value) { super(value, ELengthUnit.METER, ELengthDims.DISTANCE);  }

    public QDistance(double value, ELengthUnit unit) { super(value, unit, ELengthDims.DISTANCE);  }

    @Contract("_, _ -> new")
    @Override public @NotNull QDistance of(double value, ELengthUnit unit) { return new QDistance(value, unit);  }

}
