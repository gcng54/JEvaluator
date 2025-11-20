package qmeasures.angle;


import java.util.Locale;
import java.util.Objects;

import qmeasures.core.IUnit;


/**
 * Enumeration of angle units (e.g., degree, radian, turn, gradian, arcminute, arcsecond).
 * Provides conversion factors and symbols for each unit.
 */
public enum EAngles implements IUnit<EAngles> {
    /** Degree (base unit) */
    DEGREE("\u00b0", 1.0),
    /** Radian (1 radian =  57.29577951308232 degrees) */
    RADIAN("rad", 57.29577951308232), // Math.PI / 180.0
    /** Turn (1 turn = 360 degrees) */
    TURN("turn", 360.0),
    /** Gradian (1 grad = 0.9 degrees) */
    GRADIAN("gon", 0.9),
    /** Arc minute (1 arcmin = 1/60 degrees) */
    ARC_MINUTE("'", 1.0 / 60.0),
    /** Arc second (1 arcsec = 1/3600 degrees) */
    ARC_SECOND("\"", 1.0 / 3600.0);
    
    private final String symbol;
    private final double factor;

    /**
     * Constructs an angle unit with the given symbol and conversion factor to degrees.
     * @param symbol the unit symbol
     * @param factor the conversion factor to degrees
     */
    EAngles(String symbol, double factor) {
        validateFactor(factor);
        this.factor = factor;
        this.symbol = symbol;
    }

    /**
     * Gets the symbol for this unit.
     * @return the unit symbol
     */
    @Override public String getSymbol() { return symbol; }

    /**
     * Gets the conversion factor to degrees.
     * @return the factor
     */
    @Override public double getFactor() { return factor; }

    /**
     * Returns a human-readable string for this unit.
     * @return the unit name
     */
    @Override public String toString() {
        return IUnit.toSentenceCase(this.name()) + "s";
    }

    /**
     * Gets the enum value from a string name (case-insensitive).
     * @param name_ the name
     * @return the EAngles value
     */
    public static EAngles fromName(String name_) {
        Objects.requireNonNull(name_, "Name must not be null");
        return EAngles.valueOf(name_.toUpperCase(Locale.ENGLISH));
    }

    /**
     * Gets the base dimension for this unit (always ANGLE).
     * @return the base dimension
     */
    @Override public EAngleDims getBaseDimension() { return EAngleDims.ANGLE; }

    /**
     * Gets the base unit for this unit (always DEGREE).
     * @return the base unit
     */
    @Override public EAngles getBaseUnit() { return EAngles.DEGREE; }

}

