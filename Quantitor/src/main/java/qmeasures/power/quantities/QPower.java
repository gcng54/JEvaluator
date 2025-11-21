package qmeasures.power.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import qmeasures.power.units.EPowerUnit;

public class QPower extends APowerDim<QPower> {

    public QPower(APower<?> length) { super(length, EPowerDims.POWER); }

    protected QPower(double value) { super(value, EPowerUnit.WATT, EPowerDims.POWER); }

    public QPower(double value, EPowerUnit unit) {        super(value, unit, EPowerDims.POWER);    }
    
    @Contract("_, _ -> new")
    @Override public @NotNull QPower of(double value, EPowerUnit unit) {       return new QPower(value, unit);  }



}