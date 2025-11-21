package qmeasures.pressure.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import qmeasures.pressure.units.EPressureUnit;

public class QPressure extends APressureDim<QPressure> {

    public QPressure(APressure<?> length) { super(length, EPressureDims.PRESSURE); }

    protected QPressure(double value) { super(value, EPressureUnit.PASCAL, EPressureDims.PRESSURE); }

    public QPressure(double value, EPressureUnit unit) {        super(value, unit, EPressureDims.PRESSURE);    }
    
    @Contract("_, _ -> new")
    @Override public @NotNull QPressure of(double value, EPressureUnit unit) {       return new QPressure(value, unit);  }


}