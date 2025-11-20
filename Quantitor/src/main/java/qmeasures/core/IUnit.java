
package qmeasures.core;

import java.util.Locale;
import java.util.Objects;

/**
 * Interface for unit enums (e.g., meters, seconds, kelvin).
 * Provides methods for symbol, conversion, and compatibility.
 *
 * @param <E> the unit enum type
 */
public interface IUnit<E extends IUnit<E>> {

    /**
     * Gets the symbol for this unit (e.g., "m", "s").
     * @return the unit symbol
     */
    String getSymbol();

    /**
     * Gets the conversion factor to the base unit.
     * @return the factor
     */
    double getFactor();
    
    /**
     * Gets the base dimension for this unit.
     * @return the base dimension
     */
    IDimension<?> getBaseDimension();

    /**
     * Gets the base unit for this unit.
     * @return the base unit
     */
    E getBaseUnit();

    /**
     * Converts a value in this unit to the base unit value.
     * @param value the value in this unit
     * @return the value in base units
     */
    default double toBaseValue(double value) {
        return value * getFactor();
    }

    /**
     * Converts a value from the base unit to this unit.
     * @param baseValue the value in base units
     * @return the value in this unit
     */
    default double fromBaseValue(double baseValue) {
        return baseValue / getFactor();
    }

    /**
     * Converts a value from this unit to a target unit.
     * @param value the value in this unit
     * @param targetUnit the target unit
     * @return the value in the target unit
     */
	default double convertTo(double value, IUnit<E> targetUnit) {
        return targetUnit.fromBaseValue(this.toBaseValue(value));
	}

    /**
     * Converts a value from a source unit to this unit.
     * @param value the value in the source unit
     * @param sourceUnit the source unit
     * @return the value in this unit
     */
	default double convertFrom(double value, IUnit<E> sourceUnit) {
        return this.fromBaseValue(sourceUnit.toBaseValue(value));
	}

    /**
     * Converts a value from a source unit to a target unit.
     * @param value the value in the source unit
     * @param sourceUnit the source unit
     * @param targetUnit the target unit
     * @return the value in the target unit
     */
    default double convert(double value, IUnit<E> sourceUnit, IUnit<E> targetUnit) {
        return targetUnit.fromBaseValue(sourceUnit.toBaseValue(value));
    }

    /**
     * Validates that the factor is positive.
     * @param factor the factor
     */
    default void validateFactor(double factor) {
        if (factor <= 0.0) {
            throw new IllegalArgumentException("Factor must be positive: " + factor);
        }
    }

    /**
     * Returns true if this is the base unit.
     * @return true if base unit
     */
	default boolean isBaseUnit() { return this.equals(this.getBaseUnit());}

    /**
     * Gets the class name of this unit.
     * @return the class name
     */
    default String getClassName() { return this.getClass().getSimpleName();    }

    /**
     * Returns true if this unit is compatible with another (same dimension).
     * @param other the other unit
     * @return true if compatible
     */
    default boolean isCompatible(IUnit<?> other) {
        return other != null && getBaseDimension().isCompatible(other.getBaseDimension());
    }

    /**
     * Returns true if this unit is the same type as another.
     * @param other the other unit
     * @return true if same type
     */
    default boolean unitEquals(IUnit<?> other) {
        return other != null && Objects.equals(getClassName(), other.getClassName());
    }

    /**
     * Utility function to convert a string to sentence case.
     * @param input the input string
     * @return the string in sentence case
     */
    public static String toSentenceCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase(Locale.ENGLISH) +
                input.substring(1).toLowerCase(Locale.ENGLISH);
    }

}

