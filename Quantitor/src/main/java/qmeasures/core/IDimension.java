
package qmeasures.core;

/**
 * Interface for dimension enums (e.g., LENGTH, TIME, TEMPERATURE).
 * Defines valid operational ranges and compatibility logic.
 *
 * @param <E> the dimension enum type
 */
public interface IDimension<E extends IDimension<E>> extends Clampable {

    /**
     * Gets the abbreviation for this dimension (e.g., "L", "T").
     * @return the abbreviation
     */
    String getAbbreviation();

    /**
     * Gets the base dimension for this dimension.
     * @return the base dimension
     */
    E getBaseDimension();

    /**
     * Gets the base unit for this dimension.
     * @return the base unit
     */
    IUnit<?> getBaseUnit();

    /**
     * Gets the class name of this dimension.
     * @return the class name
     */
    default String getClassName() { return this.getClass().getSimpleName();    }

    /**
     * Returns true if this dimension is compatible with another (same base dimension).
     * @param other the other dimension
     * @return true if compatible
     */
    default boolean isCompatible(IDimension<?> other) {
        if (other == null) return false;
        E a = getBaseDimension();
        @SuppressWarnings("unchecked")
        E b = (E) other.getBaseDimension();
        return a != null && a.equals(b);
    }

}
