package qmeasures.speed;

import java.util.Locale;

import qmeasures.core.IUnit;

/**
 * Common length units with meter as base.
 */
public enum ESpeeds implements IUnit<ESpeeds> {
    METERS_PER_SECOND("m/s", 1.0),
    KILOMETERS_PER_HOUR("km/h", 0.277778),
    MILES_PER_HOUR("mph", 0.44704),
    KNOTS("kn", 0.514444);  // nautical miles per hour
    
    private final String symbol;

    private final double factor;

    ESpeeds(String symbol, double factor) {
        validateFactor(factor);
        this.factor = factor;
        this.symbol = symbol;
    }

    @Override public String getSymbol() { return symbol; }

    @Override public double getFactor() { return factor; }

    @Override public String toString() {
		return switch (this) {
            case KNOTS -> "knots";
            case METERS_PER_SECOND -> "meters/second";
            case KILOMETERS_PER_HOUR -> "kilometers/hour";
            case MILES_PER_HOUR -> "miles/hour";
		};
    }

    public static ESpeeds fromName(String name_) {	return ESpeeds.valueOf(name_.toUpperCase(Locale.ENGLISH));	}

    @Override public ESpeedDims getBaseDimension() { return ESpeedDims.SPEED; }

    @Override public ESpeeds getBaseUnit() { return ESpeeds.METERS_PER_SECOND; }

}

