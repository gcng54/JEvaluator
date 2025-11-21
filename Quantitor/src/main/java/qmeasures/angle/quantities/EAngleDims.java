/**
 * Enumeration of angle dimensions (e.g., ANGLE, LATITUDE, LONGITUDE, BEARING, etc.).
 * Each dimension defines its abbreviation and valid base value range (in degrees).
 */
package qmeasures.angle.quantities;

import qmeasures.core.IDimension;
import qmeasures.angle.units.EAngles;
import qmeasures.core.Clampable;

public enum EAngleDims implements IDimension<EAngleDims> {

    /** Generic angle (degrees, unbounded) */
    ANGLE("Ang", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY),
    /** Latitude (degrees, -90 to 90) */
    LATITUDE("Lat", -90.0, 90.0),
    /** Longitude (degrees, -180 to 180) */
    LONGITUDE("Lon", -180.0, 180.0),
    /** Bearing (degrees, 0 to 360) is the direction from one point to another as Azimuth */
    BEARING("Brg", 0.0, 360.0),
    /** Azimuth (degrees, 0 to 360) is the angle from a reference direction (usually North) */
    AZIMUTH("Azi", 0.0, 360.0),
    /** Heading (degrees, 0 to 360) Heading is the direction a vehicle is pointing  */
    HEADING("Hdg", 0.0, 360.0),
    /** Direction (degrees, 0 to 360) is a general term for angle measurement */
    DIRECTION("Dir", 0.0, 360.0),
    /** Rotation (degrees, 0 to 360) is a full circular movement of an object */
    ROTATION("Rot", 0.0, 360.0),
    /** Inclination (degrees, -90 to 90) is the angle of tilt from the horizontal plane as Elevation*/
    INCLINATION("Inc", -90.0, 90.0),
    /** Elevation (degrees, -90 to 90) is the angle above the horizon as Inclination*/
    ELEVATION("Elev", -90.0, 90.0),
    /** Orientation (degrees, 0 to 360) describes the angular position of an object*/
    ORIENTATION("Ori", 0.0, 360.0);


    
    private final String symbol;
    private final double minBaseValue;
    private final double maxBaseValue;

    /**
     * Constructs an angle dimension with abbreviation and min/max base values (in degrees).
     * @param symbol the abbreviation
     * @param minBaseValue minimum base value (degrees)
     * @param maxBaseValue maximum base value (degrees)
     */
    EAngleDims(String symbol, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
        this.symbol = symbol;
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
    @Override public String getAbbreviation(){ return symbol; }

    /**
     * Gets the minimum base value (degrees).
     * @return the minimum value
     */
    @Override public double getMinBase(){ return minBaseValue; }

    /**
     * Gets the maximum base value (degrees).
     * @return the maximum value
     */
    @Override public double getMaxBase(){  return maxBaseValue; }

    /**
     * Gets the base dimension (always ANGLE).
     * @return the base dimension
     */
    @Override public EAngleDims getBaseDimension(){  return EAngleDims.ANGLE; }

    /**
     * Gets the base unit (always DEGREE).
     * @return the base unit
     */
    @Override public EAngles getBaseUnit(){ return EAngles.DEGREE; }
}
