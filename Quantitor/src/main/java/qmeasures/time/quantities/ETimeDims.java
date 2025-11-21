
package qmeasures.time.quantities;

import qmeasures.core.Clampable;
import qmeasures.core.IDimension;
import qmeasures.time.units.ETimes;

/**
 * Enumeration of time dimensions (e.g., TIME, DURATION, PERIOD, FREQUENCY).
 * Each dimension defines its abbreviation and valid base value range (in seconds).
 * Use DURATION for elapsed time, PERIOD for cycles, FREQUENCY for rates.
 */
public enum ETimeDims implements IDimension<ETimeDims> {

    /** Generic time (seconds, unbounded) */
    TIME("s", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY),
    /** Duration (seconds, >= 0) */
    DURATION("s", 0.0, Double.POSITIVE_INFINITY),
    /** Period (seconds, >= 0) */
    PERIOD("s", 0.0, Double.POSITIVE_INFINITY),
    /** Frequency (Hz, >= 0) */
    FREQUENCY("Hz", 0.0, Double.POSITIVE_INFINITY);

    private final String abbreviation;
    private final double minBaseValue;
    private final double maxBaseValue;

    /**
     * Constructs a time dimension with abbreviation and min/max base values (in seconds).
     * @param abbreviation the abbreviation
     * @param minBaseValue minimum base value (seconds)
     * @param maxBaseValue maximum base value (seconds)
     */
    ETimeDims(String abbreviation, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.abbreviation = abbreviation;
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
    }

    /**
     * Gets the clamping mode for this dimension (WRAP).
     * @return the clamp mode
     */
    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; }
    
    /**
     * Gets the abbreviation for this dimension.
     * @return the abbreviation
     */
    @Override public String getAbbreviation(){ return abbreviation; }

    /**
     * Gets the minimum base value (seconds).
     * @return the minimum value
     */
    @Override public double getMinBase(){ return minBaseValue; }
    
    /**
     * Gets the maximum base value (seconds).
     * @return the maximum value
     */
    @Override public double getMaxBase(){  return maxBaseValue; }

    /**
     * Gets the base dimension (always TIME).
     * @return the base dimension
     */
    @Override public ETimeDims getBaseDimension(){  return ETimeDims.TIME; }

    /**
     * Gets the base unit (always SECOND).
     * @return the base unit
     */
    @Override public ETimes getBaseUnit(){ return ETimes.SECOND; }
}
