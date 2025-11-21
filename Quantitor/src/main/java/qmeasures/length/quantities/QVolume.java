package qmeasures.length.quantities;

import org.jetbrains.annotations.NotNull;
import qmeasures.length.units.ELengthUnit;

public class QVolume extends ALengthDim<QVolume> {

    public QVolume(ALength<?> length) { super(length, ELengthDims.VOLUME); }

    protected QVolume(double value) { super(value, ELengthUnit.METER, ELengthDims.VOLUME); }

    public QVolume(double value, ELengthUnit unit) {
        super(value, unit, ELengthDims.VOLUME);
    }

    @Override public QVolume of(double value, ELengthUnit unit) {
        return new QVolume(value, unit);
    }

    public String getUnitSymbol() {
        return this.getUnit().getSymbol()+ "^3";
    }

    public double toBaseValue(double value) {
        return value * Math.pow(getUnit().getFactor(), 3);
    }

    public double fromBaseValue(double baseValue) {
        return baseValue / Math.pow(getUnit().getFactor(), 3);
    }

    public QLength toLength() {
        if (this.getBaseValue() < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative Volume.");
        }
        double new_value = Math.cbrt(this.getValue());
        return new QLength(new_value, this.getUnit());
    }

    public QArea div(@NotNull ALength<?> divisor) {
        if (divisor.getBaseValue() == 0 || divisor == null) {
            throw new IllegalArgumentException("Division by zero or null is not allowed.");
        }
        double new_value = this.getUnit().fromBaseValue(this.getBaseValue() / divisor.getBaseValue());
        return new QArea(new_value, this.getUnit());
    }

    public QLength div(@NotNull QArea divisor) {
        if (divisor.getBaseValue() == 0 || divisor == null) {
            throw new IllegalArgumentException("Division by zero or null is not allowed.");
        }
        double new_value = this.getUnit().fromBaseValue(this.getBaseValue() / divisor.getBaseValue());
        return new QLength(new_value, this.getUnit());
    }

}