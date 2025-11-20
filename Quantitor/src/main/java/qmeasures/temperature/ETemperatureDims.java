
package qmeasures.temperature;

import qmeasures.core.IDimension;

/**
 * Enumeration of temperature dimensions (Kelvin, Celsius, Fahrenheit).
 * Each dimension defines its abbreviation and valid base value range.
 */
public enum ETemperatureDims implements IDimension<ETemperatureDims> {
    /** Kelvin dimension (absolute temperature, >= 0) */
    KELVIN("K", 0, Double.POSITIVE_INFINITY),
    /** Celsius dimension (>= -273.15) */
    CELCIUS("°C", -273.15, Double.POSITIVE_INFINITY),
    /** Fahrenheit dimension (>= -459.67) */
    FAHRENHEIT("°F", -459.67, Double.POSITIVE_INFINITY);

    private final String abbrev;
    private final double minBase;
    private final double maxBase;

    /**
     * Constructs a temperature dimension with abbreviation and min/max base values.
     * @param abbrev the abbreviation
     * @param minBase minimum base value
     * @param maxBase maximum base value
     */
    ETemperatureDims(String abbrev, double minBase, double maxBase) {
        this.abbrev = abbrev;
        this.minBase = minBase;
        this.maxBase = maxBase;
    }

    /**
     * Gets the abbreviation for this dimension.
     * @return the abbreviation
     */
    @Override
    public String getAbbrevation() { return abbrev; }

    /**
     * Gets the base dimension (always KELVIN).
     * @return the base dimension
     */
    @Override
    public ETemperatureDims getBaseDimension() { return KELVIN; }

    /**
     * Gets the base unit (always KELVIN).
     * @return the base unit
     */
    @Override
    public qmeasures.core.IUnit<?> getBaseUnit() { return qmeasures.temperature.ETemperatures.KELVIN; }

    /**
     * Gets the minimum base value.
     * @return the minimum value
     */
    @Override
    public double getMinBase() { return minBase; }

    /**
     * Gets the maximum base value.
     * @return the maximum value
     */
    @Override
    public double getMaxBase() { return maxBase; }
}
