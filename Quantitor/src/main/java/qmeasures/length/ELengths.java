package qmeasures.length;


import java.util.Locale;
import java.util.Objects;

import qmeasures.core.IUnit;

/**
 * Common length units with meter as base.
 */
public enum ELengths implements IUnit<ELengths> {
    METER("m", 1.0),
    KILOMETER("km", 1_000.0),
    MILLIMETER("mm", 0.001),
    MILE("mi", 1609.344),
    YARD("yd", 0.9144),
    FOOT("ft", 0.3048),
    INCH("in", 0.0254),
    NAUTMILE("NM", 1852.0),
    DATAMILE("DM", 1828.8), // 1 DM = 6000 feet
    FLIGHTLEVEL("FL", 30.48); // 1 FL = 100 feet
    
    private final String symbol;

    private final double factor;

    ELengths(String symbol, double factor) {
        validateFactor(factor);
        this.factor = factor;
        this.symbol = symbol;
    }

    public String getSymbol() { return symbol; }

    public double getFactor() { return factor; }

    @Override
    public String toString() {
		return switch (this) {
            case FOOT -> "Feet";
            case INCH -> "Inches";
            case FLIGHTLEVEL -> "FlightLevel";
            default -> IUnit.toSentenceCase(this.name()) + "s";
		};
    }

    public static ELengths fromName(String name_) {
        Objects.requireNonNull(name_, "Name must not be null");
		return ELengths.valueOf(name_.toUpperCase(Locale.ENGLISH));
	}

    public ELengthDims getBaseDimension() { return ELengthDims.LENGTH; }

    public ELengths getBaseUnit() { return ELengths.METER; }

}

