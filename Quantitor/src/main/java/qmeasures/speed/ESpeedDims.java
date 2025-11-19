package qmeasures.speed;

import qmeasures.core.Clampable;
import qmeasures.core.IDimension;

/**
 * Time-related quantity types with bounds expressed in seconds by convention.
 * Use duration when you're measuring how long something moves or operates. Speed = Distance / Duration
 * Use period when dealing with repetitive or cyclic motion, like waves, oscillations, or rotating systems. Speed = Wavelength / Period
 */
public enum ESpeedDims implements IDimension<ESpeedDims> {
    SPEED("m/s", 0.0, Double.POSITIVE_INFINITY),
    FREQUENCY("Hz", 0.0, Double.POSITIVE_INFINITY),
    GROUND_SPEED("m/s", 0.0, 343.0),
    VERTICAL_SPEED("m/s",  -100.0, 100.0);


    private final String symbol;
    
    private final double minBaseValue;

    private final double maxBaseValue;

    ESpeedDims(String symbol, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.symbol = symbol;
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
    }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };
    
    @Override public String getSymbol(){ return symbol; }

    @Override public double getMinBase(){ return minBaseValue; }
    
    @Override public double getMaxBase(){  return maxBaseValue; }

    @Override public ESpeedDims getBaseDimension(){  return ESpeedDims.SPEED; };

    @Override public ESpeeds getBaseUnit(){ return ESpeeds.METERS_PER_SECOND; }
}
