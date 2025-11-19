package qmeasures.angle;

import qmeasures.core.IDimension;
import qmeasures.core.Clampable;

public enum EAngleDims implements IDimension<EAngleDims> {

    // All Min Max must be BaseUnit (METERS)
    ANGLE("Ang", Double.MIN_VALUE, Double.MAX_VALUE),
    LATITUDE("Lat", -90.0, 90.0), // vertical angle
    LONGITUDE("Lon", -180.0, 180.0), // vertical angle
    BEARING("Brg", 0.0, 360.0), // horizontal angle
    AZIMUTH("Azi", 0.0, 360.0), // horizontal angle
    HEADING("Hdg", 0.0, 360.0), // direction of travel
    COURSE("Crs", 0.0, 360.0), // navigation course
    DIRECTION("Dir", 0.0, 360.0), // general direction
    ROTATION("Rot", 0.0, 360.0), // angular rotation
    ORIENTATION( "Orient", 0.0, 360.0); // compass orientation

    private final String symbol;
    
    private final double minBaseValue;

    private final double maxBaseValue;

    EAngleDims(String symbol, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
        this.symbol = symbol;
    }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };
    
    @Override public String getSymbol(){ return symbol; }

    @Override public double getMinBase(){ return minBaseValue; }
    
    @Override public double getMaxBase(){  return maxBaseValue; }

    @Override public EAngleDims getBaseDimension(){  return EAngleDims.ANGLE; };

    @Override public EAngles getBaseUnit(){ return EAngles.DEGREE; };
}

