
package qmeasures.pressure.quantities;

import qmeasures.core.Clampable;
import qmeasures.core.IDimension;
import qmeasures.pressure.units.EPressureUnit;

/**
 * Enumeration of pressure dimensions (e.g., PRESSURE).
 * Each dimension defines its abbreviation and valid base value range (in pascals).
 */
public enum EPressureDims implements IDimension<EPressureDims> {

    PRESSURE("Pa", 0.0, Double.POSITIVE_INFINITY);

    private final String abbreviation;
    private final double minBaseValue;
    private final double maxBaseValue;

    /**
     * Constructs a time dimension with abbreviation and min/max base values (in pascals).
     * @param abbreviation the abbreviation
     * @param minBaseValue minimum base value (pascals)
     * @param maxBaseValue maximum base value (pascals)
     */
    EPressureDims(String abbreviation, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.abbreviation = abbreviation;
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
    }

    /**
     * Gets the clamping mode for this dimension (BOUND).
     * @return the clamp mode
     */
    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; }
    
    /**
     * Gets the abbreviation for this dimension.
     * @return the abbreviation
     */
    @Override public String getAbbreviation(){ return abbreviation; }

    /**
     * Gets the minimum base value (watts).
     * @return the minimum value
     */
    @Override public double getMinBase(){ return minBaseValue; }
    
    /**
     * Gets the maximum base value (seconds).
     * @return the maximum value
     */
    @Override public double getMaxBase(){  return maxBaseValue; }

    /**
     * Gets the base dimension (always PRESSURE).
     * @return the base dimension
     */
    @Override public EPressureDims getBaseDimension(){  return EPressureDims.PRESSURE; }

    /**
     * Gets the base unit (always PASCAL).
     * @return the base unit
     */
    @Override public EPressureUnit getBaseUnit(){ return EPressureUnit.PASCAL; }
}
