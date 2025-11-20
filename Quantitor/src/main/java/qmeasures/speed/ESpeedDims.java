package qmeasures.speed;

import qmeasures.core.Clampable;
import qmeasures.core.IDimension;

/**
 * Enumeration of speed dimensions (e.g., SPEED, GROUND_SPEED, SEA_SPEED, AIR_SPEED).
 * Each dimension defines its abbreviation and valid base value range (in m/s).
 */
public enum ESpeedDims implements IDimension<ESpeedDims> {
    /** Generic speed (m/s, >= 0) */
    SPEED("m/s", 0.0, Double.POSITIVE_INFINITY),
    /** Ground speed (m/s, 0 to 343) */
    GROUND_SPEED("m/s", 0.0, 343.0),
    /** Sea speed (m/s, >= 0) */
    SEA_SPEED("m/s", 0.0, Double.POSITIVE_INFINITY),
    /** Air speed (m/s, >= 0) */
    AIR_SPEED("m/s", 0.0, Double.POSITIVE_INFINITY);

    private final String abbreviation;
    private final double minBaseValue;
    private final double maxBaseValue;

    /**
     * Constructs a speed dimension with abbreviation and min/max base values (in m/s).
     * @param abbreviation the abbreviation
     * @param minBaseValue minimum base value (m/s)
     * @param maxBaseValue maximum base value (m/s)
     */
    ESpeedDims(String abbreviation, double minBaseValue, double maxBaseValue) {
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
     * Gets the minimum base value (m/s).
     * @return the minimum value
     */
    @Override public double getMinBase(){ return minBaseValue; }

    /**
     * Gets the maximum base value (m/s).
     * @return the maximum value
     */
    @Override public double getMaxBase(){  return maxBaseValue; }

    /**
     * Gets the base dimension (always SPEED).
     * @return the base dimension
     */
    @Override public ESpeedDims getBaseDimension(){  return ESpeedDims.SPEED; }

    /**
     * Gets the base unit (always METERS_PER_SECOND).
     * @return the base unit
     */
    @Override public ESpeeds getBaseUnit(){ return ESpeeds.METERS_PER_SECOND; }
}
