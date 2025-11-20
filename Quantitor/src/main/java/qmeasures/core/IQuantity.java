
package qmeasures.core;

/**
 * Interface for quantity types (e.g., length, time, temperature).
 * Provides methods for value, unit, dimension, and conversions.
 *
 * @param <Q> the quantity type
 * @param <U> the unit type
 * @param <E> the dimension type
 */
public interface IQuantity<Q extends IQuantity<Q, U, E>, U extends IUnit<?>, E extends IDimension<?>> extends Comparable<Q> {

    /**
     * Gets the value in base units.
     * @return the base value
     */
    double getBaseValue();

    /**
     * Gets the unit of this quantity.
     * @return the unit
     */
    U getUnit() ;

    /**
     * Gets the dimension of this quantity.
     * @return the dimension
     */
    E getDimension() ;

    /**
     * Creates a new instance of this quantity type with the given value and unit.
     * @param value the value
     * @param unit the unit
     * @return a new instance of Q
     */
    Q of(double value, U unit);

    /**
     * Creates a new instance of this quantity type with the given value and current unit.
     * @param value the value
     * @return a new instance of Q
     */
    default Q of(double value){ return this.of(value, getUnit()); }

    /**
     * Creates a new instance of this quantity type with the value converted from the given unit.
     * @param unit the unit
     * @return a new instance of Q
     */
	default Q of(U unit) {  return of(unit.fromBaseValue(getBaseValue()), unit);   }

    /**
     * Gets the value in the specified unit.
     * @param unit the unit
     * @return the value in the unit
     */
    default double inUnit(U unit) { return unit.fromBaseValue(getBaseValue()); }
    
    /**
     * Gets the value in the current unit.
     * @return the value
     */
    default double getValue() { return getUnit().fromBaseValue(getBaseValue()); }

    /**
     * Gets the name of the unit.
     * @return the unit name
     */
    default String getUnitName() { return getUnit().getClassName(); }
    
    /**
     * Returns true if the value was clamped.
     * @return true if clamped
     */
    default boolean wasClamped() { return false; }

    /**
     * Gets the symbol of the unit.
     * @return the unit symbol
     */
    default String getUnitSymbol() { return getUnit().getSymbol(); }

    /**
     * Gets the name of the dimension.
     * @return the dimension name
     */
    default String getDimName() { return getDimension().getClassName(); }

    /**
     * Gets the abbreviation of the dimension.
     * @return the dimension abbreviation
     */
    default String getDimAbbreviation() { return getDimension().getAbbrevation(); }

    /**
     * Returns true if the value is the maximum for the dimension.
     * @return true if max
     */
    default  boolean isMaxBaseValue() { return getDimension().isEqualToMaxBase(getBaseValue());  }

    /**
     * Returns true if the value is the minimum for the dimension.
     * @return true if min
     */
    default  boolean isMinBaseValue() { return getDimension().isEqualToMinBase(getBaseValue());  }

}
