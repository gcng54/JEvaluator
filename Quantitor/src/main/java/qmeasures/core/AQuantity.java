package qmeasures.core;

import java.util.Objects;

public abstract class AQuantity<Q extends AQuantity<Q, U, E>, U extends IUnit<U>, E extends IDimension<E>> implements IQuantity<Q, U, E> {
    
    protected final double baseValue;

    protected final U unit;

    protected final E dimension;

    @Override public double getBaseValue() { return baseValue; }

    @Override public U getUnit() { return unit; }
    
    @Override public E getDimension() { return dimension; }

    @Override public abstract Q of(Double value, U unit);

    protected AQuantity(Double value, U unit, E dimension) {
        if (unit == null) throw new IllegalArgumentException("unit is null");
        if (dimension == null) throw new IllegalArgumentException("dimension is null");
        this.dimension = dimension;
        this.unit = unit;
        this.baseValue = dimension.getBoundedBaseValue(unit.toBaseValue(value));
    }
    
    public Q to(U targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("targetUnit is null");
        double base = this.getUnit().toBaseValue(this.getValue());
        double converted = targetUnit.fromBaseValue(base);
        return of(converted, targetUnit);
    }

    public Q cloneQuantity() { return of(this.getValue(), this.getUnit());  }

    @Override public String toString() { return getValue() + " " + getSymbol(); }

    @Override public int hashCode() {  return Objects.hash(getDimension(), getBaseValue());  }

    @Override public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof AQuantity)) return false;
        @SuppressWarnings("unchecked")
        AQuantity<?, ?, E> otherQuantity = (AQuantity<?, ?, E>) other;
        if (!getDimension().isCompatible(otherQuantity.getDimension())) return false;
        // Compare base values for equality.
        return Double.compare(this.getBaseValue(), otherQuantity.getBaseValue()) == 0;
    }

    @Override public int compareTo(@SuppressWarnings("rawtypes") AQuantity other) {
        double thisBaseValue = this.getUnit().toBaseValue(this.getValue());
        double otherBaseValue = other.getUnit().toBaseValue(other.getValue());
        return Double.compare(thisBaseValue, otherBaseValue);
    }

    public Q add(AQuantity<?, ?, E> other) {
        double sumBase = this.getBaseValue() + other.getBaseValue();
        double val = this.getUnit().fromBaseValue(sumBase);
        return of(val, this.getUnit());
    }

    public Q sub(AQuantity<?, ?, E> other) {
        double diffBase = this.getBaseValue() - other.getBaseValue();
        double val = this.getUnit().fromBaseValue(diffBase);
        return of(val, this.getUnit());
    }

    public Q mul(double k) { return of(this.getValue() * k, this.getUnit()); }

    public Q div(double k) { return of(this.getValue() / k, this.getUnit()); }

    public boolean less(AQuantity<?, ?, E> other) { return this.compareTo(other) < 0; }

    public boolean lessOrEqual(AQuantity<?, ?, E> other) { return this.compareTo(other) <= 0; }

    public boolean greater(AQuantity<?, ?, E> other) { return this.compareTo(other) > 0; }

    public boolean greaterOrEqual(AQuantity<?, ?, E> other) { return this.compareTo(other) >= 0; }

    public boolean equalsTo(AQuantity<?, ?, E> other) { return this.compareTo(other) == 0; }

    public boolean isZero() { return getValue() == 0.0;}

    public Q abs() { return of(Math.abs(this.getValue()), this.getUnit());  }

    public Q invert() { return of(-this.getValue(), this.getUnit()); }

}
