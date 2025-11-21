
package qmeasures.temperature.quantities;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;
import qmeasures.temperature.units.TCelsius;
import qmeasures.temperature.units.ETemperatures;
import qmeasures.temperature.units.TFahrenheit;
import qmeasures.temperature.units.TKelvin;

/**
 * Abstract base class for all temperature quantities (e.g., Kelvin, Celsius, Fahrenheit).
 * Provides unit conversion, dimension conversion, and arithmetic operations for temperatures.
 *
 * @param <Q> the concrete type of the temperature quantity
 */
public abstract class ATemperature<Q extends ATemperature<Q>> extends AQuantity<Q, ETemperatures, ETemperatureDims> {

    /**
     * Constructs a temperature quantity with the specified value, unit, and dimension.
     * @param value the value in the given unit
     * @param unit the temperature unit
     * @param dimension the temperature dimension
     */
    protected ATemperature(double value, ETemperatures unit, ETemperatureDims dimension) {  super(value, unit, dimension);  }

    /**
     * Constructs a temperature quantity with the specified value and dimension, using Kelvin as the unit.
     * @param value the value in Kelvin
     * @param dimension the temperature dimension
     */
    protected ATemperature(double value, ETemperatureDims dimension) {  super(value, ETemperatures.KELVIN, dimension);  }

    /**
     * Constructs a temperature quantity with the specified value, using Kelvin and KELVIN as defaults.
     * @param value the value in Kelvin
     */
    protected ATemperature(double value) {  super(value, ETemperatures.KELVIN, ETemperatureDims.KELVIN);  }

    /**
     * Creates a new instance of this temperature type with the given value and unit.
     * @param value the value
     * @param unit the unit
     * @return a new instance of Q
     */
    @Override public abstract Q of(double value, ETemperatures unit);

    /**
     * Gets the unit of this temperature quantity.
     * @return the temperature unit
     */
    @Override public ETemperatures getUnit() { return  super.getUnit(); }
    
    /**
     * Gets the dimension of this temperature quantity.
     * @return the temperature dimension
     */
    @Override public ETemperatureDims getDimension() { return  super.getDimension(); }

    /**
     * Returns the clamping mode for temperature quantities (BOUND).
     * @return the clamp mode
     */
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; }

    /**
     * Converts this temperature to another dimension (e.g., Kelvin, Celsius, Fahrenheit).
     * @param dimension the target dimension
     * @return a new temperature quantity of the target dimension
     */
    public ATemperature<?> toDimension(ETemperatureDims dimension) {
        return switch (dimension) {
            case TEMPERATURE ->  to(QTemperature.class);
            case KELVIN ->  to(TKelvin.class);
            case CELSIUS ->  to(TCelsius.class);
            case FAHRENHEIT ->  to(TFahrenheit.class);
        };
    }

    /**
     * Converts this temperature to a specific type using reflection.
     * @param targetType the target class
     * @return a new instance of the target type
     * @param <T> the type of temperature
     */
    public <T extends ATemperature<T>> T to(Class<T> targetType) {
        try {
            return targetType.getConstructor(double.class, ETemperatures.class)
                            .newInstance(this.getValue(), this.getUnit());
        } catch (Exception e) {
            throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
        }
    }

    // Unit conversion methods

    /** @return this temperature in Kelvin */
    public Q ofKelvin() { return this.of(ETemperatures.KELVIN); }
    /** @return this temperature in Celsius */
    public Q ofCelsius() { return this.of(ETemperatures.CELSIUS); }
    /** @return this temperature in Fahrenheit */
    public Q ofFahrenheit() { return this.of(ETemperatures.FAHRENHEIT); }

    // Unit conversion with value

    /** @return a new temperature in Kelvin */
    public Q ofKelvin(double value) { return this.of(value, ETemperatures.KELVIN); }
    /** @return a new temperature in Celsius */
    public Q ofCelsius(double value) { return this.of(value, ETemperatures.CELSIUS); }
    /** @return a new temperature in Fahrenheit */
    public Q ofFahrenheit(double value) { return this.of(value, ETemperatures.FAHRENHEIT); }

    // Get value in specific units

    /** @return the value in Kelvin */
    public double inKelvin() { return this.inUnit(ETemperatures.KELVIN); }
    /** @return the value in Celsius */
    public double inCelsius() { return this.inUnit(ETemperatures.CELSIUS); }
    /** @return the value in Fahrenheit */
    public double inFahrenheit() { return this.inUnit(ETemperatures.FAHRENHEIT); }
}
