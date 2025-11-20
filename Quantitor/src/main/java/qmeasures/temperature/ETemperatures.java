
package qmeasures.temperature;

import qmeasures.core.IUnit;

/**
 * Enumeration of temperature units (Kelvin, Celsius, Fahrenheit).
 * Provides conversion logic and symbols for each unit.
 */
public enum ETemperatures implements IUnit<ETemperatures> {
    /** Kelvin unit (base unit) */
    KELVIN("K", 1.0) {
        @Override
        public double toBaseValue(double value) { return value; }
        @Override
        public double fromBaseValue(double baseValue) { return baseValue; }
    },
    /** Celsius unit */
    CELCIUS("°C", 1.0) {
        @Override
        public double toBaseValue(double value) { return value + 273.15; }
        @Override
        public double fromBaseValue(double baseValue) { return baseValue - 273.15; }
    },
    /** Fahrenheit unit */
    FAHRENHEIT("°F", 5.0/9.0) {
        @Override
        public double toBaseValue(double value) { return (value - 32) * 5.0/9.0 + 273.15; }
        @Override
        public double fromBaseValue(double baseValue) { return (baseValue - 273.15) * 9.0/5.0 + 32; }
    };

    private final String symbol;
    private final double factor;

    /**
     * Constructs a temperature unit with the given symbol and conversion factor to Kelvin.
     * @param symbol the unit symbol
     * @param factor the conversion factor to Kelvin
     */
    ETemperatures(String symbol, double factor) {
        this.symbol = symbol;
        this.factor = factor;
    }

    /**
     * Gets the symbol for this unit.
     * @return the unit symbol
     */
    @Override
    public String getSymbol() { return symbol; }

    /**
     * Gets the conversion factor to Kelvin.
     * @return the factor
     */
    @Override
    public double getFactor() { return factor; }

    /**
     * Gets the base dimension for this unit (always KELVIN).
     * @return the base dimension
     */
    @Override
    public ETemperatureDims getBaseDimension() { return ETemperatureDims.KELVIN; }

    /**
     * Gets the base unit for this unit (always KELVIN).
     * @return the base unit
     */
    @Override
    public ETemperatures getBaseUnit() { return KELVIN; }
}
