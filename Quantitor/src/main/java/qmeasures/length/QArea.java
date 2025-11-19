package qmeasures.length;

public class QArea extends ALength<QArea> {

    public QArea(Double value, ELengths unit) {
        super(value, unit, ELengthDims.AREA);
    }

    public QArea(Double value) {
        super(value, ELengths.METER, ELengthDims.AREA);
    }

    @Override public QArea of(Double value, ELengths unit) {
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

    public QLength div (ALength<?> divisor) {
        if (divisor.getBaseValue() == 0 || divisor == null) {
            throw new IllegalArgumentException("Division by zero or null is not allowed.");
        }
        double new_value = this.getUnit().fromBaseValue(this.getBaseValue() / divisor.getBaseValue());
        return new QLength(new_value, this.getUnit());
    }



}