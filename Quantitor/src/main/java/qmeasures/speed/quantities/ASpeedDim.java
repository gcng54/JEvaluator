package qmeasures.speed.quantities;

import org.jetbrains.annotations.NotNull;

import qmeasures.speed.units.ESpeedUnit;

/**
 * Abstract base class for specific speed dimensions (e.g., Ground Speed, Air Speed).
 * This separates "Dimension" quantities from the generic "Unit" quantities.
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class ASpeedDim<Q extends ASpeedDim<Q>> extends ASpeed<Q> {

    protected ASpeedDim(double value, ESpeedUnit unit, ESpeedDims dimension) {
        super(value, unit, dimension);
    }

    protected ASpeedDim(@NotNull ASpeed<?> speed, ESpeedDims dimension) {
        super(speed.getValue(), speed.getUnit(), dimension);
    }

    protected ASpeedDim(@NotNull ASpeed<?> speed) {super(speed.getValue(), speed.getUnit(), ESpeedDims.SPEED);  }

	public Q of(@NotNull ASpeed<?> speed){  return of(speed.getValue(), speed.getUnit()); };

}