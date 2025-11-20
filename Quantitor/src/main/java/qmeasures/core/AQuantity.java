
package qmeasures.core;

import java.util.Objects;

/**
 * Abstract base class for all quantity types (e.g., length, time, temperature).
 * Provides core logic for value storage, clamping, unit/dimension access, and arithmetic operations.
 *
 * @param <Q> the concrete quantity type
 * @param <U> the unit enum type
 * @param <E> the dimension enum type
 */
public abstract class AQuantity<Q extends AQuantity<Q, U, E>, U extends IUnit<U>, E extends IDimension<E>> implements IQuantity<Q, U, E> {
    /** The value in base units (e.g., meters, seconds). */
    protected final double baseValue;
    /** The unit of this quantity. */
    protected final U unit;
    /** The dimension of this quantity. */
    protected final E dimension;
    /** True if the value was clamped to the valid range. */
    protected final boolean clamped;

    /**
     * Gets the value in base units.
     * @return the base value
     */
    @Override public double getBaseValue() { return baseValue; }

    /**
     * Gets the unit of this quantity.
     * @return the unit
     */
    @Override public U getUnit() { return unit; }
    
    /**
     * Gets the dimension of this quantity.
     * @return the dimension
     */
    @Override public E getDimension() { return dimension; }

    /**
     * Creates a new instance of this quantity type with the given value and unit.
     * @param value the value
     * @param unit the unit
     * @return a new instance of Q
     */
    @Override public abstract Q of(Double value, U unit);

    /**
     * Constructs a quantity with the specified value, unit, and dimension.
     * Value is clamped according to the dimension's rules.
     * @param value the value
     * @param unit the unit
     * @param dimension the dimension
     */
    protected AQuantity(Double value, U unit, E dimension) {
        if (unit == null) throw new IllegalArgumentException("unit is null");
        if (dimension == null) throw new IllegalArgumentException("dimension is null");
        this.dimension = dimension;
        this.unit = unit;
        // Base value is always clamped according to dimension rules
        double unclampedBaseValue = unit.toBaseValue(value);
        double clampedBaseValue = dimension.clampBaseValue(unclampedBaseValue);
        this.clamped = clampedBaseValue != unclampedBaseValue;
        this.baseValue = clampedBaseValue;
    }

    /**
     * Gets the value in the current unit.
     * @return the value
     */
    @Override public Double getValue() { return unit.fromBaseValue(baseValue); }

    /**
     * Returns true if the value was clamped.
     * @return true if clamped
     */
    @Override  public boolean wasClamped() { return clamped; }
    
    /**
     * Clones this quantity (same value and unit).
     * @return a new instance of Q
     */
    public Q cloneQuantity() { return of(this.getValue(), this.getUnit());  }

    /**
     * Returns a string representation (value and unit symbol).
     * @return the string
     */
    @Override public String toString() { return getValue() + " " + getUnitSymbol(); }

    /**
     * Computes the hash code for this quantity.
     * @return the hash code
     */
    @Override public int hashCode() {  return Objects.hash(getDimension(), getBaseValue());  }

    /**
     * Compares this quantity for equality with another object.
     * @param other the other object
     * @return true if equal
     */
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

    /**
     * Compares this quantity to another for ordering.
     * @param other the other quantity
     * @return comparison result
     */
    @Override public int compareTo(@SuppressWarnings("rawtypes") AQuantity other) {
        double thisBaseValue = this.getUnit().toBaseValue(this.getValue());
        double otherBaseValue = other.getUnit().toBaseValue(other.getValue());
        return Double.compare(thisBaseValue, otherBaseValue);
    }

    // Logical methods

    /**
     * Returns true if this quantity is less than the other.
     */
    public boolean less(AQuantity<?, ?, E> other) { return this.compareTo(other) < 0; }
    /**
     * Returns true if this quantity is less than or equal to the other.
     */
    public boolean lessOrEqual(AQuantity<?, ?, E> other) { return this.compareTo(other) <= 0; }
    /**
     * Returns true if this quantity is greater than the other.
     */
    public boolean greater(AQuantity<?, ?, E> other) { return this.compareTo(other) > 0; }
    /**
     * Returns true if this quantity is greater than or equal to the other.
     */
    public boolean greaterOrEqual(AQuantity<?, ?, E> other) { return this.compareTo(other) >= 0; }
    /**
     * Returns true if this quantity is equal to the other (by value).
     */
    public boolean equalsTo(AQuantity<?, ?, E> other) { return this.compareTo(other) == 0; }

    // Arithmetic methods

    /** Adds a value to this quantity. */
    public Q add(Double value) { return of(this.getValue() + value, this.getUnit());  }
    /** Subtracts a value from this quantity. */
    public Q sub(Double value) {  return of(this.getValue() - value, this.getUnit());  }
    /** Reverse subtracts this value from another. */
    public Q rsub(Double value) {  return of(value - this.getValue(), this.getUnit());  }
    /** Multiplies this quantity by a scalar. */
    public Q mul(double k) { return of(this.getValue() * k, this.getUnit()); }
    /** Divides this quantity by a scalar. */
    public Q div(double k) { return of(this.getValue() / k, this.getUnit()); }
    /** Raises this quantity to a power. */
    public Q pow(double exponent) { return of(Math.pow(this.getValue(), exponent), this.getUnit()); }
    /** Takes the square root of this quantity. */
    public Q sqrt() { return of(Math.sqrt(this.getValue()), this.getUnit()); }
    /** Floors the value of this quantity. */
    public Q floor() { return of(Math.floor(this.getValue()), this.getUnit()); }
    /** Ceils the value of this quantity. */
    public Q ceil() { return of(Math.ceil(this.getValue()), this.getUnit()); }
    /** Returns the absolute value of this quantity. */
    public Q abs() { return of(Math.abs(this.getValue()));  }
    /** Inverts the sign of this quantity. */
    public Q invert() { return of(-this.getValue()); }
    /** Adds another quantity (same dimension). */
    public Q add(AQuantity<?, ?, E> other) {return of(this.getUnit().fromBaseValue(this.getBaseValue() + other.getBaseValue()));   }
    /** Subtracts another quantity (same dimension). */
    public Q sub(AQuantity<?, ?, E> other) { return of(this.getUnit().fromBaseValue(this.getBaseValue() - other.getBaseValue()));   }
    /** Reverse subtracts another quantity (same dimension). */
    public Q rsub(AQuantity<?, ?, E> other) {   return of(this.getUnit().fromBaseValue(other.getBaseValue() - this.getBaseValue()));    }
    /** Divides this quantity by another (same dimension). */
    public double div(AQuantity<?, ?, E> other) {  return this.getBaseValue() / other.getBaseValue();   }
    /** Returns the ratio of this quantity to another (same dimension). */
    public double ratio(AQuantity<?, ?, E> other) {  return this.getBaseValue() / other.getBaseValue();   }

    // Check BaseValue Methods

    /** Returns true if the value is exactly zero. */
    public boolean isEqualToZero() { return getValue() == 0.0;}
    /** Returns true if the value is close to zero (with epsilon). */
    public boolean isCloseToZero(double epsilon) {  return Math.abs(this.getBaseValue()) < epsilon;  }
    /** Returns true if the value is close to zero (default epsilon). */
    public boolean isCloseToZero() {  return Math.abs(this.getBaseValue()) < 1E-12;  }
    /** Returns true if the value is positive. */
    public boolean isPositive() { return this.getBaseValue() > 0.0; }
    /** Returns true if the value is negative. */
    public boolean isNegative() { return this.getBaseValue() < 0.0; }
    /** Returns true if the value is positive or zero. */
    public boolean isPositiveOrZero() { return this.getBaseValue() >= 0.0; }
    /** Returns true if the value is negative or zero. */
    public boolean isNegativeOrZero() { return this.getBaseValue() <= 0.0; }

    /**
     * Returns the logarithm of this value in the given base.
     * @param base the base
     * @return a new quantity with the log value
     */
    public Q logBase(double base) {
        double magnitude = this.getValue();
        if (magnitude <= 0 || base <= 0)
            throw new IllegalArgumentException("Cannot calculate logarithm for non-positive magnitude" + magnitude + ", base: " + base);
        double newMagnitude = Math.log(magnitude) / Math.log(base);
        return of(newMagnitude);
    }

}
