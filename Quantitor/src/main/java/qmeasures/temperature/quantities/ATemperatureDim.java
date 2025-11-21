package qmeasures.temperature.quantities;

import org.jetbrains.annotations.NotNull;

import qmeasures.temperature.units.ETemperatures;

/**
 * Abstract base class for specific temperature dimensions (e.g., Celsius, Fahrenheit).
 * This separates "Dimension" quantities from the generic "Unit" quantities.
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class ATemperatureDim<Q extends ATemperatureDim<Q>> extends ATemperature<Q> {

    protected ATemperatureDim(double value, ETemperatures unit, ETemperatureDims dimension) {
        super(value, unit, dimension);
    }

    protected ATemperatureDim(@NotNull ATemperature<?> temperature, ETemperatureDims dimension) {
        super(temperature.getValue(), temperature.getUnit(), dimension);
    }

    protected ATemperatureDim(@NotNull ATemperature<?> temperature) {super(temperature.getValue(), temperature.getUnit(), ETemperatureDims.TEMPERATURE);  }
    
	public Q of(@NotNull ATemperature<?> temperature){  return of(temperature.getValue(), temperature.getUnit()); };

}