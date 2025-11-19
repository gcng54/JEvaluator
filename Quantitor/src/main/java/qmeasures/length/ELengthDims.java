package qmeasures.length;

import qmeasures.core.IDimension;
import qmeasures.core.Clampable;

public enum ELengthDims implements IDimension<ELengthDims> {

    // All Min Max must be BaseUnit (METERS)
    LENGTH("Length", Double.MIN_VALUE, Double.MAX_VALUE),
    AREA("Area", 0.0, Double.MAX_VALUE),
    VOLUME("Volume", 0.0, Double.MAX_VALUE),
    DISTANCE("Dst", 0.0, 40_074_000.0),
    ALTITUDE("Alt", -430.0, 100_000.0),
    ELEVATION("Elev", -430.0, 8850.0),
    HEIGHT("Hgt", -11_000.0, 1_000_000.0),
    DEPTH("Dpt", -11_000.0, 0.0),
	RANGE( "Rng", 0.0, 10_000_000.0),
	WAVE_LENGTH("Wave", 0.0, Double.POSITIVE_INFINITY),
    EARTHECTIC("Earth", 6_300_000.0, 6_400_000.0);

    private final String symbol;
    
    private final double minBaseValue;

    private final double maxBaseValue;

    ELengthDims(String symbol, double minBaseValue, double maxBaseValue) {
        validateMinMaxValues(minBaseValue, maxBaseValue);
        this.minBaseValue = minBaseValue;
        this.maxBaseValue = maxBaseValue;
        this.symbol = symbol;
    }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; };
    
    @Override public String getSymbol(){ return symbol; }

    @Override public double getMinBase(){ return minBaseValue; }
    
    @Override public double getMaxBase(){  return maxBaseValue; }

    @Override public ELengthDims getBaseDimension(){  return ELengthDims.LENGTH; };

    @Override public ELengths getBaseUnit(){ return ELengths.METER; };
}

