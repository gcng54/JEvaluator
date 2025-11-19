package qmeasures.core;

public interface IQuantity<Q extends IQuantity<Q, U, E>, U extends IUnit<?>, E extends IDimension<?>> extends Comparable<Q> {

    double getBaseValue();

    U getUnit() ;

    E getDimension() ;

    Q of(Double value, U unit);

    default Q of(Double value){ return this.of(value, getUnit()); }

	default Q of(U unit) {  return of(unit.fromBaseValue(getBaseValue()), unit);   }

    default Double inUnit(U unit) { return unit.fromBaseValue(getBaseValue()); }
    
    default Double getValue() { return getUnit().fromBaseValue(getBaseValue()); }

    default double getBaseValueClamped() { return getDimension().getBaseValueClamped(getBaseValue());   }

    default Double getValueClamped() { return getUnit().fromBaseValue(getBaseValueClamped());  }

    default boolean isClamped() { return getBaseValue() != getBaseValueClamped(); }

    default String getUnitName() { return getUnit().getClassName(); }

    default String getUnitSymbol() { return getUnit().getSymbol(); }

    default String getDimensionName() { return getDimension().getClassName(); }

    default String getDimensionSymbol() { return getDimension().getSymbol(); }

    default  boolean isMaxBaseValue() { return getDimension().isEqualToMaxBase(getBaseValue());  }

    default  boolean isMinBaseValue() { return getDimension().isEqualToMinBase(getBaseValue());  }

}
