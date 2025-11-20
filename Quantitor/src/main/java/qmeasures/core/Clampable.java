
package qmeasures.core;

/**
 * Interface for types that support clamping of values to a valid range.
 * Used by dimensions to enforce min/max bounds and special clamping logic.
 */
public interface Clampable {
    /**
     * Gets the minimum valid base value.
     * @return the minimum value
     */
    double getMinBase();
    /**
     * Gets the maximum valid base value.
     * @return the maximum value
     */
    double getMaxBase();

    /**
     * Enumeration of clamping modes for value handling.
     */
    enum EClampMode {
        NONE,      // No clamping
        MIN,       // Clamps to min only
        MAX,       // Clamps to max only
        BOUND,     // Clamps to min/max
        CYCLE,     // Wraps around from max to min
        BOUNCE,    // Like cycle but reverses direction at min and max
        WRAP,      // Like cycle but offset by min value
        LATITUDE,  // Special for Latitude (-90 to 90)
        LONGITUDE  // Special for Longitude (-180 to 180)
    }

    /**
     * Validates that min is not greater than max.
     * @param min the minimum value
     * @param max the maximum value
     */
    default void validateMinMaxValues(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum value.");
        }
    }

    /**
     * Gets the clamping mode for this type.
     * @return the clamp mode
     */
    default EClampMode getClampMode() {
        return EClampMode.NONE;
    }

    /**
     * Gets the range between min and max.
     * @return the clamp range
     */
    default double getClampRange() {
        return getMaxBase() - getMinBase();
    }

    /**
     * Returns true if clamping is enabled.
     * @return true if clamping
     */
    default boolean isClampingMode() {
        return getClampMode() != EClampMode.NONE;
    }

    /**
     * Returns true if the clamp range is positive and clamping is enabled.
     * @return true if clamping range is valid
     */
    default boolean isClampingRange() {
        return isClampingMode() && getClampRange() > 0;
    }

    /**
     * Returns true if the value is within the clamp range.
     * @param baseValue the value
     * @return true if in range
     */
    default boolean inClampRange(double baseValue) {
        return isClampingRange() && baseValue >= getMinBase() && baseValue <= getMaxBase();
    }

    /**
     * Returns true if the value is exactly the max base value.
     * @param baseValue the value
     * @return true if equal to max
     */
    default boolean isEqualToMaxBase(double baseValue) {
        return isClampingRange() && baseValue == getMaxBase();
    }

    /**
     * Returns true if the value is exactly the min base value.
     * @param baseValue the value
     * @return true if equal to min
     */
    default boolean isEqualToMinBase(double baseValue) {
        return isClampingRange() && baseValue == getMinBase();
    }
    
    /**
     * Clamps the value according to the clamp mode and min/max.
     * @param baseValue the value
     * @return the clamped value
     */
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