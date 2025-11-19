package qmeasures.core;

import java.util.Locale;
import java.util.Objects;


public interface IUnit<E extends IUnit<E>> {

    String getSymbol();

    double getFactor();
    
    IDimension<?> getBaseDimension();

    E getBaseUnit();


    // Override methods for base value conversions
    // Can be overridden for custom behavior as Temperature units

    default double toBaseValue(double value) {
        return value * getFactor();
    }

    default double fromBaseValue(double baseValue) {
        return baseValue / getFactor();
    }

    // Similar methods for RUnit conversions for custom behavior as Temperature units

	default double convertTo(double value, IUnit<E> targetUnit) {
        return targetUnit.fromBaseValue(this.toBaseValue(value));
	}

	default double convertFrom(double value, IUnit<E> sourceUnit) {
        return this.fromBaseValue(sourceUnit.toBaseValue(value));
	}

    default double convert(double value, IUnit<E> sourceUnit, IUnit<E> targetUnit) {
        return targetUnit.fromBaseValue(sourceUnit.toBaseValue(value));
    }

    // Common Default Methods

    default void validateFactor(double factor) {
            if (factor <= 0.0) {
            throw new IllegalArgumentException("Factor must be positive: " + factor);
        }
    }

	default boolean isBaseUnit() { return this.equals(this.getBaseUnit());}

    default String getClassName() { return this.getClass().getSimpleName();    }

    // E is compatable with E
    default boolean isCompatible(IUnit<?> other) {
        return other != null && getBaseDimension().isCompatible(other.getBaseDimension());
    }

    default boolean unitEquals(IUnit<?> other) {
        return other != null && Objects.equals(getClassName(), other.getClassName());
    }

    // Utility Functions
    public static String toSentenceCase(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		return input.substring(0, 1).toUpperCase(Locale.ENGLISH) +
				input.substring(1).toLowerCase(Locale.ENGLISH);
	}


}

