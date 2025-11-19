package qmeasures.time;

import qmeasures.core.Clampable;
import qmeasures.core.IDimension;

/**
 * Time-related quantity types with bounds expressed in seconds by convention.
 * Use duration when you're measuring how long something moves or operates. Speed = Distance / Duration
 * Use period when dealing with repetitive or cyclic motion, like waves, oscillations, or rotating systems. Speed = Wavelength / Period
 */
public enum ETimeDims implements IDimension<ETimeDims> {

    TIME("s", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY), // +/- 100 years
    DURATION("s", 0.0, Double.POSITIVE_INFINITY),
    PERIOD("s", 0.0, Double.POSITIVE_INFINITY),
    FREQUENCY("Hz", 0.0, Double.POSITIVE_INFINITY); // 1/second

    private final String symbol;
    
    private final double minBaseValue;

    private final double maxBaseValue;

    ETimeDims(String symbol, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.symbol = symbol;
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
    }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };
    
    @Override public String getSymbol(){ return symbol; }

    @Override public double getMinBase(){ return minBaseValue; }
    
    @Override public double getMaxBase(){  return maxBaseValue; }

    @Override public ETimeDims getBaseDimension(){  return ETimeDims.TIME; };

    @Override public ETimes getBaseUnit(){ return ETimes.SECOND; }
}
