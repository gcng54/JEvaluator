package qmeasures.angle;


import java.util.Locale;
import java.util.Objects;

import qmeasures.core.IUnit;

/**
 * Common length units with meter as base.
 */
public enum EAngles implements IUnit<EAngles> {
    DEGREE("°", 1.0),
    RADIAN("rad", 57.29577951308232), //
    GRADIAN("gon", 0.9), // 1 grad = 0.9 degrees
    ARC_MINUTE("'", 1.0 / 60.0), // 1 arc minute = 1/60 degrees
    ARC_SECOND("\"", 1.0 / 3600.0); // 1 arc second = 1/3600 degrees

    
    private final String symbol;

    private final double factor;

    EAngles(String symbol, double factor) {
        validateFactor(factor);
        this.factor = factor;
        this.symbol = symbol;
    }

    @Override public String getSymbol() { return symbol; }

    @Override public double getFactor() { return factor; }

    @Override public String toString() {
        return IUnit.toSentenceCase(this.name()) + "s";
    }

    public static EAngles fromName(String name_) {
        Objects.requireNonNull(name_, "Name must not be null");
		return EAngles.valueOf(name_.toUpperCase(Locale.ENGLISH));
	}

    @Override public EAngleDims getBaseDimension() { return EAngleDims.ANGLE; }

    @Override public EAngles getBaseUnit() { return EAngles.DEGREE; }

}

