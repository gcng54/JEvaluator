package qmeasures.core;

public interface Clampable {
    
    double getMinBase();
    
    double getMaxBase();

    enum EClampMode {
        NONE,
        MIN, // clamps to min only
        MAX,  // clamps to max only
        BOUND, // clamps to min/max
        CYCLE, // wraps around from max to min
        BOUNCE, // like cycle but reverses direction at min and max
        WRAP, // like cycle but offset by min value
        LATITUDE,   // like cycle  for Latitude (0 to 90, 90 to 0, 0 to -90, -90 to 0)
        LONGITUDE  // like cycle  for Longitude (-180 to 0, 0 to 180, -180 to 0, wrapping around)
    }

    default void validateMinMaxValues(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum value.");
        }
    }

    default EClampMode getClampMode() {
        return EClampMode.NONE;
    }

    default double getClampRange() {
        return getMaxBase() - getMinBase();
    }

    default boolean isClampingMode() {
        return getClampMode() != EClampMode.NONE;
    }

    default boolean isClampingRange() {
        return isClampingMode() && getClampRange() > 0;
    }

    default boolean inClampRange(double baseValue) {
        return isClampingRange() && baseValue >= getMinBase() && baseValue <= getMaxBase();
    }

    default boolean isEqualToMaxBase(double baseValue) {
        return isClampingRange() && baseValue == getMaxBase();
    }

    default boolean isEqualToMinBase(double baseValue) {
        return isClampingRange() && baseValue == getMinBase();
    }
    
    default double clampBaseValue(double baseValue) {
        if (inClampRange(baseValue)) return baseValue;
        switch (getClampMode()) {
            case MIN:
                return _clampAsMin(baseValue, getMinBase());
            case MAX:
                return _clampAsMax(baseValue, getMaxBase());
            case BOUND:
                return _clampAsBound(baseValue, getMinBase(), getMaxBase());
            case CYCLE:
            case WRAP:
                return _clampAsCycleOrWrap(baseValue, getMinBase(), getMaxBase());
            case BOUNCE:
                return _clampAsBounce(baseValue, getMinBase(), getMaxBase());
            case LATITUDE:
                return _clampAsLatitude(baseValue);
            case LONGITUDE:
                return _clampAsLongitude(baseValue);
            default:
                return baseValue;
        }
    }

    /** Clamps the value to a minimum. */
    private double _clampAsMin(double value, double min) {
        return Math.max(value, min);
    }

    /** Clamps the value to a maximum. */
    private double _clampAsMax(double value, double max) {
        return Math.min(value, max);
    }

    /** Clamps the value to be within the min/max bounds. */
    private double _clampAsBound(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }

    /** Wraps the value around the min/max range. */
    private double _clampAsCycleOrWrap(double value, double min, double max) {
        double range = max - min;
        // Avoid infinite loop if range is not positive
        if (range <= 0) return value;
        while (value < min) value += range;
        while (value > max) value -= range;
        return value;
    }

    /** Bounces the value back and forth within the min/max range. */
    private double _clampAsBounce(double value, double min, double max) {
        boolean ascending = true;
        while (value < min || value > max) {
            if (ascending) {
                value = max - (value - max);
            } else {
                value = min + (min - value);
            }
            ascending = !ascending;
        }
        return value;
    }

    /** Handles latitude-specific bouncing logic (-90 to 90 degrees). */
    private double _clampAsLatitude(double value) {
        double minLat = -90.0;
        double maxLat = 90.0;
        double rangeLat = maxLat - minLat;
        double cycleLat = 2 * rangeLat;
        
        double normalizedValue = value - minLat;
        double valueInCycle = normalizedValue % cycleLat;

        if (valueInCycle < 0) {
            valueInCycle += cycleLat;
        }

        if (valueInCycle <= rangeLat) {
            return minLat + valueInCycle;
        } else {
            return maxLat - (valueInCycle - rangeLat);
        }
    }

    /** Handles longitude-specific wrapping logic (-180 to 180 degrees). */
    private double _clampAsLongitude(double value) {
        // Normalize the longitude to the range (-180, 180]
        double remainder = value % 360;
        if (remainder <= -180) {
            return remainder + 360;
        }
        if (remainder > 180) {
            return remainder - 360;
        }
        return remainder;
    }

}