package qmeasures.core;

public interface IQuantity<Q extends IQuantity<Q, U, E>, U extends IUnit<?>, E extends IDimension<?>> extends Comparable<Q> {

    double getBaseValue();

    U getUnit() ;

    E getDimension() ;

    Q of(double value, U unit);

    Double getValue() { return getUnit().fromBaseValue(getBaseValue()); }

    default double getClampedBaseValue() { return getDimension().getClampedBaseValue(getBaseValue());   }

    default Double getClampedValue() { return getUnit().fromBaseValue(getClampedBaseValue());  }

    default boolean isClamped() { return getBaseValue() != getClampedBaseValue(); }

    default String getSymbol() { return getUnit().getSymbol(); }

    default  boolean isEqualMaxBaseValue() { return getDimension().isEqualMaxBaseValue(getBaseValue());  }

    default  boolean isEqualMinBaseValue() { return getDimension().isEqualMinBaseValue(getBaseValue());  }

    default Q of(Double value){ return this.of(value, getUnit()); }

	default Double of(U targetUnit) { return targetUnit.fromBaseValue(getBaseValue());	}



}
