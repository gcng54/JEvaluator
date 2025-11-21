package qmeasures.speed.quantities;

import qmeasures.speed.ESpeeds;

/**
 * Abstract base class for specific speed dimensions (e.g., Ground Speed, Air Speed).
 * This separates "Dimension" quantities from the generic "Unit" quantities.
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class ASpeedDim<Q extends ASpeedDim<Q>> extends ASpeed<Q> {

    protected ASpeedDim(double value, ESpeeds unit, ESpeedDims dimension) {
        super(value, unit, dimension);
    }

    protected ASpeedDim(ASpeed<?> speed, ESpeedDims dimension) {
        super(speed.getValue(), speed.getUnit(), dimension);
    }

    protected ASpeedDim(ASpeed<?> speed) {super(speed.getValue(), speed.getUnit(), ESpeedDims.SPEED);  }

	public Q of(ASpeed<?> speed){  return of(speed.getValue(), speed.getUnit()); };

}