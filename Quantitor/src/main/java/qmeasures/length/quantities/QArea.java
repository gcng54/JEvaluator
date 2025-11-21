package qmeasures.length.quantities;

import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

public class QArea extends ALengthDim<QArea> {

    public QArea(ALength<?> length) { super(length, ELengthDims.AREA); }

    protected QArea(double value) { super(value, ELengthUnit.METER, ELengthDims.AREA); }
    
    public QArea(double value, ELengthUnit unit) { super(value, unit, ELengthDims.AREA);  }

    @Override public QArea of(double value, ELengthUnit unit) {
        return new QArea(value, unit);
    }

    public String getUnitSymbol() {
        return this.getUnit().getSymbol()+ "^2";
    }

    public double toBaseValue(double value) {
        return value * Math.pow(getUnit().getFactor(), 2);
    }

    public double fromBaseValue(double baseValue) {
        return baseValue / Math.pow(getUnit().getFactor(), 2);
    }

    public QLength toLength() {
        if (this.getBaseValue() < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative area.");
        }
        double new_value = Math.sqrt(this.getValue());
        return new QLength(new_value, this.getUnit());
    }

    public QLength div (@NotNull ALength<?> divisor) {
        if (divisor.getBaseValue() == 0 ) {
            throw new IllegalArgumentException("Division by zero or null is not allowed.");
        }
        double new_value = this.getUnit().fromBaseValue(this.getBaseValue() / divisor.getBaseValue());
        return new QLength(new_value, this.getUnit());
    }



}