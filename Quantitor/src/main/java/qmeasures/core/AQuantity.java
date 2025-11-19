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
        this.baseValue = dimension.getBaseValueClamped(unit.toBaseValue(value));
    }

    public Q cloneQuantity() { return of(this.getValue(), this.getUnit());  }

    @Override public String toString() { return getValue() + " " + getUnitSymbol(); }

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

    // Logical methods

    public boolean less(AQuantity<?, ?, E> other) { return this.compareTo(other) < 0; }

    public boolean lessOrEqual(AQuantity<?, ?, E> other) { return this.compareTo(other) <= 0; }

    public boolean greater(AQuantity<?, ?, E> other) { return this.compareTo(other) > 0; }

    public boolean greaterOrEqual(AQuantity<?, ?, E> other) { return this.compareTo(other) >= 0; }

    public boolean equalsTo(AQuantity<?, ?, E> other) { return this.compareTo(other) == 0; }

    // Arithmetic methods

    public Q add(Double value) { return of(this.getValue() + value, this.getUnit());  }

    public Q sub(Double value) {  return of(this.getValue() - value, this.getUnit());  }
    
    public Q rsub(Double value) {  return of(value - this.getValue(), this.getUnit());  }

    public Q mul(double k) { return of(this.getValue() * k, this.getUnit()); }

    public Q div(double k) { return of(this.getValue() / k, this.getUnit()); }

    public Q pow(double exponent) { return of(Math.pow(this.getValue(), exponent), this.getUnit()); }

    public Q sqrt() { return of(Math.sqrt(this.getValue()), this.getUnit()); }

    public Q floor() { return of(Math.floor(this.getValue()), this.getUnit()); }

    public Q ceil() { return of(Math.ceil(this.getValue()), this.getUnit()); }

    public Q abs() { return of(Math.abs(this.getValue()));  }

    public Q invert() { return of(-this.getValue()); }

    public Q add(AQuantity<?, ?, E> other) {
        double sumBase = this.getBaseValue() + other.getBaseValue();
        double val = this.getUnit().fromBaseValue(sumBase);
        return of(val);
    }
    
    public Q sub(AQuantity<?, ?, E> other) {
        double diffBase = this.getBaseValue() - other.getBaseValue();
        double val = this.getUnit().fromBaseValue(diffBase);
        return of(val);
    }

    public Q rsub(AQuantity<?, ?, E> other) {
        double diffBase = other.getBaseValue() - this.getBaseValue();
        double val = this.getUnit().fromBaseValue(diffBase);
        return of(val);
    }

    public double ratio(AQuantity<?, ?, E> other) {
        return this.getBaseValue() / other.getBaseValue();
    }

  	// Check BaseValue Methods

    public boolean isEqualToZero() { return getValue() == 0.0;}

    public boolean isCloseToZero(double epsilon) {  return Math.abs(this.getBaseValue()) < epsilon;  }

    public boolean isCloseToZero() {  return Math.abs(this.getBaseValue()) < 1E-12;  }

	public boolean isPositive() { return this.getBaseValue() > 0.0;	}

	public boolean isNegative() { return this.getBaseValue() < 0.0; }

	public boolean isPositiveOrZero() { return this.getBaseValue() >= 0.0; }
	
    public boolean isNegativeOrZero() { return this.getBaseValue() <= 0.0; }

    public Q logBase(double base) {
        double magnitude = this.getValue();
        if (magnitude <= 0 || base <= 0)
            throw new IllegalArgumentException("Cannot calculate logarithm for non-positive magnitude" + magnitude + ", base: " + base);
        double newMagnitude = Math.log(magnitude) / Math.log(base);
        return of(newMagnitude);
    }

}
