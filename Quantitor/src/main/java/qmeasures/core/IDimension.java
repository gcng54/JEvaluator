package qmeasures.core;

/**
 * An interface for dimension enums that define valid operational ranges.
 */
public interface IDimension<E extends IDimension<E>> extends Clampable {

    String getSymbol();

    E getBaseDimension();

    IUnit<?> getBaseUnit();

    default String getClassName() { return this.getClass().getSimpleName();    }

    default boolean isCompatible(IDimension<?> other) {
        if (other == null) return false;
        E a = getBaseDimension();
        @SuppressWarnings("unchecked")
        E b = (E) other.getBaseDimension();
        return a != null && a.equals(b);
    }

}
