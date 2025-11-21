
package qmeasures.length.quantities;

import qmeasures.core.IDimension;
import qmeasures.length.units.ELengths;
import qmeasures.core.Clampable;

/**
 * Enumeration of length dimensions (e.g., LENGTH, AREA, VOLUME).
 * Each dimension defines its abbreviation and valid base value range (in meters).
 */
public enum ELengthDims implements IDimension<ELengthDims> {

    /** Generic length (meters) */
    // Use a very large negative minimum instead of Double.MIN_VALUE (which is
    // the smallest positive double). This avoids unintentionally clamping
    // legitimate zero values up to a tiny positive number.
    LENGTH("Length", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY),
    /** Area (square meters) */
    AREA("Area", 0.0, Double.POSITIVE_INFINITY),
    /** Volume (cubic meters) */
    VOLUME("Volume", 0.0, Double.POSITIVE_INFINITY),
    /** Distance (meters, up to Earth's circumference) */
    DISTANCE("Dst", 0.0, 40_074_000.0),
    /** Altitude (meters, Dead Sea to 100 km) */
    ALTITUDE("Alt", -430.0, 100_000.0),
    /** Elevation (meters, Dead Sea to Everest) */
    RAKIM("Elev", -430.0, 8850.0),
    /** Height (meters, deep ocean to 1,000,000 m) */
    HEIGHT("Hgt", -11_000.0, 1_000_000.0),
    /** Depth (meters, deep ocean to surface) */
    DEPTH("Dpt", -11_000.0, 0.0),
    /** Range (meters, up to 10,000km) */
	RANGE( "Rng", 0.0, 10_000_000.0),
    /** Wavelength (meters, positive only) */
	WAVE_LENGTH("Wave", 0.0, Double.POSITIVE_INFINITY),
    /** Earth radius (meters) */
    EARTH_RADIUS("Earth", 6_300_000.0, 6_400_000.0);

    private final String abbreviation;
    private final double minBaseValue;
    private final double maxBaseValue;

    /**
     * Constructs a length dimension with abbreviation and min/max base values (in meters).
     * @param abbreviation the abbreviation
     * @param minBaseValue minimum base value (meters)
     * @param maxBaseValue maximum base value (meters)
     */
    ELengthDims(String abbreviation, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
        this.abbreviation = abbreviation;
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
     * Gets the minimum base value (meters).
     * @return the minimum value
     */
    @Override public double getMinBase(){ return minBaseValue; }
    
    /**
     * Gets the maximum base value (meters).
     * @return the maximum value
     */
    @Override public double getMaxBase(){  return maxBaseValue; }

    /**
     * Gets the base dimension (always LENGTH).
     * @return the base dimension
     */
    @Override public ELengthDims getBaseDimension(){  return ELengthDims.LENGTH; }

    /**
     * Gets the base unit (always METER).
     * @return the base unit
     */
    @Override public ELengths getBaseUnit(){ return ELengths.METER; }

}

